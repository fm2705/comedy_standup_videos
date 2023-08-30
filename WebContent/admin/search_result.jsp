<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style>
* {
	box-sizing: border-box;
}

/* Create two unequal columns that floats next to each other */
.column {
	float: left;
	padding: 10px;
	height: 300px; /* Should be removed. Only for demonstration */
}

.left {
	width: 25%;
}

.right {
	width: 75%;
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}
</style>


<title>Results for ${keyword} - Online Video comedy</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>Videos</th>
				<th>Add</th>
			</tr>

			<c:forEach var="video" items="${result}" varStatus="status">
				<tr>
					<td>${status.index + 1 }</td>
					<td>
						<div>
							<div>
								<iframe src="${video.url}" width="560" height="315"
									frameborder="0" allowfullscreen> </iframe>
							</div>
						</div>
					</td>

				</tr>
			</c:forEach>

			</table>
	</div>
	</div>
			
			</tr>
		</table>

	<jsp:directive.include file="footer.jsp" />
</body>
</html>