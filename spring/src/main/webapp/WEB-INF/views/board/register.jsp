<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html> <!--  html파일 표준을 의미 -->
<html>
<head>
</head>
<body>
  <form class="container" method="post" action="<%=request.getContextPath()%>/board/register">
	<h2>게시글 등록</h2>
	<div class="form-group">
	  <label>제목</label>
	  <input type="text" class="form-control" name="title">
	</div>
	<!-- <div class="form-group">
	  <label>작성자</label>
	  <input type="text" class="form-control" name="writer" value="${user.id}" readonly>
	</div>-->
	<div class="form-group">
	  <label>내용</label>
	  <textarea type="text" class="form-control" rows="10" name="contents">${board.contents}</textarea>
	</div>
	<button type="submit" class="btn btn-outline-success">등록</button>	 
  </form>
</body>
</html>
