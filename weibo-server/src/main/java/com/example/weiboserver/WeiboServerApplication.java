package com.example.weiboserver;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.weiboserver.mapper")
public class WeiboServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(WeiboServerApplication.class, args);
    }
}