package com.example.springboot3.controller;

import com.example.springboot3.entity.GenFieldConfig;
import com.example.springboot3.service.IGenFieldConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * 代码生成字段配置表 Controller
 * @author tanrenjie
 */
@RestController
@RequestMapping("/genFieldConfig")
public class GenFieldConfigController {

    @Autowired
    private IGenFieldConfigService genFieldConfigService;

    @GetMapping("/{id}")
    public GenFieldConfig getById(@PathVariable("id") Long id) {
        return genFieldConfigService.getById(id);
    }

    @GetMapping("/list")
    public List<GenFieldConfig> listAll() {
        return genFieldConfigService.listAll();
    }

    @PostMapping
    public void save(@RequestBody GenFieldConfig entity) {
            genFieldConfigService.save(entity);
    }

    @PutMapping
    public void update(@RequestBody GenFieldConfig entity) {
            genFieldConfigService.update(entity);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
            genFieldConfigService.deleteById(id);
    }
}