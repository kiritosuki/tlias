package com.dddn.mapper;

import com.dddn.pojo.Student;
import com.dddn.pojo.StudentDegreeData;
import com.dddn.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("select s.* from student s where s.clazz_id = #{id}")
    List<Student> selectByClazzId(Integer id);

    List<Student> listPage(StudentQueryParam studentQueryParam);

    @Insert("insert into student (name, no, gender, phone, id_card, is_college, address, degree, graduation_date, create_time, update_time, clazz_id) " +
            "values (#{name}, #{no}, #{gender}, #{phone}, #{idCard}, #{isCollege}, #{address}, #{degree}, #{graduationDate}, #{createTime}, #{updateTime}, #{clazzId})")
    void add(Student student);

    @Select("select s.* from student s where s.id = #{id}")
    Student selectById(Integer id);

    void update(Student student);

    void delete(List<Integer> ids);

    @Update("update student s set violation_count = #{violationCount}, violation_score = #{score}, update_time = #{updateTime} where s.id = #{id}")
    void handleViolation(Integer id, Integer violationCount, Integer score, LocalDateTime updateTime);

    List<StudentDegreeData> getStudentDegreeData();
}
