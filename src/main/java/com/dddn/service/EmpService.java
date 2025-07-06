package com.dddn.service;

import com.aliyuncs.exceptions.ClientException;
import com.dddn.pojo.Emp;
import com.dddn.pojo.EmpQueryParam;
import com.dddn.pojo.PageResult;

import java.util.List;

public interface EmpService {

    PageResult<Emp> listPage(EmpQueryParam empQueryParam);

    void addEmp(Emp emp);

    void delete(List<Integer> ids) throws ClientException;

    Emp getInfo(Integer id);

    void update(Emp emp);

    List<Emp> getMasters();
}
