package com.example.springboot3.controller;

import com.example.springboot3.config.ServerConfig;
import com.example.springboot3.utils.Result;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
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

    @Value("${upload.path}")
    private String uploadPath;
    private final ServerConfig serverConfig;

    public UploadController(ServerConfig serverConfig) {
        this.serverConfig = serverConfig;
    }

    @PostMapping(value = "single", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Result<String> uploadSingleFile(@RequestPart("file") MultipartFile file) {
       /* if (file.isEmpty()) {
            return Result.success("请选择文件");
        }*/
        try {
            Path uploadDir = Paths.get(uploadPath);
            if (!Files.exists(uploadDir)) {
                Files.createDirectories(uploadDir);
            }
            // 生成安全的文件名（防路径遍历，并避免重名）
            String originalFilename = file.getOriginalFilename();
            String safeFilename = System.currentTimeMillis() + "_" + originalFilename;
            Path targetPath = uploadDir.resolve(safeFilename);

            // 保存文件
            Files.copy(file.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);

            // 返回可访问的 URL（假设静态资源映射在根路径下）
            return Result.success(serverConfig.getUploadsPrefixUrl() + safeFilename);
        } catch (IOException e) {
            return Result.error("文件上传失败");
        }
    }
}
