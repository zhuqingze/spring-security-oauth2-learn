package com.github.hellxz.clientapp.config;

import com.github.hellxz.clientapp.dao.UserDataBase;
import com.github.hellxz.clientapp.domain.ClientUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ClientUserDetailsService implements UserDetailsService {


    @Autowired
    UserDataBase userDataBase;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ClientUser clientUser = userDataBase.getUserByName(username);
        if(Objects.isNull(clientUser)){
            throw new UsernameNotFoundException("用户不存在");
        }
        return clientUser;
    }
}
