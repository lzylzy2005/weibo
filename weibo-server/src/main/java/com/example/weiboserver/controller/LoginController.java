package com.example.weiboserver.controller;

import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;
import java.util.Map;
import com.example.weiboserver.service.UserService;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Resource
    private UserService userService;


    @GetMapping("/test")
    public String test() {
        return "ok";
    }

    // 接收 POST 请求，路径是 /api/login
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> loginData) {
        String username = loginData.get("username");
        String password = loginData.get("password");

        // 调用 service 进行验证
        String token = userService.login(username, password);

        Map<String, Object> response = new HashMap<>();
        if (token != null) {
            response.put("code", 200);
            response.put("msg", "登录成功");
            response.put("token", token);
        } else {
            response.put("code", 401);
            response.put("msg", "用户名或密码错误");
        }
        return response;
    }
}