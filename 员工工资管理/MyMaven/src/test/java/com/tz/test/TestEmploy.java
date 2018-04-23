package com.tz.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.tz.entity.Employee;
import com.tz.entity.Gender;
import com.tz.entity.ZhiCheng;
import com.tz.service.IEmService;
import com.tz.util.BeansFactory;
import com.tz.util.TimeTool;

public class TestEmploy {
    private IEmService es = (IEmService) BeansFactory.getInstance("iemService");
    @Test
    public void insertEm(){
        List<Employee> list = new ArrayList<Employee>();
        Employee a1 = new Employee("TZ001", "tom1", Gender.男, ZhiCheng.初级销售员, TimeTool.createDate(1998, 6, 12), "13657485769");
        Employee a2 = new Employee("TZ002", "tom2", Gender.女, ZhiCheng.中级销售员, TimeTool.createDate(1999, 6, 12), "13657485769");
        Employee a3 = new Employee("TZ003", "tom3", Gender.男, ZhiCheng.高级销售员, TimeTool.createDate(2001, 6, 12), "13657485769");
        Employee a4 = new Employee("TZ004", "tom4", Gender.女, ZhiCheng.初级销售员, TimeTool.createDate(2002, 6, 12), "13657485769");
        Employee a5 = new Employee("TZ005", "tom5", Gender.男, ZhiCheng.初级销售员, TimeTool.createDate(2003, 6, 12), "13657485769");
        Employee a6 = new Employee("TZ006", "tom6", Gender.女, ZhiCheng.中级销售员, TimeTool.createDate(2004, 6, 12), "13657485769");
        Employee a7 = new Employee("TZ007", "tom7", Gender.男, ZhiCheng.部门经理, TimeTool.createDate(2005, 6, 12), "13657485769");
        list.add(a1);list.add(a2);list.add(a3);list.add(a4);list.add(a5);list.add(a6);list.add(a7);
        for (Employee e : list) {
            //es.insertImploy(e);
            
        }
    }
    @Test
    public void findemBynumber(){
        List<Employee> list = es.findEmByNumber("TZ002");
        for (Employee d : list) {
            System.out.println(d);
        }
    }
    @Test
    public void updateEmploy(){
        List<Employee> list = es.findEmByNumber("TZ001");
        Employee e = list.get(0);
        e.setGender(Gender.女);
        es.updateEmployee(e);
    }
    @Test
    public void deleteemploy(){
        //es.deleteEmByNumber("TZ007");
    }
    @Test
    public void testFindById(){
        Employee e = es.findById(1L);
        System.out.println(e);
    }
    @Test
    public void xiugai(){
        es.updates("3", "sdf", "女", "部门经理", "2017-12-23", "1324567897");
    }
    @Test
    public void testAddOne(){
        es.addNewEmBystr("dfdfd", "jj", "男", "部门经理", "2017-12-23", "87654");
    }
}
