<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Choose Users</title>

<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="../css/jquery-ui.min.css">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="..//css/richtext.min.css">

<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>

<script type="text/javascript" src="../js/jquery-ui.min.js"></script>
<script type="text/javascript" src="../js/jquery.richtext.min.js"></script>
</head>
<body>


	<section align="center">



	<div >
		<form action="submit_this_review" method="post" id="reviewForm">
			<table class="form">
				<tr>

					<td>
						<div id=${showVideo.videoId}>
							<iframe src="${showVideo.url}" width="560" height="315"
								frameborder="0" allowfullscreen> </iframe>
						</div>
					</td>
				</tr>

				<tr>
					<td>
						<div>
							<label>Choose a Score:</label> <select name="score">
								<option value="Excellent">Excellent</option>
								<option value="Good">Good</option>
								<option value="Poor">Poor</option>
								<option value="Fair">Fair</option>
							</select>
						</div>
					</td>
				</tr>

				<tr>
					<input type="hidden" id="video" name="video"
						value="${showVideo.videoId}">
				</tr>

				<tr>
					<input type="hidden" id="user" name="user"
						value="${showVideo.users.userId}">
				</tr>

				<tr>
					<td>
						<div>
							<textarea rows="10" cols="50" name="description" id="description">${video.description}</textarea>
						</div>
					</td>
				</tr>

				<tr>
					<td colspan="2" align="center"><a><button type="submit">Submit</button></a>
						&nbsp;&nbsp;&nbsp;</td>
				</tr>
			</table>
		</form>
	</div>
	</section>
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