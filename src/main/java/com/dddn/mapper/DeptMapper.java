package com.dddn.mapper;

import com.dddn.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("select * from tlias.dept order by update_time desc ")
    List<Dept> findAll();

    @Delete("delete from tlias.dept where id = #{id}")
    void delete(Integer id);

    @Insert("insert into tlias.dept (name, create_time, update_time) values (#{name}, #{createTime},#{updateTime})")
    void add(Dept dept);

    @Select("select * from tlias.dept where id = #{id}")
    Dept getInfo(Integer id);

    @Update("update tlias.dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);
}
