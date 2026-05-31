package com.example.weiboserver.service;

import com.example.weiboserver.mapper.UserMapper;
import com.example.weiboserver.bean.User;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    // 登录验证，成功返回 token（先用假 token，后面可以集成 JWT）
    public String login(String username, String password) {
        User user = userMapper.findByUsername(username);
        if (user == null) {
            return null; // 用户不存在
        }
        // 注意：实际开发中密码要加密比对，这里简单用明文（假设数据库存的也是明文）
        if (user.getPassword().equals(password)) {
            //直接返回userid
            return user.getId().toString();
        }
        return null;
    }
}