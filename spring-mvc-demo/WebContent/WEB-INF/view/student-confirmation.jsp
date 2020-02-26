<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Student Registration Form</title>
</head>
<body>
	
	<!-- modelattribute is the attribute name of model in the controller -->
		First Name : ${student.firstName}
		<br />
		Last Name : ${student.lastName}
		<br><br>
		
		Country: ${student.country}
		<br><br>
		
		Favorite Language: ${student.favoriteLanguage}
		<br><br>
		
		Operating Systems:
		<ul>
			<c:forEach var="temp" items="${student.operatingSystems}">
				<li> ${temp} </li>
			</c:forEach>
		</ul>		

</body>
</html>