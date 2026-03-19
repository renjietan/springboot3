package com.example.springboot3;

import com.example.springboot3.utils.codeGen.CodeGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;


@SpringBootTest
class Springboot3ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private CodeGenerator codeGenerator;

    @Test
    void testGenerate() {
        // 指定要生成的表名
        codeGenerator.generate(Arrays.asList("gen_config", "gen_field_config"));
    }

}
