package com.stu.action;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stu.entity.User;
import com.stu.service.IUser;
import com.stu.service.impl.UserImpl;

/**
 * 负责接收登陆界面的username以及password
 * 根据判断得到的结果来跳转到不同的地方...
 * @author Administrato
 * @date 2018年3月13日 下午4:00:07
 * 本类是用于演示
 */
@WebServlet(urlPatterns="/user/logincl")
public class LoginClAction extends HttpServlet{

	private static final long serialVersionUID = -1827688398615703117L;
	private IUser iu = new UserImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String contextpath = req.getContextPath();
	    String username = req.getParameter("username");
	    String password = req.getParameter("password");
		User user = iu.getByUserName(username);
		if(user == null){
		    resp.sendRedirect(contextpath+"/user/loginView?error=1");
		}else{
		    if(user.getPassword().equals(password)){
		        String jzw = req.getParameter("jzw");
		        if(jzw != null){
		            username = URLEncoder.encode(URLEncoder.encode(username, "utf-8"), "utf-8");
		            Cookie c = new Cookie("login", username+":"+password);
		            c.setPath("/");
		            c.setMaxAge(60);
		            resp.addCookie(c);
		        }else{
		            Cookie c = new Cookie("login", ";");
                    c.setPath("/");
                    c.setMaxAge(1);
                    resp.addCookie(c);
		        }
		        req.getSession().setAttribute("user", user);
		        resp.sendRedirect(req.getContextPath()+"/stu/list");
		        
		    }else{
		        resp.sendRedirect(contextpath+"/user/loginView?error=2");
		    }
		}
		
		
	}
}
