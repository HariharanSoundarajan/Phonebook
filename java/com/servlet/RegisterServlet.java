package com.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.entity.User;
import com.dao.UserDAO;

import java.io.IOException;

import com.conn.DbConnect;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		User u=new User(name,email,password);
		UserDAO dao=new UserDAO(DbConnect.getConn());
		boolean f=dao.userRegister(u);
		
		HttpSession session=request.getSession();
		if (f) {
			session.setAttribute("sucssMsg", "User Register Successfully.");
			response.sendRedirect("register.jsp");
			//System.out.println("User Register Successfully..");
		}
		else {
			session.setAttribute("errorMsg", "Something Went wrong on server.");
			response.sendRedirect("register.jsp");
			// System.out.println("Something Went wrong on server..");
		}
	}

}
