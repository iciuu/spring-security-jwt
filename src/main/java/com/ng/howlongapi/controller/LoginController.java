package com.ng.howlongapi.controller;

import com.ng.howlongapi.model.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping("/login")
public class LoginController {

    @ApiOperation(value="用户注册")
    @PostMapping("/registByNamePwd")
    public User registByNamePwd(){
        User user = new User();
        user.setCreateTime(new Date());
        return user;
    }

    @PostMapping("/loginByUserName")
    public User loginByUserName(@RequestParam(value = "userName") String userName,@RequestParam(value = "password") String password){
        return null;
    }


}
