package com.example.springboot3.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot3.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
    // 这里可以添加自定义查询方法
    // 自定义方法：查询所有用户及其订单
//    @Select("SELECT * FROM user")
//    @Results(id = "userWithOrdersMap", value = {
//            // 必须映射主键，否则关联查询可能会失败
//            @Result(column = "user_id", property = "userId"),
//            // 配置一对多关系：通过当前查询结果的 user_id 作为参数，去执行另一个查询
//            @Result(column = "user_id",
//                    property = "orders", // 对应User类中的orders属性
//                    javaType = List.class, // 指定集合的类型
//                    many = @Many(select = "com.example.mapper.OrderMapper.selectByUserId") // 指定要执行的子查询方法
//            )
//    })
//    List<User> selectAllUsersWithOrders();
}
