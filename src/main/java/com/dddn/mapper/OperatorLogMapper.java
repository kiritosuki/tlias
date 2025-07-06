package com.dddn.mapper;

import com.dddn.pojo.OperatorLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface OperatorLogMapper {

    @Insert("insert into tlias.operator_log (operate_emp_id, operate_time, class_name, method_name, method_params, return_value, cost_time) " +
            "values (#{operateEmpId}, #{operateTime}, #{className}, #{methodName}, #{methodParams}, #{returnValue}, #{costTime})")
    void addOperatorLog(OperatorLog operatorLog);

    @Select("select o.*, e.name operateEmpName from tlias.operator_log o left outer join emp e on o.operate_emp_id = e.id order by operate_time desc")
    List<OperatorLog> getOperatorLogList();
}
