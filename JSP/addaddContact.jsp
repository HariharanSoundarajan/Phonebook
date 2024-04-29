<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WebContact</title>
<%@include file="component/allCss.jsp"%>
</head>
<body style="background-colour: #f7faf8;">
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
					String sucssMsg=(String)session.getAttribute("succMsg"); 
					String errorMsg=(String)session.getAttribute("FailedMsg");
					
					if(sucssMsg!=null){
						%>  
						<p class="text-success text-center"><%=sucssMsg%><p/>        
					<% 	
					session.removeAttribute("succMsg");
					}
					if(errorMsg!=null){
					%>  
					<p>class="text-danger text-center"><%=sucssMsg%><p/>        
				    <%
				    session.removeAttribute("FailedMsg");
					}
					%>
						
						
						<form action="addContact" method="post">
							<%
							if (user != null) {
							%>
							<input type="hidden" value="<%=user.getId()%>" name="userid">
							<%
							}
							%>


							<div class="form-group">
								<label for="exampleInputEmail1">Enter Name</label> <input name="name"
									name="name" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp">

							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input name="email"
									name="email" type="email" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp">

							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Enter phone No</label> <input name="phno"
									name="phno" type="number" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp">

							</div>
							<div class="form-group">
								<textarea rows="3" cols="" placeholder="Enter About" name="about"
									name="about" class="form=control"></textarea>
							</div>
							<div class="text-center mt-2 ">
								<button type="submit" class="btn btn-success">Save
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