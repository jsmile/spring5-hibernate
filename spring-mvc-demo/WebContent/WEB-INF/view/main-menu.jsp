<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC Home Page</title>

<%-- 
	${pageContext.request.contextPath} : 
	to access the correct root directory for your web application 
--%>

	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/my-hello-world.css" type="text/css" />
	<script src="${pageContext.request.contextPath}/resources/js/my-hello-world.js"></script>
</head>
<body>
	<h2>Spring MVC Demo - Home Page</h2>
	<hr />
	<a href="silly/show-form">Hello World Form</a>
	<br />
	<a href="student/show-form">Student Form</a>
	<br />
	<input type="button" onclick="doSomeWork();" value="Click me" />
</body>
</html>