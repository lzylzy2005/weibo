package com.example.weiboserver.controller;

import com.example.weiboserver.bean.Weibo;
import com.example.weiboserver.service.WeiboService;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*") // 允许前端访问
@RestController
@RequestMapping("/api")
public class WeiboController {
    @Resource
    private WeiboService weiboService;

    // 获取所有微博
    @GetMapping("/Weibo")
    public Map<String, Object> list() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("data", weiboService.getAll());
        return map;
    }

    // 发布微博
    @PostMapping("/Weibo")
    public Map<String, Object> add(@RequestBody Weibo weibo) {
        Map<String, Object> map = new HashMap<>();
        weiboService.add(weibo);
        map.put("code", 200);
        map.put("msg", "发布成功");
        return map;
    }
}