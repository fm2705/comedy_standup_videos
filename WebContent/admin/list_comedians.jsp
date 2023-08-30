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
<jsp:directive.include file="header.jsp" />
   <div align="center">
      <h2>Comedians Management</h2>
     <h3> <a href="comedian_form.jsp">Create New comedian</a></h3>
   </div>
   
   <c:if test="${message != null }">
      <div align="center">
         <h4><i>${message}</i></h4>
      </div>
   </c:if>
   
   <div align="center" >
      <table border="1" cellpadding="5"> 
        <tr>
           <th>Index</th>
           <th>Id</th>
           <th>First Name</th>
           <th>Last Name</th>
           <th>Birthday</th>
           <th>Birthplace</th>
           <th>Actions</th>
        </tr>
        
        <c:forEach var="comedian" items="${listComedians}" varStatus="status">
        <tr>
          <td>${status.index + 1 }</td>
          <td>${comedian.comedianId}</td>
          <td>${comedian.firstName}</td>
          <td>${comedian.lastName}</td>
          <td>${comedian.birthDay}</td>
          <td>${comedian.birthPlace}</td>
          <td>
             <a href="edit_comedian?id=${comedian.comedianId}">Edit</a> &nbsp;
             <a href="">Delete</a> &nbsp;
        </tr>
       </c:forEach>
      </table> 
   
   
   </div>
   
   <div align="center">
     
   </div>
<jsp:directive.include file="footer.jsp" />
</body>
</html>