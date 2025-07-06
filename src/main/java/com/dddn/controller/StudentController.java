package com.dddn.controller;

import com.dddn.anno.LogOperator;
import com.dddn.pojo.PageResult;
import com.dddn.pojo.Result;
import com.dddn.pojo.Student;
import com.dddn.pojo.StudentQueryParam;
import com.dddn.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    private static final Logger log = LoggerFactory.getLogger(StudentController.class);

    public StudentController(@Qualifier("studentServiceImpl") StudentService studentService){
        this.studentService = studentService;
    }

    //分页查询 条件查询学生列表
    @GetMapping
    public Result listPage(@ModelAttribute StudentQueryParam studentQueryParam){
        log.info("查询学生参数: {}", studentQueryParam);
        PageResult<Student> pageResult = studentService.listpage(studentQueryParam);
        log.info("返回学生结果: {}", pageResult);
        return Result.success(pageResult);
    }

    //添加学生
    @LogOperator
    @PostMapping
    public Result add(@RequestBody Student student){
        studentService.add(student);
        log.info("添加学生: {}", student);
        return Result.success();
    }

    //查询回显学生信息
    @GetMapping("/{id}")
    public Result selectById(@PathVariable("id") Integer id){
        Student student = studentService.selectById(id);
        log.info("查询回显学生信息: {}", student);
        return Result.success(student);
    }

    //修改学生信息
    @LogOperator
    @PutMapping
    public Result update(@RequestBody Student student){
        log.info("修改学生信息-修改前: {}", student);
        studentService.update(student);
        log.info("修改学生信息-修改后: {}", student);
        return Result.success();
    }

    //删除学生 支持批量删除
    @LogOperator
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable("ids") List<Integer> ids){
        log.info("根据id删除学生: {}", ids);
        studentService.delete(ids);
        return Result.success();
    }

    //违纪处理
    @LogOperator
    @PutMapping("/violation/{id}/{score}")
    public Result handleViolation(@PathVariable("id") Integer id,
                                  @PathVariable("score") Integer score){
        studentService.handleViolation(id, score);
        return Result.success();
    }

}
