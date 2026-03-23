package com.example.springboot3.dto.codeGen;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class CodeGenDTO {
    @Valid
    @NotEmpty(message = "列表不可为空")
    private List<CodeGenItemDTO> data;
}
