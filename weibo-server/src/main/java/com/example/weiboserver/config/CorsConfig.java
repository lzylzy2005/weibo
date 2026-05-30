package com.example.weiboserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // 所有路径
                .allowedOrigins("*")  // 允许所有源（如果allowCredentials为true，则不能为*，我们先试宽松模式）
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .maxAge(3600);
        // 注意：allowedOrigins("*") 且 allowCredentials(true) 会冲突，所以这里先去掉了allowCredentials(true)
    }
}