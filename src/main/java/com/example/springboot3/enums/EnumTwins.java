package com.example.springboot3.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumTwins {
    MALE(1, "男"),
    FEMALE(2, "女");

    @EnumValue //将注解所标识的属性的值存储到数据库中
    private int sex;
    private String sexName;

    EnumTwins(Integer sex, String sexName) {
        this.sex = sex;
        this.sexName = sexName;
    }
}
