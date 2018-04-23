package com.stu.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/user/loginView")
public class LoginViewAction extends HttpServlet{
    private static final long serialVersionUID = 1L;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String username = "";
        String password = "";
        Cookie[] cook = req.getCookies();
        if(null != cook && cook.length > 0){
            for(Cookie c : cook){
                if("login".equals(c.getName())){
                    String[] value = c.getValue().split(":");
                    username = URLEncoder.encode(URLEncoder.encode(value[0],"utf-8"),"utf-8");
                    password = value[1];
                }
            }
        }
        String error = req.getParameter("error");
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='utf-8' />");
        out.println("<title>登陆入口</title>");
        out.println("<!--引入bootstrap样式文件-->");
        out.println("<link rel='stylesheet' type='text/css' href='/StudentSystem/dist/css/bootstrap.min.css'/>");
        out.println("<link rel='stylesheet' type='text/css' href='/StudentSystem/css/loginDiv.css'/>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container' style='margin-top: 100px;'>");
        out.println("<div id='loginDiv'>");
        out.println("<fieldset>");
        out.println("<form class='form-horizontal' action='/StudentSystem/user/logincl' method='post'>");
        out.println("<legend>");
        out.println("<h4>用户登陆入口</h4></legend>");
        out.println("<div class='form-group has-feedback'>");
        out.println("<label for='firstname' class='col-sm-2 control-label'>用户名</label>");
        out.println("<div class='col-md-3 col-sm-3'>");
        out.println("<input name='username' value='"+username+"' type='text' class='form-control' id='firstname' placeholder='请输入用户名'>");
        out.println("<span class='glyphicon glyphicon-user form-control-feedback'></span>");
        out.println("</div>");
        
        if("1".equals(error)){
            out.println("<div class='col-md-2'>");
            out.println("<label class='alert-danger'>用户名不存在</label>");
            out.println("</div>");
        }
        
        out.println("</div>");
        out.println("<div class='form-group has-feedback'>");
        out.println("<label for='lastname' class='col-sm-2 control-label'>密码</label>");
        out.println("<div class='col-md-3 col-sm-3'>");
        out.println("<input name='password' value='"+password+"' type='password' class='form-control' id='lastname' placeholder='请输入密码'>");
        out.println("<span class='glyphicon glyphicon-lock form-control-feedback'>");
        out.println("</span>");
        out.println("</div>");
        
        if("2".equals(error)){
            out.println("<div class='col-md-2'>");
            out.println("<label class='alert-danger'>密码错误</label>");
            out.println("</div>");
        }
        
        out.println("</div>");
        out.println("<div class='form-group'>");
        out.println("<div class='col-sm-offset-2 col-sm-10'>");
        out.println("<div class='checkbox'>");
        out.println("<label>");
        out.println("<input type='checkbox' name='jzw'>请记住我");
        out.println("</label>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("<div class='form-group'>");
        out.println("<div class='col-sm-offset-2 col-sm-10'>");
        out.println("<button type='submit' class='btn btn-default'>登录</button>");
        out.println("</div>");
        out.println("</div>");
        out.println("</form>");
        out.println("</fieldset>");
        out.println("</div>");
        out.println("</div>");

        out.println("<!--由于bootstrap里面的Js插件依赖于jquery.所以优先引入jquery-->");
        out.println("<script src='/StudentSystem/js/jquery.min.js' type='text/javascript'>");
        out.println("</script>");
        out.println("<script src='/StudentSystem/dist/js/bootstrap.min.js' type='text/javascript'>");
        out.println("</script>");
        out.println("</body>");
        out.println("</html>");
        
        out.close();
    }

}
