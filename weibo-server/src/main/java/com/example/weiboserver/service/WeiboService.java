package com.example.weiboserver.service;

import com.example.weiboserver.bean.Weibo;
import com.example.weiboserver.mapper.WeiboMapper;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import java.util.List;

@Service
public class WeiboService {
    @Resource
    private WeiboMapper weiboMapper;

    public List<Weibo> getAll() {
        return weiboMapper.findAll();
    }

    public int add(String weibo, Integer userid) {
        return weiboMapper.addWeibo(weibo, userid);
    }
}