package com.example.springboot3;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.springboot3.mapper") // 替换为你的 Mapper 包路径
public class Springboot3Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot3Application.class, args);
    }

}
