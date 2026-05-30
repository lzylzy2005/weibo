package com.example.weiboserver.mapper;

import com.example.weiboserver.bean.Weibo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface WeiboMapper {
    @Select("SELECT id, content, create_time as createTime, user_id as userId FROM weibo ORDER BY create_time DESC")
    List<Weibo> findAll();

    @Insert("INSERT INTO weibo(content) VALUES(#{content})")
    int addWeibo(Weibo weibo);
}