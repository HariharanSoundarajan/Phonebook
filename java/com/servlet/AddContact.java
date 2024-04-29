package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.conn.DbConnect;
import com.dao.ContactDao;
import com.entity.contact;

@WebServlet("/addContact")
public class AddContact extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId=Integer.parseInt(request.getParameter("userid"));
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phno=request.getParameter("phno");
		String about=request.getParameter("about");
		
		contact c=new contact(name,email,phno,about,userId);
		ContactDao dao=new ContactDao(DbConnect.getConn());
		HttpSession session=request.getSession();
	boolean f=dao.saveContact(c);
	if(f) {
		session.setAttribute("succMsg","Your Contact is Saved...");
		response.sendRedirect("addaddContact.jsp");

	}
	else {
		session.setAttribute("FailedMsg","Something Went Wrong on Server...");
		response.sendRedirect("addaddContact.jsp");
	}
		
	}

}
