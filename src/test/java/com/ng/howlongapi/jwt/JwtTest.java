package com.ng.howlongapi.jwt;

import com.ng.howlongapi.BaseTest;
import com.ng.howlongapi.util.JwtTokenUtil;
import com.ng.howlongapi.model.JwtUser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class JwtTest extends BaseTest {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Test
    public void jwtCreateParse() {
        JwtUser jwtUser = JwtUser.builder().username("user1").password("password").build();
        String jwtStr = jwtTokenUtil.createJwt(jwtUser);
        System.out.println(jwtStr);
        jwtTokenUtil.parseJwt(jwtStr);
    }
}
