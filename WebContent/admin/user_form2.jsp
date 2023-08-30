<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New User</title>
<link rel="stylesheet" href="../css/style.css" >
</head>
<body>

     
	
	<div align="center">
		<c:if test="${user != null}">
			<form action="update_user" method="post" id="userForm">
			<input type="hidden" name="userId" value="${user.userId}">
		</c:if>
		<c:if test="${user == null}">
			<form action="create_user" method="post" id="userForm">
		</c:if>
   
   <div align="center">
   <form action="create_user" method="post" onsubmit="return validateFormInput()" >
    	<table style="with: 50%">
				<tr>
					<td>First Name</td>
					<td><input type="text" name="first_name" value="${user.firstName}"/></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="last_name" value="${user.lastName}" /></td>
				</tr>
				<tr>
					<td>UserName</td>
					<td><input type="text" id="email" name="email" placeholder="email" value="${user.email}"/></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" placeholder="Password" id="password"  value="${user.password}"/></td>
				</tr>
				<tr>
					<td>Confirm Password</td>
					<td><input type="password" name="pass2" placeholder="Confirm Password" id="confirm_password" value="${user.password}"/></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><input type="text" name="gender" value="${user.gender}"/></td>
				</tr>
				<tr>
					<td>Age</td>
					<td><input type="text" name="age" value="${user.age}"/></td>
				</tr>
				<tr><td>&nbsp; </td></tr>
				<tr>
				  <td colspan="2" align="center">
				     <input type="submit" value="Submit" />
                      <input type="button" value="Cancel" onclick="javascript:history.go(-1)" />
                   </td>
				</tr>
				
				
				</table>
   </form>
   </div>
<jsp:directive.include file="footer.jsp" />
</body>


<script type="text/javascript">
   function validateFormInput(){
	    var password1=document.getElementById("password");
    	var password2=document.getElementById("confirm_password");
	   var fieldEmail = document.getElementById("email");
	   if(fieldEmail.value.length == 0){
		   alert("Email is required");
		   fieldEmail.focus();
		   return false;
	   }
	   
	   if(password1.value != password2.value){
		   alert("Password doesn't match");
		   password1.focus();
		   return false;
	   }
	  
   }
</script>


</html>