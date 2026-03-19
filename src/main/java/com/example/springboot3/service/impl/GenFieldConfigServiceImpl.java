package com.example.springboot3.service.impl;

import com.example.springboot3.entity.GenFieldConfig;
import com.example.springboot3.mapper.GenFieldConfigMapper;
import com.example.springboot3.service.IGenFieldConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 代码生成字段配置表 Service 实现
 * @author tanrenjie
 */
@Service
public class GenFieldConfigServiceImpl implements IGenFieldConfigService {

    @Autowired
    private GenFieldConfigMapper genFieldConfigMapper;

    @Override
    public GenFieldConfig getById(Long id) {
        return genFieldConfigMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<GenFieldConfig> listAll() {
        return genFieldConfigMapper.selectAll();
    }

    @Override
    public void save(GenFieldConfig entity) {
            genFieldConfigMapper.insert(entity);
    }

    @Override
    public void update(GenFieldConfig entity) {
            genFieldConfigMapper.updateByPrimaryKey(entity);
    }

    @Override
    public void deleteById(Long id) {
            genFieldConfigMapper.deleteByPrimaryKey(id);
    }
}