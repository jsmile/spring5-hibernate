<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Student Registration Form</title>
</head>
<body>
	
	<!-- modelattribute is the attribute name of model in the controller -->
	<form:form action="process-form" modelAttribute="student">
		First Name : <form:input path="firstName" />
		<br />
		Last Name : <form:input path="lastName" />
		<br />
		<input type="submit" value="submit" />
	</form:form>
</body>
</html>