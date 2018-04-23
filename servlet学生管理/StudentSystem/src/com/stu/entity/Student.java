package com.stu.entity;

import java.io.Serializable;
import java.util.Date;

import com.stu.entity.enums.Gender;

public class Student implements Serializable{
    private static final long serialVersionUID = 1L;
    private int id;
    private String sno;//学号
    private String suName;
    private Date birthday;
    private Gender gender;
    public Student() {
        super();
    }
    public Student(String sno, String suName, Date birthday, Gender gender) {
        super();
        this.sno = sno;
        this.suName = suName;
        this.birthday = birthday;
        this.gender = gender;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getSno() {
        return sno;
    }
    public void setSno(String sno) {
        this.sno = sno;
    }
    public String getSuName() {
        return suName;
    }
    public void setSuName(String suName) {
        this.suName = suName;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    @Override
    public String toString() {
        return "Student [id=" + id + ", sno=" + sno + ", suName=" + suName + ", birthday=" + birthday + ", gender="
                + gender + "]";
    }
    

}
