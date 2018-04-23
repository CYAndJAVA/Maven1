package com.tz.entity;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable{

    /**
     * 员工
     */
    private static final long serialVersionUID = 1L;
    private Long id;
    private String emnumber;//编号
    private String name;
    private Gender gender;
    private ZhiCheng zhicheng;
    private Date worktime;//入职时间
    private String phone;
    
    public Employee() {
        super();
    }

    public Employee(Long id, String emnumber, String name, Gender gender, ZhiCheng zhicheng, Date worktime,
            String phone) {
        super();
        this.id = id;
        this.emnumber = emnumber;
        this.name = name;
        this.gender = gender;
        this.zhicheng = zhicheng;
        this.worktime = worktime;
        this.phone = phone;
    }

    public Employee(String emnumber, String name, Gender gender, ZhiCheng zhicheng, Date worktime, String phone) {
        super();
        this.emnumber = emnumber;
        this.name = name;
        this.gender = gender;
        this.zhicheng = zhicheng;
        this.worktime = worktime;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getemnumber() {
        return emnumber;
    }

    public void setemnumber(String emnumber) {
        this.emnumber = emnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public ZhiCheng getZhicheng() {
        return zhicheng;
    }

    public void setZhicheng(ZhiCheng zhicheng) {
        this.zhicheng = zhicheng;
    }

    public Date getWorktime() {
        return worktime;
    }

    public void setWorktime(Date worktime) {
        this.worktime = worktime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((emnumber == null) ? 0 : emnumber.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (emnumber == null) {
            if (other.emnumber != null)
                return false;
        } else if (!emnumber.equals(other.emnumber))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", emnumber=" + emnumber + ", name=" + name + ", gender=" + gender + ", zhicheng="
                + zhicheng + ", worktime=" + worktime + ", phone=" + phone + "]";
    }
    
    
}
