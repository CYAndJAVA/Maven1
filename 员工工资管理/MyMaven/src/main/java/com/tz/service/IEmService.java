package com.tz.service;

import java.util.List;

import com.tz.entity.Employee;

public interface IEmService {
    public void insertImploy(Employee employee);
    
    public List<Employee> findEmByNumber(String emnumber);
    
    public void deleteEmByNumber(String emnumber);
    
    public void updateEmployee(Employee employee);
    
    public Employee findById(Long id);
    
    public void updates(String emid,String name,String gender,String sezhic,String ruzhitime,String ephong);

    public void addNewEmBystr(String enumber,String namen,String gendern,String sezhicn,String ruzhitimen,String ephongn);
    //1 good   0 bad   2 没有信息
    public int checkEm(String newNum);
}
