package com.example.springboot3.dto.user;

import lombok.Data;

@Data
public class UserQueryDTO {
    private String name;
    private Integer age;
    private Integer pageNum = 1;   // 默认页码
    private Integer pageSize = 10; // 默认每页大小

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

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