package com.example.springboot3.controller;

import com.example.springboot3.utils.Result;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Tag(name="文件上传")
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Value("")
    private String uploadDir;
    @PostMapping(value = "single", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Result<String> uploadSingleFile(@RequestPart("file") MultipartFile file) {
       /* if (file.isEmpty()) {
            return Result.success("请选择文件");
        }*/
        try {
            // 获取文件名，并确保目录存在
            String fileName = file.getOriginalFilename();
            // 文件保存的根目录，可根据需要改为配置项
            String uploadDir = "uploads/";
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            // 保存文件到本地（注意文件名重复问题，可增加时间戳或UUID）
            Path filePath = null;
            if (fileName != null) {
                filePath = uploadPath.resolve(fileName);
            }
            if (filePath != null) {
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            }
            return Result.success("文件上传成功: " + fileName);
        } catch (IOException e) {
            return Result.success("文件上传失败");
        }
    }
}
