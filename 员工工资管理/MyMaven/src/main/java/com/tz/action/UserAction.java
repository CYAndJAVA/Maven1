package com.tz.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tz.entity.Employee;
import com.tz.entity.Salary;
import com.tz.service.IEmService;
import com.tz.service.ISaService;
import com.tz.util.BeansFactory;
import com.tz.util.TimeTool;

@WebServlet(urlPatterns = "/user/*")
public class UserAction extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private IEmService es = (IEmService) BeansFactory.getInstance("iemService");
    private ISaService ias = (ISaService) BeansFactory.getInstance("saService");
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        PrintWriter out = resp.getWriter();
        String contextPath = req.getContextPath();
        switch (pathInfo) {
        case "/firstView":
            List<Employee> list = es.findEmByNumber(null);
            req.setAttribute("elt", list);
            req.getRequestDispatcher("/WEB-INF/pages/tableView.jsp").forward(req, resp);
            break;
        case "/delem":
            String sids = req.getParameter("sids");
            String[] arr = sids.split(";");
            for (int i = 0; i < arr.length; i++) {
                es.deleteEmByNumber(arr[i]);
            }
            resp.sendRedirect(contextPath);
            break;
        case "/updateEm":
            String eid = req.getParameter("eid");
            if (eid == null || eid.trim().length() == 0) {
                resp.sendRedirect(contextPath);
            } else {
                Employee e = es.findById(Long.parseLong(eid));
                req.setAttribute("updateEm", e);
                req.getRequestDispatcher("/WEB-INF/pages/updateView.jsp").forward(req, resp);
            }
            break;
        case "/updateContol":
            String emid = req.getParameter("emid");
            String name = req.getParameter("name");
            String gender = req.getParameter("gender");
            String sezhic = req.getParameter("sezhic");
            String ruzhitime = req.getParameter("ruzhitime");
            String ephong = req.getParameter("ephong");
            es.updates(emid, name, gender, sezhic, ruzhitime, ephong);
            resp.sendRedirect(contextPath);
            break;
        case "/addNewEmView":
            req.getRequestDispatcher("/WEB-INF/pages/addEmployee.jsp").forward(req, resp);
            break;
        case "/addNewEmContol":
            String enumber = req.getParameter("enumber");
            String namen = req.getParameter("name");
            String gendern = req.getParameter("gender");
            String sezhicn = req.getParameter("sezhic");
            String ruzhitimen = req.getParameter("ruzhitime");
            String ephongn = req.getParameter("ephong");
            es.addNewEmBystr(enumber, namen, gendern, sezhicn, ruzhitimen, ephongn);
            resp.sendRedirect(contextPath);
            break;
        case "/checkNumber":
            String newNum = req.getParameter("newNum");
            int df = es.checkEm(newNum);
            out.print(df);
            break;
        case "/toAdSalyView":
            String nemn = req.getParameter("nemn");
            req.setAttribute("nemn", nemn);
            req.getRequestDispatcher("/WEB-INF/pages/addSalory.jsp").forward(req, resp);
            break;
        case "/AdSalyContol":
            String emnsa = req.getParameter("emnsa");
            String satime = req.getParameter("satime");
            String saall = req.getParameter("saall");
            satime = null==satime?"2000-01-01":(satime.trim().length()>0?satime:"2000-01-01");
            saall = null==saall?"0":(saall.trim().length()>0?saall:"0");
            Long emd = es.findEmByNumber(emnsa).get(0).getId();
            Salary sa = new Salary(TimeTool.parse(satime, "yyyy-MM-dd"), Double.parseDouble(saall), emd);
            ias.insertSalary(sa);
            resp.sendRedirect(contextPath);
            break;
        case "/lookSalaryview":
            String esid = req.getParameter("esid");
            List<Salary> la = ias.findByEid(Long.parseLong(esid));
            if(null != la&& la.size()>0){
                req.setAttribute("safg", la);
                req.getRequestDispatcher("/WEB-INF/pages/salaryView.jsp").forward(req, resp);
            }else{
                resp.sendRedirect(contextPath);
            }
            break;
        case "/deleteSalary":
             String sid = req.getParameter("sid");
             ias.deleteSalary(Long.parseLong(sid));
             resp.sendRedirect(contextPath);
            break;

        }

    }
}
