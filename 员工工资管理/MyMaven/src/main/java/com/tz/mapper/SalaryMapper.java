package com.tz.mapper;

import java.util.List;

import com.tz.entity.Salary;

public interface SalaryMapper {
    public void insertSalary(Salary s);
    
    List<Salary> findByEid(Long Eid);
    
    public void deleteSalary(Long sid);
}
