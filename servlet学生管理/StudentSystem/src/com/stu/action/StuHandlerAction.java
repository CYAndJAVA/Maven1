package com.stu.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.stu.entity.Student;
import com.stu.entity.enums.Gender;
import com.stu.service.IStudent;
import com.stu.service.impl.StudentImpl;
import com.stu.util.TimeTool;
@WebServlet(urlPatterns="/stu/*")
public class StuHandlerAction extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private IStudent ist = new StudentImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        String pathinfo = req.getPathInfo();
        List<Student> list = null;
        switch(pathinfo){
        case "/list":
            String searchName = req.getParameter("searchName");
            searchName = (searchName==null?"":(searchName.trim().length()==0?"":searchName));
            list = ist.findByName(searchName);
            req.setAttribute("stulist", list);
            req.setAttribute("searchName",searchName);
            req.getRequestDispatcher("/stu/nav/head").forward(req, resp);
            break;
        case "/delete":
            String searchName1 = req.getParameter("searchName");
            System.out.println(searchName1);
            searchName1 = (searchName1==null?"":(searchName1.trim().length()==0?"":searchName1));
            int id = Integer.parseInt(req.getParameter("id"));
            ist.delById(id);
            list = ist.findByName(searchName1);
            req.setAttribute("stulist", list);
            req.setAttribute("searchName",searchName1);
            resp.sendRedirect(req.getContextPath()+"/stu/nav/head");
            break;
        case "/deletemore":
            String sids = req.getParameter("sids");
            
            String[] sid = sids.split(";");
            for (int i = 0; i < sid.length; i++) {
                ist.delById(Integer.parseInt(sid[i]));
            }
            req.setAttribute("stulist", list);
            resp.sendRedirect(req.getContextPath()+"/stu/nav/head");
            break;
        case "/updateStudent":
            String stid = req.getParameter("id");
            Student student1 = ist.findBySno(stid);
            req.setAttribute("student1",student1 );
            req.getRequestDispatcher("/stu/updateView").forward(req, resp);
            break;
        case "/update":
            String sno1 = req.getParameter("sno");
            Student stunew = ist.findBySno(sno1);
            
            String sname = req.getParameter("sname");
            String gender = req.getParameter("gender");
            gender = "M".equals(gender)?"男":"女";
            String bth = req.getParameter("birthday");
            stunew.setGender(Gender.valueOf(gender));
            stunew.setSuName(sname);
            stunew.setBirthday(TimeTool.parse(bth, "yyyy-MM-dd"));
            ist.update(stunew);
            resp.sendRedirect(req.getContextPath()+"/stu/nav/head");
            break;
        case "/insertStu":
            Student stunew1 = new Student();
            String sno2 = req.getParameter("sno1");
            String sname1 = req.getParameter("sname1");
            String gender1 = req.getParameter("gender1");
            gender1 = "M".equals(gender1)?"男":"女";
            String bth1 = req.getParameter("birthday1");
            stunew1.setSno(sno2);
            stunew1.setGender(Gender.valueOf(gender1));
            stunew1.setSuName(sname1);
            stunew1.setBirthday(TimeTool.parse(bth1, "yyyy-MM-dd"));
            ist.saveStudent(stunew1);
            resp.sendRedirect(req.getContextPath()+"/stu/nav/head");
            break;
        }
    }
}
