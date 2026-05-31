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
    @GetMapping("/weibo")
    public Map<String, Object> list() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("data", weiboService.getAll());
        return map;
    }

    // 发布微博
    @PostMapping("/weibo")
    public Map<String, Object> add(
            @RequestBody Map<String, String> weibo,
            @RequestHeader("token")String token)
    {
        String content = weibo.get("content");
        Integer userid = Integer.parseInt(token);
        weiboService.add(content, userid);

        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "发布成功");
        return map;
    }
}