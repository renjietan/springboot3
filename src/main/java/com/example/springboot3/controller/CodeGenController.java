package com.example.springboot3.controller;

import com.example.springboot3.utils.codeGen.CodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/cg")
public class CodeGenController {
    @Autowired
    private CodeGenerator codeGenerator;

    @PostMapping
    public void CodeGen() {
        /*InputStream is = getClass().getClassLoader().getResourceAsStream("templates/velocity/controller.java.vm");
        System.out.println("Stream: " + is);*/ // 如果为 null，说明文件不在 classpath 中
        codeGenerator.generate(Arrays.asList("gen_config", "gen_field_config"));
    }
}
