package com.dddn.controller;

import com.aliyuncs.exceptions.ClientException;
import com.dddn.anno.LogOperator;
import com.dddn.pojo.Emp;
import com.dddn.pojo.EmpQueryParam;
import com.dddn.pojo.PageResult;
import com.dddn.pojo.Result;
import com.dddn.service.EmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/emps")
@RestController
public class EmpController {
    private final EmpService empService;
    private static final Logger log = LoggerFactory.getLogger(EmpController.class);

    public EmpController(@Qualifier("empServiceImpl") EmpService empService){
        this.empService = empService;
    }

    //分页查询 搜索条件查询
    @GetMapping
    public Result listPage(@ModelAttribute EmpQueryParam empQueryParam){
        log.info("搜索查询-请求参数: {}",empQueryParam);
        PageResult<Emp> pageResult = empService.listPage(empQueryParam);
        return Result.success(pageResult);
    }

    //添加员工
    @LogOperator
    @PostMapping
    public Result addEmp(@RequestBody Emp emp){
        log.info("添加员工-员工: {}",emp);
        empService.addEmp(emp);
        return Result.success();
    }

    //删除员工
    @LogOperator
    @DeleteMapping
    public Result delete(@RequestParam("ids") List<Integer> ids) throws ClientException {
        log.info("删除以下员工-ids: {}",ids);
        empService.delete(ids);
        return Result.success();
    }

    //修改员工数据时查询回显
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable("id") Integer id){
        log.info("查询回显员工信息-id: {}",id);
        Emp emp = empService.getInfo(id);
        log.info("查询回显员工信息-全部: {}",emp);
        return Result.success(emp);
    }

    //修改员工数据
    @LogOperator
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("修改员工信息-修改前: {}", emp);
        empService.update(emp);
        log.info("修改员工信息-修改后: {}", emp);
        return Result.success();
    }

    //班级管理时班主任列表查询
    @GetMapping("/list")
    public Result getMasters(){
        List<Emp> masterList = empService.getMasters();
        log.info("班级管理时班主任信息查询: {}",masterList);
        return Result.success(masterList);
    }

}
