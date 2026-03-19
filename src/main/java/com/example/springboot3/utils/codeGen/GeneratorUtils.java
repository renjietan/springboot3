package com.example.springboot3.utils.codeGen;

import java.util.HashMap;
import java.util.Map;

public class GeneratorUtils {
    private static final Map<String, String> TYPE_MAP = new HashMap<>();

    static {
        TYPE_MAP.put("varchar", "String");
        TYPE_MAP.put("char", "String");
        TYPE_MAP.put("text", "String");
        TYPE_MAP.put("tinyint", "Integer");
        TYPE_MAP.put("smallint", "Integer");
        TYPE_MAP.put("int", "Integer");
        TYPE_MAP.put("bigint", "Long");
        TYPE_MAP.put("decimal", "BigDecimal");
        TYPE_MAP.put("float", "Float");
        TYPE_MAP.put("double", "Double");
        TYPE_MAP.put("boolean", "Boolean");
        TYPE_MAP.put("date", "Date");
        TYPE_MAP.put("time", "Date");
        TYPE_MAP.put("datetime", "Date");
        TYPE_MAP.put("timestamp", "Date");
        // 其他类型按需添加
    }

    /**
     * 将数据库类型转换为 Java 类型（全类名）
     */
    public static String dbTypeToJavaType(String dbType) {
        String lowerDbType = dbType.toLowerCase();
        for (Map.Entry<String, String> entry : TYPE_MAP.entrySet()) {
            if (lowerDbType.startsWith(entry.getKey())) {
                return entry.getValue();
            }
        }
        return "String"; // 默认
    }

    /**
     * 下划线转驼峰 (首字母小写)
     */
    public static String underlineToCamel(String underline) {
        if (underline == null || underline.isEmpty()) {
            return "";
        }
        String[] parts = underline.split("_");
        StringBuilder camel = new StringBuilder(parts[0].toLowerCase());
        for (int i = 1; i < parts.length; i++) {
            if (!parts[i].isEmpty()) {
                camel.append(parts[i].substring(0, 1).toUpperCase())
                        .append(parts[i].substring(1).toLowerCase());
            }
        }
        return camel.toString();
    }

    /**
     * 首字母大写
     */
    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    /**
     * 获取包路径对应的文件系统路径（将包名中的点替换为文件分隔符）
     */
    public static String packageToPath(String packageName) {
        return packageName.replace('.', '/');
    }
}