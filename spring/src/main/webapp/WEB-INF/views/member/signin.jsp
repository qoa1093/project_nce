<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html> <!--  html파일 표준을 의미 -->
<html>
<head>
</head>
<body>

<form class="container" method="post" action="<%=request.getContextPath()%>/signin">
<!-- 보이면안되서/ 경로중에 중간에 프로젝트 명에 해당하는거 상관없이 동일하게 사인인을 url로 보내줌 -->
	<h1>로그인</h1>
	<div class="form-group">
	  <label>아이디</label>
	  <input type="text" class="form-control" name="id">
	</div>
	<div class="form-group">
	  <label>비밀번호</label>
	  <input type="password" class="form-control" name="pw">
	</div>
	<button class="btn btn-outline-success col-12">로그인</button>
</form>



</body>
</html>
