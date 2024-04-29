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

@WebServlet("/update")
public class EditContact extends HttpServlet {
	
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cid=Integer.parseInt(request.getParameter("cid"));
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phno=request.getParameter("phno");
		String about=request.getParameter("about");
		
		contact c=new contact();
		c.setId(cid);
		c.setName(name);
		c.setEmail(email);
		c.setPhno(phno);
		c.setAbout(about);
		ContactDao dao=new ContactDao(DbConnect.getConn());
		HttpSession session=request.getSession();
		boolean f=dao.updatecontact(c);
		if(f) {
			session.setAttribute("succMsg","Your Contact is Updated...");
			response.sendRedirect("viewContact.jsp");

		}
		else {
			session.setAttribute("FailedMsg","Something Went Wrong on Server...");
			response.sendRedirect("editcontact.jsp?cid="+cid);
		}
		
		
	}

}
