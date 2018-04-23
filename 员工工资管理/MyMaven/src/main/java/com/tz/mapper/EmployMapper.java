package com.tz.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tz.entity.Employee;

public interface EmployMapper {
    public void insertImploy(Employee employee);
    
    public List<Employee> findEmByNumber(@Param("emnumber")String emnumber);
    
    public void deleteEmByNumber(String emnumber);
    
    public void updateEmployee(Employee employee);
    
    public Employee findById(Long id);
}
