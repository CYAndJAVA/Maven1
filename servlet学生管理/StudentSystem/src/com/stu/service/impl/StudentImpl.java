package com.stu.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.stu.entity.Student;
import com.stu.mapper.StudentMapper;
import com.stu.service.IStudent;
import com.stu.util.MybatisUtil;

public class StudentImpl implements IStudent{
    private StudentMapper mapper;
    private SqlSession session;
    @Override
    public void saveStudent(Student student) {
        session = MybatisUtil.getSqlSession();
        mapper = session.getMapper(StudentMapper.class);
        if(student != null){
            mapper.saveStudent(student);
            session.commit();
        }
        session.close();
    }

    @Override
    public List<Student> findByName(String name) {
        name = (name==null?null:(name.trim().length()!=0?name:null));
        session = MybatisUtil.getSqlSession();
        mapper = session.getMapper(StudentMapper.class);
        List<Student> list = mapper.findByName(name);
        return list;
    }

    @Override
    public Student findBySno(String sno) {
        session = MybatisUtil.getSqlSession();
        mapper = session.getMapper(StudentMapper.class);
        Student s = mapper.findBySno(sno);
        return s;
    }

    @Override
    public void update(Student s) {
        session = MybatisUtil.getSqlSession();
        mapper = session.getMapper(StudentMapper.class);
        mapper.update(s);
        session.commit();
        session.close();
    }

    @Override
    public void delById(Integer id) {
        session = MybatisUtil.getSqlSession();
        mapper = session.getMapper(StudentMapper.class);
        mapper.delById(id);
        session.commit();
        session.close();
        
    }

}
