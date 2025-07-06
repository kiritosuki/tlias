package com.dddn.service;

import com.dddn.pojo.PageResult;
import com.dddn.pojo.Student;
import com.dddn.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {
    PageResult<Student> listpage(StudentQueryParam studentQueryParam);

    void add(Student student);

    Student selectById(Integer id);

    void update(Student student);

    void delete(List<Integer> ids);

    void handleViolation(Integer id, Integer score);
}
