<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
</head>
<body>
<c:if test="${user != null}">
	<h1>
		${user.id} 님의 방문을 환영합니다.
	</h1>
</c:if>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
