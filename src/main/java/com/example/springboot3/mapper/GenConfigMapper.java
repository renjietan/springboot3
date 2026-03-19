package com.example.springboot3.mapper;

import com.example.springboot3.entity.GenConfig;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 代码生成基础配置表 Mapper 接口
 * @author tanrenjie
 */
@Mapper
public interface GenConfigMapper {

    /**
     * 根据主键查询
     */
        GenConfig selectByPrimaryKey(Long id);

    /**
     * 查询所有
     */
    List<GenConfig> selectAll();

    /**
     * 插入
     */
    int insert(GenConfig record);

    /**
     * 更新
     */
    int updateByPrimaryKey(GenConfig record);

    /**
     * 删除
     */
    int deleteByPrimaryKey(Long id);
}