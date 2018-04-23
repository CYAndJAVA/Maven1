package com.stu.mapper;

import java.util.List;

import com.stu.entity.Student;

public interface StudentMapper {
    public void saveStudent(Student student);
    public List<Student> findByName(String name);//模糊查询
    public Student findBySno(String sno);
    public void update(Student s);
    public void delById(Integer id);
}
