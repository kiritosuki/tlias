package com.dddn.service;

import com.dddn.pojo.Clazz;
import com.dddn.pojo.ClazzQueryParam;
import com.dddn.pojo.PageResult;

import java.util.List;

public interface ClazzService {
    PageResult<Clazz> listPage(ClazzQueryParam clazzQueryParam);

    void add(Clazz clazz);

    Clazz selectById(Integer id);

    void update(Clazz clazz);

    void delete(Integer id);

    List<Clazz> getClazzs();
}
