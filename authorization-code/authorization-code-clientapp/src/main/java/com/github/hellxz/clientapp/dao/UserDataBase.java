package com.github.hellxz.clientapp.dao;

import com.github.hellxz.clientapp.domain.ClientUser;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhuqz
 * @date: 2021/6/9 10:03
 * @description: 模拟数据
 */
@Component
public class UserDataBase {
    private static Map<String,ClientUser> dataBase = new HashMap<>();
    static {
        ClientUser user = new ClientUser();
        user.setUsername("tomclient");
        user.setPassword("123456");
        dataBase.put("tomclient",user);
    }
    public ClientUser getUserByName(String name){
        return dataBase.get(name);
    }
    public void updateUserToken(String name,String token){
        dataBase.get(name).setAccessToken(token);
    }
}