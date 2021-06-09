package com.github.hellxz.oauth2.web.controller;

import com.github.hellxz.oauth2.web.vo.UserVO;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {
    /**
     * 资源服务器开发接口 使用token换取用户的信息
     *
     * @return
     */
    @GetMapping("/userInf")
    public UserVO userInf() {
        String userName = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        //业务处理 根据userName获取一些信息
        String userMail = userName+"@126.com";
        UserVO userVO = new UserVO(userName, userMail);
        return userVO;
    }

    @GetMapping("/user/{username}")
    public UserVO user(@PathVariable String username) {
        return new UserVO(username, username + "@foxmail.com");
    }
}
