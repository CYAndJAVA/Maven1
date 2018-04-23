package com.tz.service;

import java.util.List;

import com.tz.entity.Salary;

public interface ISaService {
    
    public void insertSalary(Salary s);
    
    List<Salary> findByEid(Long Eid);
    
    public void deleteSalary(Long sid);
}
