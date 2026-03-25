package com.example.springboot3.dto.upload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@Data
public class uploadFormDataDTO {
    @NotNull(message = "请上传文件")
    private MultipartFile file;
    @NotBlank(message = "field1不可为空")
    private String field1;
    @NotBlank(message = "field2不可为空")
    private String field2;
}
