package com.example.springboot3.utils.codeGen.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TableInfo {
    private String tableName;      // 数据库表名
    private String className;       // 生成的类名（首字母大写）
    private String classComment;    // 类注释（例如表备注）
    private String packageName;     // 包名
    private List<ColumnInfo> columns; // 列信息列表

    // getters and setters
}
