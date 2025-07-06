package com.dddn.service.impl;

import com.dddn.exception.ClazzHasStudentsException;
import com.dddn.mapper.ClazzMapper;
import com.dddn.mapper.StudentMapper;
import com.dddn.pojo.Clazz;
import com.dddn.pojo.ClazzQueryParam;
import com.dddn.pojo.PageResult;
import com.dddn.pojo.Student;
import com.dddn.service.ClazzService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    private final ClazzMapper clazzMapper;
    private final StudentMapper studentMapper;

    public ClazzServiceImpl(@Qualifier("clazzMapper") ClazzMapper clazzMapper, @Qualifier("studentMapper") StudentMapper studentMapper){
        this.clazzMapper = clazzMapper;
        this.studentMapper = studentMapper;
    }

    @Override
    public PageResult<Clazz> listPage(ClazzQueryParam clazzQueryParam) {
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());
        List<Clazz> clazzList = clazzMapper.listPage(clazzQueryParam);
        clazzList.forEach(clazz ->{
            if(clazz.getBeginDate().isAfter(LocalDate.now())){
                clazz.setStatus("未开班");
            }else if(clazz.getEndDate().isBefore(LocalDate.now())){
                clazz.setStatus("已结课");
            }else{
                clazz.setStatus("在读中");
            }
        });
        Page<Clazz> p = (Page<Clazz>) clazzList;
        return new PageResult<>(p.getTotal(), p.getResult());
    }

    @Override
    public void add(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.add(clazz);
    }

    @Override
    public Clazz selectById(Integer id) {
        Clazz clazz = clazzMapper.selectById(id);
        return clazz;
    }

    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());;
        clazzMapper.update(clazz);
    }

    @Override
    public void delete(Integer id) {
        //先查询学生列表 查询当前班级的学生
        List<Student> students = studentMapper.selectByClazzId(id);
        if(!students.isEmpty()){
            throw new ClazzHasStudentsException("对不起! 该班级里有学生, 不能直接删除哦~");
        }else{
            clazzMapper.delete(id);
        }
    }

    @Override
    public List<Clazz> getClazzs() {
        return clazzMapper.getClazzs();
    }

}
