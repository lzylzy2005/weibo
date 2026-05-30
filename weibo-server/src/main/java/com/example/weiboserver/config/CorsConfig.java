package com.example.weiboserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import java.util.Arrays;

@Configuration
public class CorsConfig{
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();

        // ⚠️ 核心配置：设置允许访问的源。开发环境和生产环境按需设置。
        // 允许所有源 (不推荐生产环境使用)
        // config.addAllowedOriginPattern("*");
        // 推荐：明确指定允许的源
        config.setAllowedOrigins(Arrays.asList(
                "http://localhost:5173",     // Vite 默认端口
                "http://localhost:8080",     // Vue CLI 默认端口
                "https://你的前端域名.com"     // 你的 Vercel 前端域名
        ));

        // 是否允许跨域发送 Cookie
        config.setAllowCredentials(true);

        // 允许的请求方法
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        // 允许的请求头
        config.setAllowedHeaders(Arrays.asList("*"));
        // 暴露的响应头（让前端能获取到）
        config.setExposedHeaders(Arrays.asList("token", "Authorization"));

        // 预检请求的缓存时间（秒），减少 OPTIONS 请求
        config.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}