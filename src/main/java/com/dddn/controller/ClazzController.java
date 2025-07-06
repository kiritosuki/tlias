package com.dddn.controller;

import com.dddn.anno.LogOperator;
import com.dddn.pojo.Clazz;
import com.dddn.pojo.ClazzQueryParam;
import com.dddn.pojo.PageResult;
import com.dddn.pojo.Result;
import com.dddn.service.ClazzService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clazzs")
public class ClazzController {
    private final ClazzService clazzService;
    private static final Logger log = LoggerFactory.getLogger(ClazzController.class);

    public ClazzController(@Qualifier("clazzServiceImpl") ClazzService clazzService){
        this.clazzService = clazzService;
    }

    //班级列表数据分页查询 条件查询
    @GetMapping
    public Result listPage(@ModelAttribute ClazzQueryParam clazzQueryParam){
        PageResult<Clazz> pageResult = clazzService.listPage(clazzQueryParam);
        log.info("分页查询班级信息: {}",pageResult);
        return Result.success(pageResult);
    }

    //添加班级
    @LogOperator
    @PostMapping
    public Result add(@RequestBody Clazz clazz){
        clazzService.add(clazz);
        log.info("添加班级: {}", clazz);
        return Result.success();
    }

    //查询回显 根据id查询班级
    @GetMapping("{id}")
    public Result selectById(@PathVariable("id") Integer id){
        Clazz clazz = clazzService.selectById(id);
        log.info("查询班级: {}", clazz);
        return Result.success(clazz);
    }

    //修改班级信息
    @LogOperator
    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        log.info("修改班级信息-修改前: {}", clazz);
        clazzService.update(clazz);
        log.info("修改班级信息-修改后: {}", clazz);
        return Result.success();
    }

    //删除班级
    @LogOperator
    @DeleteMapping("{id}")
    public Result delete(@PathVariable("id") Integer id){
        log.info("删除班级-id: {}", id);
        clazzService.delete(id);
        return Result.success();
    }

    //学生管理时班级列表查询
    @GetMapping("/list")
    public Result getClazzs(){
        List<Clazz> clazzs = clazzService.getClazzs();
        log.info("学生管理时班级查询: {}", clazzs);
        return Result.success(clazzs);
    }
}
