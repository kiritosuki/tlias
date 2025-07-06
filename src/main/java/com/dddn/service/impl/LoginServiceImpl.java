package com.dddn.service.impl;

import com.dddn.mapper.EmpMapper;
import com.dddn.pojo.Emp;
import com.dddn.pojo.LoginInfo;
import com.dddn.service.LoginService;
import com.dddn.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class LoginServiceImpl implements LoginService {
    private final EmpMapper empMapper;

    public LoginServiceImpl(@Qualifier("empMapper") EmpMapper empMapper) {
        this.empMapper = empMapper;
    }

    @Override
    public LoginInfo login(Emp emp) {
        Emp loginEmp = empMapper.getByUsernameAndPassword(emp);
        if(loginEmp == null){
            return null;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", loginEmp.getId());
        hashMap.put("username", loginEmp.getUsername());
        String token = JwtUtils.generateJwt(hashMap);
        LoginInfo loginInfo = new LoginInfo(loginEmp.getId(), loginEmp.getUsername(), loginEmp.getName(), token);
        return loginInfo;
    }
}
