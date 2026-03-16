package com.example.springboot3.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot3.entity.UserEntity;
import com.example.springboot3.mapper.UserMapper;
import com.example.springboot3.service.interfaces.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {
    // 如果接口定义了额外方法，需要在这里实现
}