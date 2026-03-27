package com.example.springboot3.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot3.entity.OrderEntity;
import com.example.springboot3.mapper.OrderMapper;
import com.example.springboot3.service.OrderService;
import org.springframework.stereotype.Service;

/**
* @author Cc
* @description 针对表【order】的数据库操作Service实现
* @createDate 2026-03-27 14:15:52
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderEntity>
    implements OrderService {

}




