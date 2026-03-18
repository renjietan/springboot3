package com.example.springboot3.mapper.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.springboot3.entity.UserEntity;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;

public interface UserMapper extends BaseMapper<UserEntity> {
//    void selectPage(IPage<UserEntity> page, LambdaQueryWrapper<User> wrapper);
    // 这里可以添加自定义查询方法
}
