package com.example.springboot3.utils.codeGen;

import com.example.springboot3.utils.codeGen.model.ColumnInfo;
import com.example.springboot3.utils.codeGen.model.TableInfo;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class CodeGenerator {

    private static final Logger log = LoggerFactory.getLogger(CodeGenerator.class);

    @Autowired
    private VelocityEngine velocityEngine;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 生成代码的根路径（可以在 application.yml 中配置）
    @Value("${generator.outputDir:./generated-code}")
    private String outputDir;

    // 基础包名（例如 com.example.demo）
    @Value("${generator.basePackage:com.example.demo}")
    private String basePackage;

    // 作者
    @Value("${generator.author:generator}")
    private String author;

    /**
     * 生成代码入口
     * @param tableNames 表名列表
     */
    public void generate(List<String> tableNames) {
        for (String tableName : tableNames) {
            TableInfo tableInfo = getTableInfo(tableName);
            generateEntity(tableInfo);
            generateMapper(tableInfo);
            generateService(tableInfo);
            generateServiceImpl(tableInfo);
            generateController(tableInfo);
        }
    }

    /**
     * 从数据库获取表结构信息
     */
    private TableInfo getTableInfo(String tableName) {
        TableInfo tableInfo = new TableInfo();
        tableInfo.setTableName(tableName);
        // 类名：将表名转换为驼峰并首字母大写（可自定义规则）
        String className = GeneratorUtils.underlineToCamel(tableName);
        tableInfo.setClassName(GeneratorUtils.capitalize(className));
        // 包名：basePackage + 模块名（此处简化为 basePackage）
        tableInfo.setPackageName(basePackage);
        // 获取表注释（MySQL 示例）
        String tableCommentSql = "SELECT table_comment FROM information_schema.tables WHERE table_name = ?";
        String tableComment = jdbcTemplate.queryForObject(tableCommentSql, new Object[]{tableName}, String.class);
        tableInfo.setClassComment(tableComment);

        // 获取列信息
        String columnsSql = "SELECT column_name, data_type, column_comment, is_nullable, column_key " +
                "FROM information_schema.columns WHERE table_name = ? ORDER BY ordinal_position";
        List<Map<String, Object>> columnMaps = jdbcTemplate.queryForList(columnsSql, tableName);
        List<ColumnInfo> columnInfos = new ArrayList<>();
        for (Map<String, Object> colMap : columnMaps) {
            ColumnInfo col = new ColumnInfo();
            String colName = (String) colMap.get("column_name");
            col.setColumnName(colName);
            col.setFieldName(GeneratorUtils.underlineToCamel(colName));
            String dbType = (String) colMap.get("data_type");
            col.setFieldType(GeneratorUtils.dbTypeToJavaType(dbType));
            col.setColumnComment((String) colMap.get("column_comment"));
            col.setNullable("YES".equals(colMap.get("is_nullable")));
            col.setPrimaryKey("PRI".equals(colMap.get("column_key")));
            columnInfos.add(col);
        }
        tableInfo.setColumns(columnInfos);
        return tableInfo;
    }

    /**
     * 生成实体类
     */
    private void generateEntity(TableInfo tableInfo) {
        String templateName = "templates/velocity/entity.java.vm";
        String filePath = buildFilePath(tableInfo, "entity", tableInfo.getClassName() + ".java");
        generateFile(templateName, tableInfo, filePath);
    }

    /**
     * 生成 Mapper 接口
     */
    private void generateMapper(TableInfo tableInfo) {
        String templateName = "templates/velocity/mapper.java.vm";
        String filePath = buildFilePath(tableInfo, "mapper", tableInfo.getClassName() + "Mapper.java");
        generateFile(templateName, tableInfo, filePath);
    }

    /**
     * 生成 Service 接口
     */
    private void generateService(TableInfo tableInfo) {
        String templateName = "templates/velocity/service.java.vm";
        String filePath = buildFilePath(tableInfo, "service", "I" + tableInfo.getClassName() + "Service.java");
        generateFile(templateName, tableInfo, filePath);
    }

    /**
     * 生成 Service 实现类
     */
    private void generateServiceImpl(TableInfo tableInfo) {
        String templateName = "templates/velocity/serviceImpl.java.vm";
        String filePath = buildFilePath(tableInfo, "service.impl", tableInfo.getClassName() + "ServiceImpl.java");
        generateFile(templateName, tableInfo, filePath);
    }

    /**
     * 生成 Controller
     */
    private void generateController(TableInfo tableInfo) {
        String templateName = "templates/velocity/controller.java.vm";
        String filePath = buildFilePath(tableInfo, "controller", tableInfo.getClassName() + "Controller.java");
        generateFile(templateName, tableInfo, filePath);
    }

    /**
     * 根据表信息、子包名和文件名构建完整的输出路径
     */
    private String buildFilePath(TableInfo tableInfo, String subPackage, String fileName) {
        // 例如：outputDir + / + basePackage的路径 + / + subPackage + / + fileName
        String packagePath = GeneratorUtils.packageToPath(tableInfo.getPackageName() + "." + subPackage);
        File dir = new File(outputDir, packagePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return new File(dir, fileName).getAbsolutePath();
    }

    /**
     * 执行模板合并并输出文件
     */
    private void generateFile(String templateName, TableInfo tableInfo, String outputPath) {
        try {
            Template template = velocityEngine.getTemplate(templateName, "UTF-8");
            VelocityContext context = new VelocityContext();
            context.put("table", tableInfo);
            context.put("author", author);
            context.put("date", new java.util.Date().toString());
            // 可以添加其他工具类，例如 StringUtils 等
            context.put("tool", new GeneratorUtils()); // 若模板中需要调用工具方法

            StringWriter writer = new StringWriter();
            template.merge(context, writer);
            String content = writer.toString();

            try (FileWriter fileWriter = new FileWriter(outputPath)) {
                fileWriter.write(content);
            }
            log.info("生成文件：{}", outputPath);
        } catch (Exception e) {
            log.error("生成文件失败，模板：{}", templateName, e);
        }
    }
}