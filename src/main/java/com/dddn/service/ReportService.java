package com.dddn.service;

import com.dddn.pojo.EmpGenderMap;
import com.dddn.pojo.EmpJobData;
import com.dddn.pojo.StudentCountData;
import com.dddn.pojo.StudentDegreeData;

import java.util.List;

public interface ReportService {
    EmpJobData getEmpJobData();

    List<EmpGenderMap> getEmpGenderMapList();

    StudentCountData getStudentCountData();

    List<StudentDegreeData> getStudentDegreeData();
}
