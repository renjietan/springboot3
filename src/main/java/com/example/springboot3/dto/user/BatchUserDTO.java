package com.example.springboot3.dto.user;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@Data
public class BatchUserDTO {
    @NotEmpty(message = "用户列表不能为空")
    @Valid
    private List<CreateUserDTO> users;
}
