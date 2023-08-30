<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Manage Comedians - Website Administration</title>
<link rel="stylesheet" href="../css/style.css" >
</head>
<body>
<div class="center">
	<div  class="center">
		<a href="${pageContext.request.contextPath}/">
				<img src="../images/youtube.png" /><br/></a>
	</div>
	
	<div>
		<form action="search" method="get">
			<input type="text" name="keyword" size="50" />
			<input type="submit" value="Search" />		
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			
			<c:if test="${loggedCustomer == null}">
				<a href="login" >Sign In</a> |
				<a href="register" >Register</a> |			
			</c:if>
			
			<c:if test="${loggedCustomer != null}">
				<a href="admin">Welcome, ${loggedCustomer.fullname}</a> |
				<a href="logout">Logout</a> |
			</c:if>
			

		</form>
	</div>
	

	
</div>

</body>
	<jsp:directive.include file="listPart3.jsp" />
</html>