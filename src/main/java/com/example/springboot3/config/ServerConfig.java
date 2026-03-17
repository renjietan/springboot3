package com.example.springboot3.config;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// 将配置文件的属性 映射到 累
@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "server")
public class ServerConfig {
    private String address;
    private int port;
}
