package com.example.springboot3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MPGenerator {
    @Value("server.tomcat.uri-encoding")
    static String ec;

    @Test
    public void main() {
        // 1. 配置数据库连接
        System.out.println("============================" + ec);

//        String url = "jdbc:mysql://localhost:3306/springboot3?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
//        String username = "root";
//        String password = "123456";
//
//        // 2. 配置包名和输出目录
//        String projectPath = System.getProperty("user.dir"); // 获取项目根目录
//        String parentPackage = "com.example.springboot3"; // 父包名
//        String moduleName = "system"; // 模块名，可选
//        String author = "tanrenjie"; // 作者
//
//        FastAutoGenerator.create(url, username, password)
//                // ---------- 全局配置 ----------
//                .globalConfig(builder -> {
//                    builder.author(author) // 设置作者
//                            .outputDir(projectPath + "/src/main/java") // 输出目录
//                            .disableOpenDir() // 生成后不打开输出目录
//                            .commentDate("yyyy-MM-dd"); // 注释日期格式
//                })
//                // ---------- 包配置 ----------
//                .packageConfig(builder -> {
//                    builder.parent(parentPackage) // 父包名
//                            .moduleName(moduleName) // 父包模块名，会生成在父包下
//                            .entity("entity") // 实体类包名
//                            .service("service") // service包名
//                            .serviceImpl("service.impl") // serviceImpl包名
//                            .mapper("mapper") // mapper包名
//                            .xml("mapper.xml") // xml文件包名
//                            .controller("controller") // controller包名
//                            .pathInfo(Collections.singletonMap(OutputFile.xml, projectPath + "/src/main/resources/mapper")); // 设置mapper.xml文件的生成路径
//                })
//                // ---------- 策略配置 ----------
//                .strategyConfig(builder -> {
//                    // 设置需要生成的表名，支持多表，如 Arrays.asList("user", "role")
//                    builder.addInclude("user", "role")
//                            .addTablePrefix("t_", "sys_") // 过滤表前缀，如 t_user 会生成 User 实体
//
//                            // Entity 策略配置
//                            .entityBuilder()
//                            .enableLombok() // 开启 Lombok
//                            .naming(NamingStrategy.underline_to_camel) // 表名下划线转驼峰命名
//                            .columnNaming(NamingStrategy.underline_to_camel) // 列名下划线转驼峰命名
//                            .enableTableFieldAnnotation() // 启用字段注解 @TableField
//
//                            // Controller 策略配置
//                            .controllerBuilder()
//                            .enableRestStyle() // 开启 RestController 风格
//                            .enableHyphenStyle() // 开启驼峰转连字符
//
//                            // Service 策略配置
//                            .serviceBuilder()
//                            .formatServiceFileName("%sService") // 格式化 service 接口名称
//                            .formatServiceImplFileName("%sServiceImpl") // 格式化 service 实现类名称
//
//                            // Mapper 策略配置
//                            .mapperBuilder()
//                            .enableBaseResultMap() // 生成通用的 resultMap
//                            .enableBaseColumnList(); // 生成通用的 columnList
//                })
//                // ---------- 模板引擎配置 ----------
//                .templateEngine(new FreemarkerTemplateEngine()) // 使用 Freemarker 引擎
//                .execute(); // 执行生成
    }
}
