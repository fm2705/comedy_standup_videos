<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<body>

	<div align="left" class="btn-group">
	<a href="list_cool_comedians"><button>1. Who is Cool</button></a>
	<a href="list_new_comedians"><button>2. Who is New</button></a>
	<a href="list_hot_comedians"><button>3. Who is Hot</button></a>
	<a href="list_top_comedians"><button>4. Who is Top</button> </a>
	<a href="comedian_form.jsp"><button>Popular Tags</button> </a>
	<a href="common_favorite_comedian"><button>6. Common favorite comedian</button> </a>
	<a href="list_most_productive_users"><button>7. Most productive users</button> </a>
	<a href="list_positive_reviewers"> <button>8. Positive reviewers</button></a>
	<a href="list_poor_youtubes"><button>9. Poor YouTubes</button></a>
	<a href="comedian_form.jsp"><button>Twin users</button></a>
	 
			
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
</html>