package com.example.springboot3.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot3.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper  // 或者使用启动类上的 @MapperScan 统一扫描
public interface UserMapper extends BaseMapper<UserEntity> {
    // 这里可以添加自定义查询方法
}
