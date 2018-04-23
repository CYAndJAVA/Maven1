package com.tz.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tz.entity.Salary;
import com.tz.mapper.SalaryMapper;
import com.tz.service.ISaService;
import com.tz.util.MybatisUtil;

public class SaServiceImpl implements ISaService{
    @Override
    public void insertSalary(Salary s) {
        SqlSession session = MybatisUtil.getSqlSession();
        SalaryMapper mapper = session.getMapper(SalaryMapper.class);
        mapper.insertSalary(s);
        session.commit();
        session.close();
    }

    @Override
    public List<Salary> findByEid(Long Eid) {
        SqlSession session = MybatisUtil.getSqlSession();
        SalaryMapper mapper = session.getMapper(SalaryMapper.class);
        List<Salary> list = mapper.findByEid(Eid);
        return list;
    }

    @Override
    public void deleteSalary(Long sid) {
        SqlSession session = MybatisUtil.getSqlSession();
        SalaryMapper mapper = session.getMapper(SalaryMapper.class);
        mapper.deleteSalary(sid);
        session.commit();
        session.close();
        
    }

}
