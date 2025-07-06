package com.dddn.service.impl;

import com.dddn.mapper.ClazzMapper;
import com.dddn.mapper.EmpMapper;
import com.dddn.mapper.StudentMapper;
import com.dddn.pojo.*;
import com.dddn.service.ReportService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    private final EmpMapper empMapper;
    private final ClazzMapper clazzMapper;
    private final StudentMapper studentMapper;

    public ReportServiceImpl(@Qualifier("empMapper") EmpMapper empMapper,
                             @Qualifier("clazzMapper") ClazzMapper clazzMapper,
                             @Qualifier("studentMapper") StudentMapper studentMapper ){
        this.empMapper = empMapper;
        this.clazzMapper = clazzMapper;
        this.studentMapper = studentMapper;
    }

    @Override
    public EmpJobData getEmpJobData() {
        List<EmpJobMap> jobMapList = empMapper.getEmpJobData();
        List<String> jobList = jobMapList.stream().map(EmpJobMap::getJobName).toList();
        List<Integer> dataList = jobMapList.stream().map(EmpJobMap::getJobNum).toList();
        return new EmpJobData(jobList, dataList);
    }

    @Override
    public List<EmpGenderMap> getEmpGenderMapList() {
        return empMapper.getEmpGenderMapList();
    }

    @Override
    public StudentCountData getStudentCountData() {
        List<StudentCountMap> studentCountMapList =  clazzMapper.getStudentCountData();
        List<String> clazzList = studentCountMapList.stream().map(StudentCountMap::getClazzName).toList();
        List<Integer> dataList = studentCountMapList.stream().map(StudentCountMap::getStudentNum).toList();
        return new StudentCountData(clazzList, dataList);
    }

    @Override
    public List<StudentDegreeData> getStudentDegreeData() {
        return studentMapper.getStudentDegreeData();
    }
}
