<%@page import="com.entity.contact"%>
<%@page import="java.util.List"%>
<%@page import="com.conn.DbConnect"%>
<%@page import="com.dao.ContactDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WebContact</title>
<%@include file="component/allCss.jsp"%>
<style type="text/css">
.crd-ho:hover {
	background-color: #f7f7f7;
}
</style>
</head>
<body>
	<%@include file="component/navabr.jsp"%>

	<%
	if (user == null) {
		session.setAttribute("invalidMsg", "Login Please...");
		response.sendRedirect("login.jsp");
	}
	%>
	<%
	String succMsg = (String) session.getAttribute("succMsg");
	String errorMsg = (String) session.getAttribute("FailedMsg");
	
	if (succMsg != null) {
	%>
	<div class="alert alert-success" role="alert"><%=succMsg%></div>
	<%
	session.removeAttribute("succMsg");
	}
	if (errorMsg != null) {
		%>
		<p
			class="text-danger text-center"><%=errorMsg%>
		<p />
		<%
		session.removeAttribute("FailedMsg");
		}
		%>
	


	<div class="container">
		<div class="row p-4">


			<%
			if (user != null) {
				ContactDao dao = new ContactDao(DbConnect.getConn());
				List<contact> contact = dao.getAllContact(user.getId());

				for (contact c : contact) {
			%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body">
						<h5>
							Name:<%=c.getName()%></h5>
						<p>
							ph:no:<%=c.getPhno()%></p>
						<p>
							Email:<%=c.getEmail()%></p>
						<p>
							About:<%=c.getAbout()%></p>
						<div class="text-center">
							<a href="editcontact.jsp?cid=<%=c.getId()%>"
								class="btn btn-success btn-sm text-white">Edit</a> 
								<a href="delete?cid=<%=c.getId()%>"
								 class="btn btn-danger btn-sm text-white">Delete</a>


						</div>
					</div>
				</div>
			</div>
			<%
			}
			}
			%>
		</div>
	</div>



</body>
</html>