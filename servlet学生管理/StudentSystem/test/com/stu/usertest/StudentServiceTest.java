package com.stu.usertest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.stu.entity.Student;
import com.stu.entity.enums.Gender;
import com.stu.service.IStudent;
import com.stu.service.impl.StudentImpl;
import com.stu.util.TimeTool;

public class StudentServiceTest {
    private IStudent stu = new StudentImpl();
    
    @Test
    public void testSaveStudent(){
        List<Student> list = new ArrayList<Student>();
        
        Student s1 = new Student("1001", "lili",
                TimeTool.createDate(2001, 1, 2), Gender.女);
        Student s2 = new Student("1002", "aaa",
                TimeTool.createDate(2023, 1, 2), Gender.女);
        Student s3 = new Student("1003", "sss",
                TimeTool.createDate(2004, 1, 2), Gender.男);
        Student s4 = new Student("1004", "ddd",
                TimeTool.createDate(2065, 1, 2), Gender.女);
        Student s5 = new Student("1005", "fff",
                TimeTool.createDate(2004, 1, 2), Gender.男);
        Student s6 = new Student("1006", "ggg",
                TimeTool.createDate(2008, 1, 2), Gender.女);
        Student s7 = new Student("1007", "ere",
                TimeTool.createDate(2091, 1, 2), Gender.男);
        Student s8 = new Student("1008", "fd",
                TimeTool.createDate(2001, 1, 2), Gender.女);
        Student s9 = new Student("1009", "vdvs",
                TimeTool.createDate(2051, 1, 2), Gender.男);
        Student s10 = new Student("1010", "nhh",
                TimeTool.createDate(2041, 1, 2), Gender.女);
        Student s11 = new Student("1011", "poio",
                TimeTool.createDate(1901, 1, 2), Gender.女);
        Student s12 = new Student("1012", "trswq",
                TimeTool.createDate(2011, 1, 2), Gender.男);
        Student s13 = new Student("1013", "nbvc",
                TimeTool.createDate(2012, 1, 2), Gender.女);
        Student s14 = new Student("1014", "yuvd",
                TimeTool.createDate(2013, 1, 2), Gender.男);
        Student s15 = new Student("1015", "poqs",
                TimeTool.createDate(2012, 1, 2), Gender.女);
        Student s16 = new Student("1016", "bmng",
                TimeTool.createDate(2015, 1, 2), Gender.女);
        Student s17 = new Student("1017", "aswrc",
                TimeTool.createDate(2001, 1, 2), Gender.男);
        Student s18 = new Student("1018", "fgghj",
                TimeTool.createDate(2001, 1, 2), Gender.女);
        Student s19 = new Student("1019", "cvbbnm",
                TimeTool.createDate(2016, 1, 2), Gender.女);
        Student s20 = new Student("1020", "qslpoi",
                TimeTool.createDate(2001, 1, 2), Gender.男);
        Student s21 = new Student("1021", "nywes",
                TimeTool.createDate(2001, 1, 2), Gender.女);
        list.add(s1);list.add(s2);list.add(s3);list.add(s4);
        list.add(s5);list.add(s6);list.add(s7);list.add(s8);
        list.add(s9);list.add(s10);list.add(s11);list.add(s12);
        list.add(s13);list.add(s14);list.add(s15);list.add(s16);
        list.add(s17);list.add(s18);list.add(s19);list.add(s20);list.add(s21);
        
        for (Student student : list) {
            stu.saveStudent(student);
        }
    }
    
    @Test
    public void findStudentByname(){
        List<Student> list = stu.findByName(null);
        for (Student student : list) {
            System.out.println(student);
        }
    }
    
    @Test
    public void findStudentBySno(){
        Student s = stu.findBySno("");
        System.out.println(s);
    }

    @Test
    public void update(){
        Student s = new Student("1001", "lida",
                TimeTool.createDate(1991, 1, 2), Gender.男);
        s.setId(1);
        stu.update(s);
    } 
    @Test
    public void deletebyId(){
        stu.delById(21);
    }
}
