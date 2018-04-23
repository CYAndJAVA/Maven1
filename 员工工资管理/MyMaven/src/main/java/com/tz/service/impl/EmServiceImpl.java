package com.tz.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tz.entity.Employee;
import com.tz.entity.Gender;
import com.tz.entity.ZhiCheng;
import com.tz.mapper.EmployMapper;
import com.tz.service.IEmService;
import com.tz.util.MybatisUtil;
import com.tz.util.TimeTool;

public class EmServiceImpl implements IEmService{

    @Override
    public void insertImploy(Employee employee) {
        SqlSession session = MybatisUtil.getSqlSession();
        EmployMapper mapper = session.getMapper(EmployMapper.class);
        mapper.insertImploy(employee);
        session.commit();
        session.close();
    }

    @Override
    public List<Employee> findEmByNumber(String emnumber) {
        SqlSession session = MybatisUtil.getSqlSession();
        EmployMapper mapper = session.getMapper(EmployMapper.class);
        List<Employee> e = mapper.findEmByNumber(emnumber);
        session.close();
        return e;
    }

    @Override
    public void deleteEmByNumber(String emnumber) {
        SqlSession session = MybatisUtil.getSqlSession();
        EmployMapper mapper = session.getMapper(EmployMapper.class);
        mapper.deleteEmByNumber(emnumber);
        session.commit();
        session.close();
    }

    @Override
    public void updateEmployee(Employee employee) {
        SqlSession session = MybatisUtil.getSqlSession();
        EmployMapper mapper = session.getMapper(EmployMapper.class);
        mapper.updateEmployee(employee);
        session.commit();
        session.close();
        
    }

    @Override
    public Employee findById(Long id) {
        SqlSession session = MybatisUtil.getSqlSession();
        EmployMapper mapper = session.getMapper(EmployMapper.class);
        Employee e = mapper.findById(id);
        session.close();
        return e;
    }

    @Override
    public void updates(String emid, String name, String gender, String sezhic, String ruzhitime, String ephong) {
        name = null==name?"":(name.trim().length()>0?name:"");
        gender = null==gender?"男":(gender.trim().length()>0?gender:"男");
        sezhic = null==sezhic?"初级销售员":(sezhic.trim().length()>0?sezhic:"初级销售员");
        ruzhitime = null==ruzhitime?"2000-01-01":(ruzhitime.trim().length()>0?ruzhitime:"2000-01-01");
        ephong = null==ephong?"0":(ephong.trim().length()>0?ephong:"0");
        
        Employee e = findById(Long.parseLong(emid));
        e.setGender(Gender.valueOf(gender));
        e.setName(name);
        e.setZhicheng(ZhiCheng.valueOf(sezhic));
        e.setPhone(ephong);
        e.setWorktime(TimeTool.parse(ruzhitime, "yyyy-MM-dd"));
        updateEmployee(e);
    }

    @Override
    public void addNewEmBystr(String enumber, String name, String gender, String sezhic, String ruzhitime,
            String ephong) {
        name = null==name?"":(name.trim().length()>0?name:"");
        gender = null==gender?"男":(gender.trim().length()>0?gender:"男");
        sezhic = null==sezhic?"初级销售员":(sezhic.trim().length()>0?sezhic:"初级销售员");
        ruzhitime = null==ruzhitime?"2000-01-01":(ruzhitime.trim().length()>0?ruzhitime:"2000-01-01");
        ephong = null==ephong?"0":(ephong.trim().length()>0?ephong:"0");
        Employee e = new Employee(enumber, name, Gender.valueOf(gender),
                ZhiCheng.valueOf(sezhic), TimeTool.parse(ruzhitime, "yyyy-MM-dd"), ephong);
        insertImploy(e);
    }

    @Override
    public int checkEm(String newNum) {
        int g = 0;
        if(null == newNum || newNum.trim().length() == 0){
            g = 2;
        }else{
            List<Employee> list = findEmByNumber(newNum);
            if(null == list || list.size()==0){
                g = 0;
            }else{
                g = 1;
            }
        }
        
        return g;
    }
        
}
