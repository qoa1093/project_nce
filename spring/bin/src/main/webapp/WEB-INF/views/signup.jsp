<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html> 
<html>
<head>
	<title>회원가입</title>
	<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<form class="container" method="post" action="<%=request.getContextPath()%>/signup">
<!-- 보이면안되서/ 경로중에 중간에 프로젝트 명에 해당하는거 상관없이 동일하게 사인인을 url로 보내줌 -->
	<h1>회원가입</h1>
	<div class="form-group">
	  <label>아이디</label>
	  <input type="text" class="form-control" name="id">
	</div>
	<div class="form-group">
	  <label>비밀번호</label>
	  <input type="password" class="form-control" name="pw">
	</div>
	<div class="form-group">
	  <label>비밀번호확인</label>
	  <input type="password" class="form-control" name="pw2">
	</div>
	<div class="form-group">
	  <label>이름</label>
	  <input type="text" class="form-control" name="name">
	</div>
	<div class="form-group">
	  <label>이메일</label>
	  <input type="text" class="form-control" name="email">
	</div>
	<div class="form-group">
	  <label>성별</label>
	  <select class="form-control" name="gender">
	  	<option value="M">남성</option>
	  	<option value="F">여성</option>
	  </select>
	</div>
	
	<button class="btn btn-outline-success col-12">회원가입</button>
</form>



</body>
</html>
