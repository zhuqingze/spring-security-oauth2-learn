package com.github.hellxz.clientapp.utils;

import com.github.hellxz.clientapp.dao.UserDataBase;
import com.github.hellxz.clientapp.domain.ClientUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtils {

    @Autowired
    private UserDataBase userDataBase;

    public UserDetails getCurrentUser(){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        Object principal = authentication.getPrincipal();
        if(principal instanceof UserDetails){
            return (UserDetails) principal;
        }
        return null;
    }

    /**
     * 更新token
     */
    public void updateToken(String token){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        Object principal = authentication.getPrincipal();
        if(principal instanceof ClientUser){
            ClientUser clientUser = (ClientUser) principal;
            clientUser.setAccessToken(token);
            userDataBase.updateUserToken(clientUser.getUsername(),token);
        }
    }
}
