package com.example.springboot3.utils.codeGen.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ColumnInfo {
    private String columnName;      // 数据库列名
    private String fieldName;       // 属性名（驼峰）
    private String fieldType;       // Java 类型（如 String, Integer, Date）
    private String columnComment;   // 列注释
    private boolean isPrimaryKey;   // 是否主键
    private boolean nullable;       // 是否可为空
    // getters and setters
}