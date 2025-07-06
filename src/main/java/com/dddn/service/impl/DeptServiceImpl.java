package com.dddn.service.impl;

import com.dddn.exception.DeptHasEmpsException;
import com.dddn.mapper.DeptMapper;
import com.dddn.mapper.EmpMapper;
import com.dddn.pojo.Dept;
import com.dddn.pojo.Emp;
import com.dddn.service.DeptService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    private final DeptMapper deptMapper;
    private final EmpMapper empMapper;

    public DeptServiceImpl(@Qualifier("deptMapper") DeptMapper deptMapper,
                           @Qualifier("empMapper") EmpMapper empMapper ){
        this.deptMapper = deptMapper;
        this.empMapper = empMapper;
    }

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    public void delete(Integer id) {
        List<Emp> empList = empMapper.selectByDeptId(id);
        if(!empList.isEmpty()){
            throw new DeptHasEmpsException("对不起! 该部门下有员工, 不能直接删除哦~");
        }
        deptMapper.delete(id);
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.add(dept);
    }

    @Override
    public Dept getInfo(Integer id) {
        return deptMapper.getInfo(id);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}
