package com.tz.test;

import java.util.List;

import org.junit.Test;

import com.tz.entity.Salary;
import com.tz.service.ISaService;
import com.tz.util.BeansFactory;
import com.tz.util.TimeTool;

public class TestSalory {
    private ISaService sa = (ISaService) BeansFactory.getInstance("saService");
    @Test
    public void testInserSalory(){
        //Salary s = new Salary(TimeTool.createDate(2000, 1, 1), 2000, 3000, 2999, 1L);
        //sa.insertSalary(s);
    }
    @Test
    public void testfindSalory(){
        List<Salary> s = sa.findByEid(1L);
        for (Salary f : s) {
            System.out.println(f);
        }
    }
    @Test
    public void deleteOneSalary(){
        //sa.deleteSalary(1L);
        
    }
}
