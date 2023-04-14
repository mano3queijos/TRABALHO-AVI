<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:forEach begin="0" end="10" varStatus="loop"
		items="${nomeCursos}" var="nomeCursos">
		<p>${nomeCursos}</p>
	</c:forEach>

</body>
</html>