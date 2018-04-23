package com.stu.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stu.entity.Student;

@WebServlet(urlPatterns = "/stu/updateView")
public class UpdateViewAction extends HttpServlet {

	private static final long serialVersionUID = 5361881087551765651L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.获取request作用域中存储的需要修改的对象
		Student s = (Student) req.getAttribute("student1");

		PrintWriter out = resp.getWriter();
		out.println("<div class='container' style='margin-top: 30px;'>");
		out.println("<div id='loginDiv'>");
		out.println("<fieldset>");
		out.println("<form class='form-horizontal' action='"+req.getContextPath()+"/stu/update' method='post'>");
		out.println("<legend>");
		out.println("<h4>用户修改入口</h4>");
		out.println("</legend>");
		out.println("<div class='form-group'>");
		out.println("<label class='col-sm-2 control-label'>学生编号</label>");
		out.println("<div class='col-md-3 col-sm-3'>");
		out.println("<input type='text' readonly class='form-control' value='"+s.getSno()+"'>");
		
		//隐藏域存放id
		out.println("<input type='hidden' name='sno' value='"+s.getSno()+"'>");
		
		out.println("</div>");
		out.println("</div>");
		out.println("<div class='form-group'>");
		out.println("<label class='col-sm-2 control-label'>学生姓名</label>");
		out.println("<div class='col-md-3 col-sm-3'>");
		out.println("<input type='text' class='form-control' name='sname' value='"+s.getSuName()+"'>");
		out.println("</div>");
		out.println("</div>");
		out.println("<div class='form-group'>");
		out.println("<label class='col-sm-2 control-label'>性别</label>");
		out.println("<div class='col-md-3 col-sm-3'>");
		
		if("男".equals(s.getGender().toString())){
			out.println("<label class='radio-inline'>");
			out.println("<input type='radio' name='gender' checked  value='M'>男");
			out.println("</label>");
			out.println("<label class='radio-inline'>");
			out.println("<input type='radio' name='gender' value='F'>女");
			out.println("</label>");
		}else{
			out.println("<label class='radio-inline'>");
			out.println("<input type='radio' name='gender' value='M'>男");
			out.println("</label>");
			out.println("<label class='radio-inline'>");
			out.println("<input type='radio' name='gender' checked value='F'>女");
			out.println("</label>");
		}
		
		out.println("</div>");
		out.println("</div>");
		out.println("<div class='form-group'>");
		out.println("<label class='col-md-2 control-label'>出生年月</label>");
		out.println("<div class='col-md-3 has-feedback'>");
		out.println("<input type='text' class='form-control' value='"+String.format("%tF",s.getBirthday())+"' id='datetimepicker' name='birthday'>");
		out.println("<span class='glyphicon glyphicon-time form-control-feedback'>");
		out.println("</span>");
		out.println("</div>");
		out.println("</div>");
		out.println("<div class='form-group'>");
		out.println("<div class='col-sm-offset-2 col-sm-10'>");
		out.println("<button type='submit' class='btn btn-default'>修改</button>");
		out.println("</div>");
		out.println("</div>");
		out.println("</form>");
		out.println("</fieldset>");
		out.println("</div>");
		out.println("</div>");

		out.println("<!--由于bootstrap里面的Js插件依赖于jquery.所以优先引入jquery-->");
		out.println("<script src='" + req.getContextPath() + "/js/jquery.min.js' type='text/javascript'></script>");
		out.println("<script src='" + req.getContextPath() + "/dist/js/bootstrap.min.js' type='text/javascript'>");
		out.println("</script>");
		out.println("<script src='" + req.getContextPath() + "/js/moment.js'></script>");
		out.println("<script src='" + req.getContextPath() + "/js/bootstrap-datetimepicker.min.js'></script>");
		out.println("<script src='" + req.getContextPath() + "/js/date.js'>");

		out.println("</script>");
		out.println("</body>");
		out.println("</html>");
	}
}
