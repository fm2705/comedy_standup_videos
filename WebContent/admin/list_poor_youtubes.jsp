<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>list_cool_comedians</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>

	<div align="center">
		<h2>Positive Reviewers</h2>
	</div>


	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>Videos</th>
			</tr>

			<c:forEach var="poorYouTube" items="${listPoorYouTube}" varStatus="status">
				<tr>
					<td>${status.index + 1 }</td>
					<td>
						<div>
							<div>
								<iframe src="${poorYouTube.url}" width="560" height="315"
									frameborder="0" allowfullscreen> </iframe>
							</div>
						</div>
					</td>
				</tr>
			</c:forEach>




		</table>


	</div>

	<div align="center"></div>
	<jsp:directive.include file="footer.jsp" />

</body>
</html>