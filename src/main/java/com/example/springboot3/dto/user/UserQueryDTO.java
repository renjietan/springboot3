package com.example.springboot3.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Setter
@Getter
@Data
public class UserQueryDTO {
    private String name;
    private Integer page = 1;   // 默认页码
    private Integer size = 10; // 默认每页大小
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "开始时间", example = "2024-01-01 00:00:00")
    private LocalDateTime startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "结束时间", example = "2026-12-31 23:59:59")
    private LocalDateTime endTime;

    @Override
    public String toString() {
        return "UserQueryDTO{" +
                "name='" + name + '\'' +
                ", page=" + page +
                ", size=" + size +
                '}';
    }
}