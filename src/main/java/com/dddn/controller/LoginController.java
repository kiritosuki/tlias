package com.dddn.controller;

import com.dddn.pojo.Emp;
import com.dddn.pojo.LoginInfo;
import com.dddn.pojo.Result;
import com.dddn.service.LoginService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private final LoginService loginService;

    public LoginController(@Qualifier("loginServiceImpl") LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        LoginInfo loginInfo = loginService.login(emp);
        if(loginInfo == null){
            return Result.error("用户名或密码错误 ~ ");
        }else{
            return Result.success(loginInfo);
        }
    }
}
