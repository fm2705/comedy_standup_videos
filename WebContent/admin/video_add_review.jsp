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
	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<h2 class="pageheading">REVIEW VIDEO
	</div>

	<c:if test="${message != null}">
		<div align="center">
			<h4 class="message">${message}</h4>
		</div>
	</c:if>

	<form action="submit_review" method="post" id="addreview">

		<table class="form" border="1" cellpadding="5">

			<tr>
				<th>Index</th>
				<th>Videos</th>
			</tr>



			<tr>
				<td>${status.index + 1 }</td>
				<td>
					<div name="thisvideo">
						<iframe src="${showVideo.url}" width="560" height="315"
							frameborder="0" allowfullscreen> </iframe>
					</div>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>

			<tr>
				<div>
					<label>Choose a Score:</label> <select name="score">
						<option value="Excellent">Excellent</option>
						<option value="Good">Good</option>
						<option value="Poor">Poor</option>
						<option value="Fair">Fair</option>
					</select>
				</div>
			</tr>

			<tr>
				<div>
					<textarea rows="10" cols="50" name="description" id="description">${video.description}</textarea>
				</div>
			</tr>

			<tr>
				<button type="submit">Submit</button>
			</tr>

		</table>

	</form>


</body>

</html>