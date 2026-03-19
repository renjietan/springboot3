package com.example.springboot3.service.impl;

import com.example.springboot3.entity.GenConfig;
import com.example.springboot3.mapper.GenConfigMapper;
import com.example.springboot3.service.IGenConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 代码生成基础配置表 Service 实现
 * @author tanrenjie
 */
@Service
public class GenConfigServiceImpl implements IGenConfigService {

    @Autowired
    private GenConfigMapper genConfigMapper;

    @Override
    public GenConfig getById(Long id) {
        return genConfigMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<GenConfig> listAll() {
        return genConfigMapper.selectAll();
    }

    @Override
    public void save(GenConfig entity) {
            genConfigMapper.insert(entity);
    }

    @Override
    public void update(GenConfig entity) {
            genConfigMapper.updateByPrimaryKey(entity);
    }

    @Override
    public void deleteById(Long id) {
            genConfigMapper.deleteByPrimaryKey(id);
    }
}