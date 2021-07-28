<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!Doctype html> <!--  html파일 표준을 의미 -->
<html>
<head>
</head>
<body>

<form class="container" method="post" action="<%=request.getContextPath()%>/member/signin">
	<h1>로그인</h1>
	<div class="form-group">
	  <label>아이디</label>
	  <input type="text" class="form-control" name="id">
	</div>
	<div class="form-group">
	  <label>비밀번호</label>
	  <input type="password" class="form-control" name="pw">
	</div>
	<label class="form-group">
		<input type="checkbox" name="useCookie" value="true"> 자동 로그인
	</label>
	<button type="submit" id="loginBtn" class="btn btn-outline-success col-12">로그인</button>
	<a href="<%=request.getContextPath()%>/find/pw" class="btn btn-outline">비밀번호 찾기</a>
	<a href="<%=request.getContextPath()%>/find/id" class="btn btn-outline ml-2">아이디 찾기</a>
</form>

</body>
</html>
