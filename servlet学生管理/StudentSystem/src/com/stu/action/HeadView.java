package com.stu.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stu.entity.User;

@WebServlet(urlPatterns="/stu/nav/*")
public class HeadView extends HttpServlet{
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathinfo = req.getPathInfo();
        
        
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        
        Integer online = (Integer) req.getServletContext().getAttribute("online");

        PrintWriter out = resp.getWriter();
        
        
        //获取session作用域中存放的用户对象
        User user = (User) req.getSession().getAttribute("user");

        // 输出导航...
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='utf-8' />");
        out.println("<title>学生管理系统</title>");
        out.println("<!--引入bootstrap样式文件-->");
        out.println("<link rel='stylesheet' type='text/css' href='"+req.getContextPath()+"/dist/css/bootstrap.min.css'/>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<nav class='navbar navbar-default' role='navigation'>");
        out.println("<div class='container-fluid'>");
        out.println("<div class='navbar-header'>");
        out.println("<button type='button' class='navbar-toggle' data-toggle='collapse'  data-target='#example-navbar-collapse'>");

        out.println("<span class='sr-only'>切换导航</span>");
        out.println("<span class='icon-bar'></span>");
        out.println("<span class='icon-bar'></span>");
        out.println("<span class='icon-bar'></span>");
        out.println("</button>");
        out.println("<a class='navbar-brand' href='#'>TPCS</a>");
        out.println("</div>");
        out.println("<div class='collapse navbar-collapse' id='example-navbar-collapse'>");
        out.println("<ul class='nav navbar-nav navbar-right'>");
        out.println("<li>");
        out.println("<a href='#'>"+user.getUsername()+"</a></li>");
        out.println("<li>");
        out.println("<a href='#'>登录</a></li>");
        out.println("<li>");
        out.println("<a href='#'><span class='badge pull-right'>"+online+"</span>在线人数</a></li>");
        out.println("<li>");
        out.println("<a href='#'><span class='badge pull-right'>0</span>总访问量</a></li>");
        out.println("<li>");
        out.println("<a href='"+req.getContextPath()+"/user/safeExit'>安全退出</a></li>");
        out.println("</ul>");
        out.println("</div>");
        out.println("</div>");
        out.println("</nav>");
        out.println("</div>");

        out.println("<div class='container'>");
        out.println("<ol class='breadcrumb'>");
        out.println("<li>");
        out.println("<a href='#'>Home</a></li>");
        out.println("<li>");
        out.println("<a href='#'>JSD1711</a></li>");
        out.println("<li class='active'>学生列表</li>");
        out.println("</ol>");
        out.println("</div>");
        
        
        switch(pathinfo){
        case "/head":
            req.getRequestDispatcher("/stu/stuview").include(req, resp);
            break;
        }
        
        
        
    }
}
