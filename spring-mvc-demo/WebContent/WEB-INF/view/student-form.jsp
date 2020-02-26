<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<br /><br />
		Last Name : <form:input path="lastName" />
		<br /><br />
		Country : <form:select path="country">
					<form:options items="${student.countryOptions}" />
				  </form:select>
		<br /><br />
				Favorite Language:
		
		<form:radiobutton path="favoriteLanguage" value="Java" /> Java 
		<form:radiobutton path="favoriteLanguage" value="C#" /> C# 
		<form:radiobutton path="favoriteLanguage" value="PHP" /> PHP 
		<form:radiobutton path="favoriteLanguage" value="Ruby" /> Ruby 
		<br /><br />
		
				Operating Systems:
		
		<form:checkbox path="operatingSystems" value="Linux" /> Linux 
		<form:checkbox path="operatingSystems" value="Mac OS" /> Mac OS 
		<form:checkbox path="operatingSystems" value="MS Window" /> MS Windows 
		<br /><br />
		
		<input type="submit" value="제출" />
	</form:form>
</body>
</html>