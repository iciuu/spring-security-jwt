package com.ng.howlongapi.controller;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Key;
import java.util.Date;

@Controller
public class TestController {


    @RequestMapping("/hello")
    public String hello(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        System.out.println(userDetails.getUsername());
        return "hello";
    }

    public static void main(String args[]) {
        Key key = MacProvider.generateKey();
        String jwtStr = Jwts.builder().setSubject("Joe1").
                signWith(SignatureAlgorithm.HS512, key).setIssuedAt(new Date())
                .compact();
        System.out.println(jwtStr);
        System.out.println(Jwts.parser().setSigningKey(key).parseClaimsJws(jwtStr).getBody().getSubject());

    }
}
