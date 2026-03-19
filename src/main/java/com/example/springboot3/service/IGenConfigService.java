package com.example.springboot3.service;

import com.example.springboot3.entity.GenConfig;
import java.util.List;

/**
 * 代码生成基础配置表 Service 接口
 * @author tanrenjie
 */
public interface IGenConfigService {

    GenConfig getById(Long id);

    List<GenConfig> listAll();

    void save(GenConfig entity);

    void update(GenConfig entity);

    void deleteById(Long id);
}