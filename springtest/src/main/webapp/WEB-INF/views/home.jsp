<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<p>${user}</p>
	<c:if test="${user == null}">
       <a class="dropdown-item" href="<%=request.getContextPath()%>/signin">로그인</a>
       <a class="dropdown-item" href="<%=request.getContextPath()%>/signup">회원가입</a>        
    </c:if>
    <c:if test="${user != null}">
       <a class="dropdown-item" href="<%=request.getContextPath()%>/member/mypage">마이페이지</a>
       <a class="dropdown-item" href="<%=request.getContextPath()%>/board/list">게시판</a>        
       <a class="dropdown-item" href="<%=request.getContextPath()%>/signout">로그아웃</a>
    </c:if>
</body>
</html>
