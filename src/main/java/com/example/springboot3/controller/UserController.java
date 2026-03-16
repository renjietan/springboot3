package com.example.springboot3.controller;

import com.example.springboot3.dto.user.UserDTO;
import com.example.springboot3.entity.UserEntity;
import com.example.springboot3.service.interfaces.UserService;
import com.example.springboot3.utils.Result;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="用户管理")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor  // 使用 Lombok 生成构造器注入
public class UserController {
    private final UserService userService;
/*
    // 创建用户
    @Operation(summary = "新增用户", description = "新增用户")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "操作成功"),
            @ApiResponse(responseCode = "500", description = "操作失败")
    })*/
    @PostMapping
    public Result<UserEntity> createUser(@Valid @RequestBody UserDTO userDTO) {
        UserEntity user = new UserEntity();
        BeanUtils.copyProperties(userDTO, user);
        userService.save(user);
        return Result.success(user);
    }
}
