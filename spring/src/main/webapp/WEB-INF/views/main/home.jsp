<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html>
<head>
	<title>메인</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <!-- Brand -->
	  <a class="navbar-brand" href="#">Logo</a>
	
	  <!-- Links -->
	  <ul class="navbar-nav">
	    <li class="nav-item">
	      <a class="nav-link" href="<%=request.getContextPath()%>/board/list">게시글</a>
	    </li>
	
	    <!-- Dropdown -->
	    <li class="nav-item dropdown">
	      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
	        회원
	      </a>
	      <div class="dropdown-menu">
	      <c:if test="${user == null}">
	        <a class="dropdown-item" href="<%=request.getContextPath()%>/signin">로그인</a>
	        <a class="dropdown-item" href="<%=request.getContextPath()%>/signup">회원가입</a>        
	      </c:if>
	      <c:if test="${user != null}">
	        <a class="dropdown-item" href="<%=request.getContextPath()%>/member/mypage">마이페이지</a>        
	        <a class="dropdown-item" href="<%=request.getContextPath()%>/signout">로그아웃</a>
	      </c:if>  
	      </div>
	    </li>
	  </ul>
	</nav>
<!--  <h1>
	서버에서 보낸 데이터 : ${name} 
</h1>
<hr>
<a href="/spring/signin?id=abc123&pw=abc123">서버로 보낼 데이터 아이디 : abc123, 비밀번호 : abc123</a>
<hr>
<form action = "/spring/signin">
id: <input type="text" name="id"> <br>
pw: <input type="password" name="pw"> <br>
취미: <input type="text" name="hobby"> <br>
취미:  <input type="text" name="hobby"> <br>
<button>전송</button>
</form>-->
</body>
</html>
