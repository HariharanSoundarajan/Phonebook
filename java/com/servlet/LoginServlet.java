package com.servlet;

import java.io.IOException;

import com.conn.DbConnect;
import com.dao.UserDAO;
import com.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String pass=request.getParameter("password");
		
		UserDAO dao=new UserDAO(DbConnect.getConn());
		User u= dao.loginUser(email, pass);
		HttpSession session=request.getSession();
		if(u!=null)
		{
			session.setAttribute("user", u);
			response.sendRedirect("index.jsp");
			//System.out.println("User is Available="+u); 
		}
		else {
			session.setAttribute("invalidMsg", "Invalid email and Password");
			response.sendRedirect("login.jsp");
			//System.out.println("User is Not Available="+u);
		}
		
	}

}
