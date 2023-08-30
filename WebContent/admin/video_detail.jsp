<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${video.title}-Videos</title>
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div class="center">
		<table class="book">
			<tr>
				<td colspan="3" align="left">
					<p id="book-title">${video.title}</p>
					 by <span id="author">${video.url}</span>
				</td>
			</tr>
			<tr>
				
				
			</tr>
			<tr>
				<td id="description">
					${video.description}
				</td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td><h2><a id="reviews">Customer Reviews</a></h2></td>
				<td colspan="2" align="center">
					<button id="buttonWriteReview">Write a Customer Review</button>
				</td>
			</tr>
			
			<tr>
				<td colspan="3" align="left">
					<table class="normal">
						
				
					</table>
				</td>
			</tr>
			
		</table>


	</div>

	<jsp:directive.include file="footer.jsp" />

</body>
</html>