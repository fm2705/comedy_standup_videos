<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Choose Users</title>
	
	<link rel="stylesheet" href="../css/style.css" >
	<link rel="stylesheet" href="../css/jquery-ui.min.css">
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="..//css/richtext.min.css">	
	
	<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
	
	<script type="text/javascript" src="../js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="../js/jquery.richtext.min.js"></script>
</head>
<body>

	
	<div align="center">
	  <form action="choose_users_commen_comedian" method="post" id="chooseUsersForm">
		<table class="form">
			<tr>
				<td>Users:</td>
				<td>
					<select name="id1">
						<c:forEach items="${listUsersToChoose}" var="user1">
							<option value="${user1.userId}">																		
								${user1.firstName} ${user1.lastName} 
							</option>
						</c:forEach>
					</select>
				</td>
				<td>
					<select name="id2">
						<c:forEach items="${listUsersToChoose}" var="user2">
							<option value="${user2.userId}">																		
								${user2.firstName} ${ user2.lastName} 
							</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<button type="submit">Submit</button>&nbsp;&nbsp;&nbsp;
					<button id="buttonCancel">Cancel</button>
				</td>
			</tr>				
		</table>
		</form>
	</div>

	<jsp:directive.include file="footer.jsp" />
</body>
<script type="text/javascript">

	$(document).ready(function() {
		$("#buttonCancel").click(function() {
			history.go(-1);
		});
	});
	
</script>
</html>