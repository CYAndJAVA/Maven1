package com.stu.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stu.entity.Student;
@WebServlet(urlPatterns="/stu/stuview")
public class Stuview extends HttpServlet{
    private static final long serialVersionUID = 1L;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter out = resp.getWriter();
        
        //获取到request作用域中存放的学生集合
        @SuppressWarnings("unchecked")
        List<Student> list = (List<Student>) req.getAttribute("stulist");

        out.println("<div class='container'>");
        out.println("<form action='"+req.getContextPath()+"/stu/list' class='bs-example bs-example-form' role='form'>");
        out.println("<div class='row'>");
        out.println("<div class='col-md-3 col-xs-3 col-sm-12'>");
        out.println("<div class='input-group'>");
        out.println("<input type='text' value='"+(req.getAttribute("searchName")==null?"":(((String) req.getAttribute("searchName")).trim().length()==0?"":req.getAttribute("searchName")))+"' name='searchName' placeholder='根据学生姓名模糊查询' class='form-control'>");
        out.println("<span class='input-group-btn'>");
        out.println("<button class='btn btn-default' type='submit'>查询");

        out.println("</button>");
        out.println("</span>");
        out.println("</div>");
        out.println("</div>");
        out.println("<div class='col-md-3'>");
        out.println("<input type='hidden' id='path' value='"+req.getContextPath()+"'>");
        out.println("<button type='button' class='btn btn-default' onclick='insertStudent()'>添加学生</button>");
        out.println("<button type='button' class='btn btn-danger' onclick='delmore()'>删除学生</button>");
        out.println("</div>");
        out.println("</div>");
        out.println("</form>");
        out.println("</div>");

        out.println("<div class='container'>");
        out.println("<div class='table-responsive'>");
        out.println("<table class='table'>");
        out.println("<caption>学生列表</caption>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th><input name=checkall type='checkbox'/></th>");
        out.println("<th>序号</th>");
        out.println("<th>学生编号</th>");
        out.println("<th>学生姓名</th>");
        out.println("<th>学生性别</th>");
        out.println("<th>出生日期</th>");
        out.println("<th>操作 </th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");
        
        if(null!=list && list.size()>0){
            int index = 0;
            for (Student s : list) {
                out.println("<tr>");
                out.println("<td><input name='checkall' value='"+s.getId()+"' type='checkbox'/></td>");
                out.println("<td>"+(++index)+"</td>");
                out.println("<td>"+s.getSno()+"</td>");
                out.println("<td>"+s.getSuName()+"</td>");
                out.println("<td>"+s.getGender().toString()+"</td>");
                out.println("<td>"+String.format("%tF", s.getBirthday())+"</td>");
                out.println("<td>");
                
                out.println("<a href='"+req.getContextPath()+"/stu/delete?id="+s.getId()+"'>");
                out.println("<span title='删除学生' class='glyphicon glyphicon-trash text-danger'>");
                out.println("</span>");
                out.println("</a>");
                out.println("<a href='"+req.getContextPath()+"/stu/updateStudent?id="+s.getSno()+"'>");
                out.println("<span title='修改学生' class='glyphicon glyphicon-edit text-warning'>");
                out.println("</span></a>");
                out.println("</td>");
                out.println("</tr>");
            }
        }
    
        out.println("</tbody>");
        out.println("</table>");
        out.println("</div>");

        out.println("</div>");

        out.println("<!--由于bootstrap里面的Js插件依赖于jquery.所以优先引入jquery-->");
        out.println("<script src='"+req.getContextPath()+"/js/jquery.min.js' type='text/javascript'>");
        out.println("</script>");
        out.println("<script src='"+req.getContextPath()+"/dist/js/bootstrap.min.js' type='text/javascript'>");
        out.println("</script>");
        out.println("<script src='"+req.getContextPath()+"/js/stuCheckbox.js' type='text/javascript'>");
        out.println("</script>");
        out.println("<script src='"+req.getContextPath()+"/js/InsertStudent.js' type='text/javascript'>");
        out.println("</script>");
        out.println("</body>");
        out.println("</html>");
            
            
        
        
        }
        
        
    }

