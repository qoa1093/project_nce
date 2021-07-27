<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html>
<head>
<title>메인</title>
</head>
<body>
	<form class="container" method="post">
		<div class="form-group">
			<input type="text" class="form-control" placeholder="제목" name="title">	
		</div>
		<div class="form-group">
			<input type="text" class="form-control" placeholder="받는사람" name="email">	
		</div>
		<div class="form-group">
			<textarea class="form-control" placeholder="내용" name="content"></textarea>	
		</div>
		<button class="btn btn-outline-success">전송</button>
	</form>
</body>
</html>
