package com.tz.entity;

import java.io.Serializable;
import java.util.Date;

import com.tz.service.IEmService;
import com.tz.util.BeansFactory;

public class Salary implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private IEmService es = (IEmService) BeansFactory.getInstance("iemService");
    private Long sid;
    private Date salarytime;//工资日期
    private double basicsalary=3000.00;//基本工资
    private double sells;//销售总量
    private double taotal;//总计
    private Long emid;
    public Salary() {
        super();
    }
    public Salary(Long sid, Date salarytime, double basicsalary, double sells, double taotal, Long emid) {
        super();
        this.sid = sid;
        this.salarytime = salarytime;
        this.basicsalary = basicsalary;
        this.sells = sells;
        this.taotal = taotal;
        this.emid = emid;
    }
    public Salary(Date salarytime,double sells, Long emid) {
        super();
        this.salarytime = salarytime;
        this.sells = sells;
        this.emid = emid;
        Employee e = es.findById(emid);
        if(e.getZhicheng().equals(ZhiCheng.初级销售员)){
            this.taotal = (int)(((sells * 0.1) + this.basicsalary) * 100) * 0.01;
        }else if(e.getZhicheng().equals(ZhiCheng.中级销售员)){
            this.taotal = (int)(((sells * 0.15) + this.basicsalary) * 100) * 0.01;
        }else if(e.getZhicheng().equals(ZhiCheng.高级销售员)){
            this.taotal = (int)(((sells * 0.2) + this.basicsalary) * 100) * 0.01;
        }else if(e.getZhicheng().equals(ZhiCheng.部门经理)){
            this.taotal = (int)(((sells * 0.3) + this.basicsalary) * 100) * 0.01;
        }else{
            this.taotal = this.basicsalary;
        }
    }
    public Salary(Date salarytime, double basicsalary, double sells) {
        super();
        this.salarytime = salarytime;
        this.basicsalary = basicsalary;
        this.sells = sells;
    }
    public Salary(Date salarytime, double basicsalary, double sells, double taotal, Long emid) {
        super();
        this.salarytime = salarytime;
        this.basicsalary = basicsalary;
        this.sells = sells;
        this.taotal = taotal;
        this.emid = emid;
    }
    public Long getSid() {
        return sid;
    }
    public void setSid(Long sid) {
        this.sid = sid;
    }
    public Date getSalarytime() {
        return salarytime;
    }
    public void setSalarytime(Date salarytime) {
        this.salarytime = salarytime;
    }
    public double getBasicsalary() {
        return basicsalary;
    }
    public void setBasicsalary(double basicsalary) {
        this.basicsalary = basicsalary;
    }
    public double getSells() {
        return sells;
    }
    public void setSells(double sells) {
        this.sells = sells;
    }
    public double getTaotal() {
        return taotal;
    }
    public void setTaotal(double taotal) {
        this.taotal = taotal;
    }
    public Long getEmid() {
        return emid;
    }
    public void setEmid(Long emid) {
        this.emid = emid;
    }
    @Override
    public String toString() {
        return "Salary [sid=" + sid + ", salarytime=" + salarytime + ", basicsalary=" + basicsalary + ", sells=" + sells
                + ", taotal=" + taotal + ", emid=" + emid + "]";
    }
}
