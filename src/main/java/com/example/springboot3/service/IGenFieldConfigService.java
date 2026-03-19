package com.example.springboot3.service;

import com.example.springboot3.entity.GenFieldConfig;
import java.util.List;

/**
 * 代码生成字段配置表 Service 接口
 * @author tanrenjie
 */
public interface IGenFieldConfigService {

    GenFieldConfig getById(Long id);

    List<GenFieldConfig> listAll();

    void save(GenFieldConfig entity);

    void update(GenFieldConfig entity);

    void deleteById(Long id);
}