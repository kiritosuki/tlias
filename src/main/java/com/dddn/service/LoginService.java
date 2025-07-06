package com.dddn.service;

import com.dddn.pojo.Emp;
import com.dddn.pojo.LoginInfo;

public interface LoginService {
    LoginInfo login(Emp emp);
}
