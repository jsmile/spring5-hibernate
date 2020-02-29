<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Form</title>
</head>
<body>

	<style>
		.error { color: red; font-size: 0.7rem; }
	</style>
	<form:form action="process-form" modelAttribute="customer">
		<div>First Name : <form:input path="firstName" /> </div>
		<br /> <br />
		<div>*Last Name : <form:input path="lastName" /> 
						<form:errors path="lastName" cssClass="error" /> 
		</div>
		<br /><br />
		<div>
			*Free passes : <form:input path="freePasses" />
			<form:errors path="freePasses" cssClass="error" />
		</div>
		 		
		<br /><br />
		<div>
			Postal Code : <form:input path="postalCode" />
			<form:errors path="postalCode" cssClass="error" />
		</div> 		

		<br /><br />
		<div>
			Course Code : <form:input path="courseCode" />
			<form:errors path="courseCode" cssClass="error" />
		</div> 		
		<input type="submit" value="제출" />
	</form:form>

</body>
</html>