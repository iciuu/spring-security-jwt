package com.ng.howlongapi.security;

import com.ng.howlongapi.mapper.UserMapper;
import com.ng.howlongapi.model.JwtUser;
import com.ng.howlongapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Example queryUserEx = new Example(User.class);
        queryUserEx.createCriteria().andEqualTo("userName",s);
        User user = userMapper.selectOneByExample(queryUserEx);
        if(null == user){
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", s));
        } else {
            return JwtUser.builder().user(user).build();
        }
    }
}
