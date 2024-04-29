<%@page import="com.entity.contact"%>
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
</head>
<body>
	<%@include file="component/navabr.jsp"%>

	<%
	if (user == null) {
		session.setAttribute("invalidMsg", "Login Please...");
		response.sendRedirect("login.jsp");
	}
	%>

	<div class="container-fluid">
		<div class="row p-2">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-success">Add Contact Page</h4>

						<%
						
						String errorMsg = (String) session.getAttribute("FailedMsg");
						if (errorMsg != null) {
						%>
						<p
							class="text-danger text-center"><%=errorMsg%>
						<p />
						<%
						session.removeAttribute("FailedMsg");
						}
						%>


						<form action="update" method="post">
							<%
							int cid = Integer.parseInt(request.getParameter("cid"));
							ContactDao dao = new ContactDao(DbConnect.getConn());
							contact c = dao.getcontactByID(cid);
							%>
							<input type="hidden" value="<%=cid%>" name="cid">

							<div class="form-group">
								<label for="exampleInputEmail1">Enter Name</label> <input
									value="<%=c.getName()%>" name="name" name="name" type="text"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp">

							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									value="<%=c.getEmail()%>" name="email" name="email"
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp">

							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Enter phone No</label> <input
									value="<%=c.getPhno()%>" name="phno" name="phno" type="number"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp">

							</div>
							<div class="form-group">
								<textarea rows="3" cols="" placeholder="Enter About"
									name="about" name="about" class="form=control"><%=c.getAbout()%> </textarea>
							</div>
							<div class="text-center mt-2 ">
								<button type="submit" class="btn btn-success">Update
									Contact</button>
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>






</body>
</html>