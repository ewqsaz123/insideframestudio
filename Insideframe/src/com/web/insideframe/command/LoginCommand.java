package com.web.insideframe.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.insideframe.service.LoginService;

public class LoginCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		String pw=request.getParameter("pw");
		
		LoginService ls=new LoginService();
		if(ls.loginCheck(email, pw)){
			request.setAttribute("islogin",true);
			request.getSession().setAttribute("member",ls.loginMember(email, pw));
			RequestDispatcher rd=request.getRequestDispatcher("index.do");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			request.setAttribute("islogin",false);
		}
	}
}
