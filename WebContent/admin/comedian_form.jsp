<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="../css/style.css" >
	<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="../js/jquery.validate.min.js"></script>	
	
<title>
	<c:if test="${comedian != null}">
		Edit Comedian
	</c:if>
	<c:if test="${comedian == null}">
		Create New Comedian
	</c:if>
</title>
</head>
<body>
 
   <div align="center">
      <h2>Create New Comedian</h2>
   </div>
   
   <div align="center">
     <h2>
       <c:if test="${comedian != null }">
           Edit Comedian
       </c:if>
       <c:if test="${comedian == null}">
           Create New Comedian
       </c:if>
     </h2>
   </div>

   <div align="center">   
   <c:if test="${comedian != null}">
			<form action="update_comedian" method="post" id="comedianForm">
			<input type="hidden" name="comedianId" value="${comedian.comedianId}">
		</c:if>
		<c:if test="${comedian == null}">
			<form action="create_comedian" method="post" id="comedianForm">
		</c:if>

    	<table style="with: 50%">
				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstName" value="${comedian.firstName}" required/></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastName"  value="${comedian.lastName}" required /></td>
				</tr>
				
				<tr>
				<td>Birthdate:</td>
				<td><input type="text" id="birthDate" name="birthDate"  value="${comedians.date}" /></td>
			</tr>
				<tr>
					<td>Birth Place</td>
					<td><input type="text" name="birthPlace"  value="${comedian.birthPlace}" required /></td>
				</tr>
				<tr>
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





</html>