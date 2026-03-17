package com.example.springboot3.dto.user;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class UserQueryDTO {
    private String name;
    private Integer age;
    private Integer pageNum = 1;   // 默认页码
    private Integer pageSize = 10; // 默认每页大小

    @Override
    public String toString() {
        return "UserQueryDTO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}