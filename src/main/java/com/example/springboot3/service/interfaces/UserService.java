package com.example.springboot3.service.interfaces;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot3.dto.user.UserQueryDTO;
import com.example.springboot3.entity.UserEntity;

public interface UserService extends IService<UserEntity> {
    /**
     * 根据参数决定是否分页查询
     * @param param 分页参数（page/size 可能为 null）
     * @return 如果分页返回 IPage，否则返回 List
     */
    Object getList(UserQueryDTO param);
}
