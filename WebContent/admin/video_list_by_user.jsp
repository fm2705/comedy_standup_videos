<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Videos</title>
<link rel="stylesheet" href="../css/style.css">
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>


	<c:if test="${message != null}">
		<div align="center">
			<h4 class="message">${message}</h4>
		</div>
	</c:if>

	<div align="center">
		<table border="1" cellpadding="5">

			<tr>
				<th>Index</th>
				<th>Videos</th>
                <th>Add</th>
			</tr>


			<c:forEach var="video" items="${listVideosByUser}" varStatus="status">
				<tr>
					<td>${status.index + 1 }</td>
					<td>
						<div>
								<iframe src="${video.url}" width="560" height="315"
									frameborder="0" allowfullscreen> </iframe>
						</div>
					</td>
					<td><button id="buttonAddToFavorite">Add Review</button>&nbsp</td>
			</c:forEach>
							</tr>
		</table>
	</div>


	<jsp:directive.include file="footer.jsp" />


</body>
</html>