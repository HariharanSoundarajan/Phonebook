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

@WebServlet("/delete")
public class DeleteContact extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cid=Integer.parseInt(request.getParameter("cid"));
		
		ContactDao dao=new ContactDao(DbConnect.getConn());
		
		boolean f=dao.deleteContactByID(cid);
		HttpSession session=request.getSession();
		if(f)
		{
			session.setAttribute("succMsg", "contact Delete Successfully...");
			response.sendRedirect("viewContact.jsp");
		}
		else
		{
			session.setAttribute("FailedMsg", "Something Went on Wrong On server...");
			response.sendRedirect("viewContact.jsp");
		}
	}

}
