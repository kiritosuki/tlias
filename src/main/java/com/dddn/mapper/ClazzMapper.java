package com.dddn.mapper;

import com.dddn.pojo.Clazz;
import com.dddn.pojo.ClazzQueryParam;
import com.dddn.pojo.StudentCountMap;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClazzMapper {

    List<Clazz> listPage(ClazzQueryParam clazzQueryParam);

    @Insert("insert into clazz (name, room, begin_date, end_date, master_id, subject, create_time, update_time)" +
            "values (#{name}, #{room}, #{beginDate}, #{endDate}, #{masterId}, #{subject}, #{createTime}, #{updateTime})")
    void add(Clazz clazz);

    @Select("select c.* from clazz c where c.id = #{id}")
    Clazz selectById(@Param("id") Integer id);

    void update(Clazz clazz);

    @Delete("delete from clazz where id = #{id}")
    void delete(Integer id);

    @Select("select c.* from clazz c")
    List<Clazz> getClazzs();

    List<StudentCountMap> getStudentCountData();
}
