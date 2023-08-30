<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>list_cool_comedians</title>
<link rel="stylesheet" href="../css/style.css" >
</head>
<body>

   <div align="center"><h2>Top Comedians</h2></div>
   <div align="center" >
      <table border="1" cellpadding="5"> 
        <tr>
           <th>Index</th>
           <th>First Name</th>
           <th>Last Name</th>
        </tr>
        
        <c:forEach var="topComedian" items="${listTopComedians}" varStatus="status">
        <tr>
          <td>${status.index + 1 }</td>
          <td>${topComedian.firstName}</td>
          <td>${topComedian.lastName}</td>
        </tr>
       </c:forEach>
      </table> 
   
   
   </div>
   
   <div align="center">
     
   </div>
   <jsp:directive.include file="footer.jsp" />
   <script>
		$(document).ready(function() {
			$(".deleteLink").each(function() {
				$(this).on("click", function() {
					userId = $(this).attr("id");
					if (confirm('Are you sure you want to delete the user with ID ' +  userId + '?')) {
						window.location = 'delete_user?id=' + userId;
					}					
				});
			});
		});
	</script>

</body>
</html>