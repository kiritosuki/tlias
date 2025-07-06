package com.dddn.controller;

import com.dddn.pojo.*;
import com.dddn.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/report")
@RestController
public class ReportController {
    private final ReportService reportService;
    private static final Logger log = LoggerFactory.getLogger(ReportController.class);

    public ReportController(@Qualifier("reportServiceImpl") ReportService reportService){
        this.reportService = reportService;
    }

    //查询统计各个职位的员工人数
    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        EmpJobData empJobData = reportService.getEmpJobData();
        log.info("查询统计各职位员工人数: {}", empJobData);
        return Result.success(empJobData);
    }

    //查询不同性别员工人数
    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        List<EmpGenderMap> empGenderMapList = reportService.getEmpGenderMapList();
        log.info("查询统计不同性别员工人数: {}", empGenderMapList);
        return Result.success(empGenderMapList);
    }

    //查询统计不同班级的人数
    @GetMapping("/studentCountData")
    public Result getStudentCountData(){
        StudentCountData studentCountData = reportService.getStudentCountData();
        log.info("查询统计不同班级的人数: {}", studentCountData);
        return Result.success(studentCountData);
    }

    //查询统计学员学历
    @GetMapping("/studentDegreeData")
    public Result getStudentDegreeData(){
        List<StudentDegreeData> studentDegreeDataList = reportService.getStudentDegreeData();
        log.info("查询统计学员学历: {}",studentDegreeDataList);
        return Result.success(studentDegreeDataList);
    }
}
