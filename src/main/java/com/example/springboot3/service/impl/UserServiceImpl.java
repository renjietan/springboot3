package com.example.springboot3.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot3.dto.user.UserQueryDTO;
import com.example.springboot3.entity.UserEntity;
import com.example.springboot3.mapper.UserMapper;
import com.example.springboot3.service.IUserService;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements IUserService {
    @Override
    public Object getList(UserQueryDTO param) {
        // 构建查询条件：name 模糊查询（如果传入）
        LambdaQueryWrapper<UserEntity> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.hasText(param.getName())) {
            wrapper.like(UserEntity::getName, param.getName());
        }
        LocalDateTime start  = param.getStartTime();
        LocalDateTime end  = param.getEndTime();
        LocalDateTime now = LocalDateTime.now();

        if (start != null && end != null) {
            // startTime 和 endTime 都传入 -> 查询区间 [start, end]
            wrapper.between(UserEntity::getCreateTime, start, end);
        } else if (start != null) {
            if (start.isAfter(now)) {
                // startTime 大于当前时间，直接返回空数据
                return createEmptyResult(param);
            } else {
                // 查询 createTime >= start
                wrapper.ge(UserEntity::getCreateTime, start);
            }
        } else if (end != null) {
            // 查询 createTime <= end
            wrapper.le(UserEntity::getCreateTime, end);
        }
        if (param.getPage() != null && param.getSize() != null) {
            // 分页查询
            IPage<UserEntity> page = new Page<>(param.getPage(), param.getSize());
            baseMapper.selectPage(page,wrapper);
            return page;
        } else {
            // 非分页查询：直接返回列表
            return this.list(wrapper);
        }
    }

    private Object createEmptyResult(UserQueryDTO pageParam) {
        if (pageParam.getPage() != null && pageParam.getSize() != null) {
            // 返回空的分页对象
            Page<User> emptyPage = new Page<>(pageParam.getPage(), pageParam.getSize());
            emptyPage.setRecords(List.of());
            emptyPage.setTotal(0);
            return emptyPage;
        } else {
            // 返回空列表
            return List.of();
        }
    }
}