package com.dddn.service.impl;

import com.dddn.exception.IllegalParamException;
import com.dddn.exception.NumOutOfBoundException;
import com.dddn.exception.StudentHasNotClazzIdException;
import com.dddn.mapper.StudentMapper;
import com.dddn.pojo.PageResult;
import com.dddn.pojo.Student;
import com.dddn.pojo.StudentQueryParam;
import com.dddn.service.StudentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentMapper studentMapper;

    public StudentServiceImpl(@Qualifier("studentMapper") StudentMapper studentMapper){
        this.studentMapper = studentMapper;
    }

    @Override
    public PageResult<Student> listpage(StudentQueryParam studentQueryParam) {
        //准备分页工作
        PageHelper.startPage(studentQueryParam.getPage(), studentQueryParam.getPageSize());
        //查询学生列表
        List<Student> studentList = studentMapper.listPage(studentQueryParam);
        //向下造型为page
        Page<Student> p = (Page<Student>) studentList;
        return new PageResult<>(p.getTotal(), p.getResult());
    }

    @Override
    public void add(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        if(student.getClazzId() == null){
            throw new StudentHasNotClazzIdException("请选择学生所属的班级哦~");
        }else{
            studentMapper.add(student);
        }
    }

    @Override
    public Student selectById(Integer id) {
        return studentMapper.selectById(id);
    }

    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
    }

    @Override
    public void delete(List<Integer> ids) {
        studentMapper.delete(ids);
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void handleViolation(Integer id, Integer score) {
        if(score <= 0){
            throw new IllegalParamException("请输入有效的参数~");
        }
        Student student = studentMapper.selectById(id);
        Integer violationCount = student.getViolationCount() + 1;
        score = student.getViolationScore() + score;
        if(score > 255 || violationCount > 255){
            throw new NumOutOfBoundException("输入的参数超出范围了哦! 请重新输入~");
        }
        LocalDateTime updateTime = LocalDateTime.now();
        studentMapper.handleViolation(id, violationCount, score, updateTime);
    }
}
