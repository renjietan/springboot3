package com.example.springboot3.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class CreateUserDTO {
    @NotBlank(message = "姓名不能为空")
    private String name;

    @NotNull(message = "年龄不能为空")
    @Positive(message = "年龄必须为正数")
    private Integer age;

    @Email(message = "邮箱格式不正确")
    private String email;

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
