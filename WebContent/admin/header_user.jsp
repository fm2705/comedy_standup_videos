<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../css/style.css" >
<div align="center">
	<div>
		<a href="${pageContext.request.contextPath}/admin/">
			
		</a>
	</div>
	<div>
		Welcome, <c:out value="${sessionScope.useremail}" /> |  <a href="logout">logout</a>
		<br/><br/>
	</div>
	<div id="headermenu">
		<div>
			<a href="list_comedians">
				<img src="../images/funny-mask.png" /><br/>Comedians
			</a>
		</div>
		<div>
			<a href="list_videos">
				<img src="../images/youtube.png" /><br/>Videos
			</a>
		</div>


			<a href="list_favorites"><img src="../images/communications.png" /><br/>
				Favorites
			</a>
			
		</div>
		
	</div>
	<div>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  <form action="search" method="get">
			<input type="text" name="keyword" size="50" />
			<input type="submit" value="Search" />		
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	
	</div>
	
</div>