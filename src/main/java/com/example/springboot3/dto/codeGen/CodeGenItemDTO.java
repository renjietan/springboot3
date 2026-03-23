package com.example.springboot3.dto.codeGen;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CodeGenItemDTO {
    @NotBlank(message = "表名不可为空")
    private String tableName;
}
