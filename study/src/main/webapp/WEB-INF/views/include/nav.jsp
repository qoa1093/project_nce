<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
</head>
<body>
<div>
	<nav class="navbar navbar-expand-sm bg-light navbar-light">
  <ul class="navbar-nav">
  	<a class="navbar-brand" href="<%=request.getContextPath()%>/">
		<p>메인</p>
	</a>
	  <c:if test="${user == null}">
		    <li class="nav-item">
		      <a class="nav-link" href="<%=request.getContextPath()%>/member/signup">회원가입</a>
		    </li>
		    <li class="nav-item">
		      <a class="nav-link" href="<%=request.getContextPath()%>/member/signin">로그인</a>
		    </li>
		    <li class="nav-item">
		      <a class="nav-link disabled" href="#">마이페이지</a>
		    </li>
 	 </c:if>
 	 <c:if test="${user != null && user.authority != 'USER'}">
 			<li class="nav-item">
		      <a class="nav-link" href="<%=request.getContextPath()%>/admin/user/list">회원관리</a>
		    </li>
 	 </c:if>
 	 <c:if test="${user != null}">
		    <li class="nav-item">
		      <a class="nav-link" href="<%=request.getContextPath()%>//">오잉</a>
		    </li>
		    <li class="nav-item">
		      <a class="nav-link" href="<%=request.getContextPath()%>/member/signout">로그아웃</a>
		    </li>
		    <li class="nav-item">
		      <a class="nav-link disabled" href="#">Disabled</a>
		    </li>
 	 </c:if>
  </ul>
</nav>
</div>
</body>
</html>
