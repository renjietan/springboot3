package com.example.springboot3.mapper;

import com.example.springboot3.entity.GenFieldConfig;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 代码生成字段配置表 Mapper 接口
 * @author tanrenjie
 */
@Mapper
public interface GenFieldConfigMapper {

    /**
     * 根据主键查询
     */
        GenFieldConfig selectByPrimaryKey(Long id);

    /**
     * 查询所有
     */
    List<GenFieldConfig> selectAll();

    /**
     * 插入
     */
    int insert(GenFieldConfig record);

    /**
     * 更新
     */
    int updateByPrimaryKey(GenFieldConfig record);

    /**
     * 删除
     */
    int deleteByPrimaryKey(Long id);
}