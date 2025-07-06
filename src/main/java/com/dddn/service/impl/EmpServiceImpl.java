package com.dddn.service.impl;

import com.aliyuncs.exceptions.ClientException;
import com.dddn.mapper.EmpExprMapper;
import com.dddn.mapper.EmpMapper;
import com.dddn.pojo.Emp;
import com.dddn.pojo.EmpExpr;
import com.dddn.pojo.EmpQueryParam;
import com.dddn.pojo.PageResult;
import com.dddn.service.EmpService;
import com.dddn.utils.AliyunOSSOperator;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    private final EmpMapper empMapper;
    private final EmpExprMapper empExprMapper;
    private final AliyunOSSOperator aliyunOSSOperator;

    public EmpServiceImpl(@Qualifier("empMapper") EmpMapper empMapper,
                          @Qualifier("empExprMapper") EmpExprMapper empExprMapper,
                          @Qualifier("aliyunOSSOperator") AliyunOSSOperator aliyunOSSOperator){
        this.empMapper = empMapper;
        this.empExprMapper = empExprMapper;
        this.aliyunOSSOperator = aliyunOSSOperator;
    }

    @Override
    public PageResult<Emp> listPage(EmpQueryParam empQueryParam) {
        PageHelper.startPage(empQueryParam.getPage(),empQueryParam.getPageSize());
        List<Emp> empList = empMapper.listPage(empQueryParam);
        Page<Emp> p = (Page<Emp>) empList;
        return new PageResult<Emp>(p.getTotal(),p.getResult());
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void addEmp(Emp emp) {
        //添加员工
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.addEmp(emp);
        //将工作经历匹配员工的id
        Integer id = emp.getId();
        List<EmpExpr> exprList = emp.getExprList();
        if(!exprList.isEmpty()) {
            exprList.forEach(empExpr -> empExpr.setEmpId(id));
            //将工作经历添加到数据库
            empExprMapper.addExpr(exprList);
        }
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void delete(List<Integer> ids) throws ClientException {
        if(ids == null || ids.isEmpty()){
            throw new IllegalArgumentException("请先选择你要删除的员工~");
        }
        //在云端删除员工上传的文件
        //根据id找到员工上传文件的完整路径名称
        List<String> urlList = empMapper.selectKeysByIds(ids);
        //过滤掉list中null或空串的元素
        List<String> urls = urlList.stream().filter(url -> {
            return url != null && !url.isEmpty();
        }).toList();
        //删除文件
        if(!urls.isEmpty()){
            aliyunOSSOperator.removeFile(urls);
        }
        //删除员工
        empMapper.deleteEmp(ids);
        //删除工作经历
        empExprMapper.deleteExpr(ids);
    }

    @Override
    public Emp getInfo(Integer id) {
        return empMapper.getInfo(id);
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void update(Emp emp) {
        //修改员工基本信息
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
        //修改员工工作经历 先删除 再添加
        //删除员工工作经历
        empExprMapper.deleteExpr(Arrays.asList(emp.getId()));
        //新加工作经历
        List<EmpExpr> exprList = emp.getExprList();
        if(!exprList.isEmpty()) {
            //将现有的工作经历匹配上该员工的id
            exprList.forEach(expr -> {
                expr.setEmpId(emp.getId());
            });
            //再将该工作经历添加到数据库
            empExprMapper.addExpr(exprList);
        }
    }

    @Override
    public List<Emp> getMasters() {
        return empMapper.getMasters();
    }
}
