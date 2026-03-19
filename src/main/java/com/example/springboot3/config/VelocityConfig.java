package com.example.springboot3.config;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VelocityConfig {
    @Bean
    public VelocityEngine velocityEngine() {
        VelocityEngine velocityEngine = new VelocityEngine();
        // 设置从 classpath 加载模板
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        // 可选：设置模板编码
        velocityEngine.setProperty(RuntimeConstants.INPUT_ENCODING, "UTF-8");
// 或者使用 SLF4J（如果引入相关依赖）
        velocityEngine.init();
        return velocityEngine;
    }
}
