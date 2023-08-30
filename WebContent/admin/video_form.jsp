<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Create New video</title>
	
	<link rel="stylesheet" href="../css/style.css" >
	<link rel="stylesheet" href="../css/jquery-ui.min.css">
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="..//css/richtext.min.css">	
	
	<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
	
	<script type="text/javascript" src="../js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="../js/jquery.richtext.min.js"></script>
</head>
<body>
	
	
	<div align="center">
		<h2 class="pageheading">
			<c:if test="${video != null}">
				Edit video
			</c:if>
			<c:if test="${video == null}">
				Create New video
			</c:if>
		</h2>
	</div>
	
	<div align="center">
		<c:if test="${video != null}">
			<form action="update_video" method="post" id="videoForm">
			<input type="hidden" name="videoId" value="${video.videoId}">
		</c:if>
		<c:if test="${video == null}">
			<form action="create_video" method="post" id="videoForm">
		</c:if>
		
		<table class="form">
			<tr>
				<td>COMEDIAN:</td>
				<td>
					<select name="comedians">
						<c:forEach items="${listComedian}" var="comedian">
							<option value="${comedian.comedianId}">																		
								${comedian.firstName} ${comedians.lastName}
							</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			
			
			<tr>
				<td align="right">Title:</td>
				<td align="left"><input type="text" id="title" name="title" size="20" value="${video.title}" /></td>
			</tr>
			<tr>
				<td align="right">URL:</td>
				<td align="left"><input type="text" id="url" name="url" size="20" value="${video.url}" /></td>
			</tr>			
		
			<tr>
				<td align="right">Tag:</td>
				<td align="left"><input type="text" id="tag" name="tag" size="20" value="${video.tag}" /></td>
			</tr>
			<tr>
				<td align="right">Description:</td>
				<td align="left">
					<textarea rows="1" cols="1" name="description" id="description">${video.description}</textarea>
				</td>
			</tr>										
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">Save</button>&nbsp;&nbsp;&nbsp;
					<button id="buttonCancel">Cancel</button>
				</td>
			</tr>				
		</table>
		</form>
	</div>

	<jsp:directive.include file="footer.jsp" />
</body>
<script type="text/javascript">

	$(document).ready(function() {
		$('#publishDate').datepicker();
		$('#description').richText();
		
		$('#videoImage').change(function() {
			showImageThumbnail(this);
		});
		
		
		$("#videoForm").validate({
			rules: {
				comedians: "required",
				title: "required",
				url: "required",
				tag: "required",
				description: "required",
			},
			
			messages: {
				comedians: "Please select a comedians for the video",
				title: "Please enter title of the video",
				url: "Please enter URL of the video",
				description: "Please enter description of the video"
			}
		});
		
		$("#buttonCancel").click(function() {
			history.go(-1);
		});
	});
</script>
</html>