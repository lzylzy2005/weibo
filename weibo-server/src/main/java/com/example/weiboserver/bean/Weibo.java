package com.example.weiboserver.bean;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Weibo {
    private Integer id;
    private String content;
    private LocalDateTime createTime;
}