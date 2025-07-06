package com.dddn.mapper;

import com.dddn.pojo.Emp;
import com.dddn.pojo.EmpGenderMap;
import com.dddn.pojo.EmpJobMap;
import com.dddn.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mapper
public interface EmpMapper {

    List<Emp> listPage(EmpQueryParam empQueryParam);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into tlias.emp (tlias.emp.username, tlias.emp.name, " +
            "tlias.emp.gender, tlias.emp.phone, " +
            "tlias.emp.job, tlias.emp.salary, " +
            "tlias.emp.image, tlias.emp.entry_date, " +
            "tlias.emp.dept_id, tlias.emp.create_time, tlias.emp.update_time) " +
            "values (#{username}, #{name}, #{gender}, #{phone}, #{job}, #{salary}," +
            " #{image}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime})")
    void addEmp(Emp emp);

    void deleteEmp(List<Integer> ids);

    List<String> selectKeysByIds(List<Integer> ids);

    Emp getInfo(Integer id);

    void update(Emp emp);

    List<EmpJobMap> getEmpJobData();

    List<EmpGenderMap> getEmpGenderMapList();

    @Select("select e.* from emp e where e.job = 1")
    List<Emp> getMasters();

    @Select("select e.*, d.name deptName from emp e left outer join dept d on e.dept_id = d.id where e.dept_id = #{id}")
    List<Emp> selectByDeptId(Integer id);

    @Select("select e.* from emp e where e.username = #{username} and e.password = #{password}")
    Emp getByUsernameAndPassword(Emp emp);
}
