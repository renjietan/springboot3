package com.example.springboot3.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Data
@TableName("user")
public class UserEntity {
    private String id;

    private String name;

    private Integer age;

    private String email;

    @TableField(fill = FieldFill.INSERT)  // 插入时自动填充
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(fill = FieldFill.INSERT)
    @TableLogic  // 逻辑删除字段
    private Integer deleted;

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                '}';
    }
}
