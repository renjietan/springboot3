package com.example.springboot3.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot3.entity.UserEntity;

public interface UserMapper extends BaseMapper<UserEntity> {
    // 这里可以添加自定义查询方法
}
