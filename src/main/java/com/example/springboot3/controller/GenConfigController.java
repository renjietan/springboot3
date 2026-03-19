package com.example.springboot3.controller;

import com.example.springboot3.entity.GenConfig;
import com.example.springboot3.service.IGenConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * 代码生成基础配置表 Controller
 * @author tanrenjie
 */
@RestController
@RequestMapping("/genConfig")
public class GenConfigController {

    @Autowired
    private IGenConfigService genConfigService;

    @GetMapping("/{id}")
    public GenConfig getById(@PathVariable("id") Long id) {
        return genConfigService.getById(id);
    }

    @GetMapping("/list")
    public List<GenConfig> listAll() {
        return genConfigService.listAll();
    }

    @PostMapping
    public void save(@RequestBody GenConfig entity) {
            genConfigService.save(entity);
    }

    @PutMapping
    public void update(@RequestBody GenConfig entity) {
            genConfigService.update(entity);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
            genConfigService.deleteById(id);
    }
}