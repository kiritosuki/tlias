package com.dddn.controller;

import com.dddn.anno.LogOperator;
import com.dddn.pojo.Dept;
import com.dddn.pojo.Result;
import com.dddn.service.DeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/depts")
@RestController
public class DeptController {
    private final DeptService deptService;
    private static final Logger log = LoggerFactory.getLogger(DeptController.class);

    public DeptController(@Qualifier("deptServiceImpl") DeptService deptService){
        this.deptService = deptService;
    }

    //显示所有部门
    @GetMapping
    public Result findAll(){
        log.info("显示所有部门");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    //删除某个部门
    @LogOperator
    @DeleteMapping
    public Result delete(@RequestParam("id") Integer id){
        log.info("删除部门-id: {}",id);
        deptService.delete(id);
        return Result.success();
    }

    //添加新部门
    @LogOperator
    @PostMapping
    public Result add(@RequestBody Dept dept){
        if(dept.getName() == null || dept.getName().isEmpty()){
            return Result.error("部门名称不能为空! ");
        }
        log.info("添加部门-dept: {}",dept);
        deptService.add(dept);
        return Result.success();
    }

    //修改时回显部门名称
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable("id") Integer id){
        log.info("查询时回显部门-id: {}",id);
        Dept dept = deptService.getInfo(id);
        return Result.success(dept);
    }

    //修改部门
    @LogOperator
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("修改部门-修改前-dept: {}",dept);
        deptService.update(dept);
        log.info("修改部门-修改后-dept: {}",dept);
        return Result.success();
    }
}
