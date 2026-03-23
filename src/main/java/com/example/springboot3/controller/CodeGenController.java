package com.example.springboot3.controller;

import com.example.springboot3.dto.codeGen.CodeGenDTO;
import com.example.springboot3.dto.codeGen.CodeGenItemDTO;
import com.example.springboot3.utils.codeGen.CodeGenerator;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name="代码生成")
@RestController
@RequestMapping("/cg")
public class CodeGenController {
    @Autowired
    private CodeGenerator codeGenerator;

    @PostMapping
    public void CodeGen(@RequestBody @Valid CodeGenDTO dto) {
        // gen_config、gen_field_config
        List<String> list = dto.getData().stream().map(CodeGenItemDTO::getTableName).toList();
        codeGenerator.generate(list);
    }
}
