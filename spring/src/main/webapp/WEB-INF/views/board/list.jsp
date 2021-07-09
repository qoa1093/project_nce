<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html> <!--  html파일 표준을 의미 -->
<html>
<head>
	<title>로그인</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<!-- items에는 서버에서 보낸 리스트를 연결하고, var에는 리스트에서 하나 꺼낸 객체에 이름을 지정 -->
<!--  vo를 이용하여 멤버변수명을 쓰면 해당 멤버변수를 부르는 것이 아니라(멤버변수가 프라이빗이라서) 해당 멤버변수의 getter를 부름 -->
<!-- @taglib부분이 있어야 가능함 c로 시작하는 라이브러리 사용하게 함 
<c:forEach items="${list}" var="board"> 
	${board.num} : ${board.title} : ${board.views} : ${board.writer} : ${board.registered } <br>
</c:forEach>-->
  <div class="container">
	 <h2>게시판</h2>
	 <form class="input-group float-right mb-3">
	  	<select class="form-control mr-2">
	  		<option>전체</option>
	  		<option>제목+내용</option>
	  		<option>작성자</option>
	  	</select>
	  	<input type="text" class="form-control">
	  	<button class="btn btn-outline-primary">검색</button>
	 </form>
	 <c:if test="${list.size() != 0}">
	  <table class="table table-bordered">
	    <thead>
	      <tr>
	        <th>번호</th>
	        <th>제목</th>
	        <th>작성자</th>
	        <th>조회수</th>
	        <th>등록일</th>
	      </tr>
	    </thead>
	    <tbody>
	      <c:forEach items="${list}" var="board">
	      	<tr> 
	          <td>${board.num}</td>
	          <td><a href="<%=request.getContextPath()%>/board/detail?num=${board.num}">${board.title}</a></td>
	          <td>${board.writer}</td>
	          <td>${board.views}</td>
	          <td>${board.registeredDate}</td>
	      	 </tr>
	      </c:forEach>
	    </tbody>
	  </table>
	  <ul class="pagination justify-content-center">
	  	<c:if test="${pm.prev}">
		    <li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.startPage-1}">이전</a></li>
	  	</c:if>
	  	<c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="index">
	    	<li class="page-item <c:if test="${pm.criteria.page == index}">active</c:if>"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${index}">${index}</a></li>
	    </c:forEach>
	    
	    <c:if test="${pm.next}">
	    	<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.endPage+1}">다음</a></li>
	    </c:if>
	  </ul>
	</c:if>
	<c:if test="${list.size() == 0}">
		<h3>게시글이 없습니다.</h3>
	</c:if>
	<a href="<%=request.getContextPath()%>/board/register"><button class="btn btn-outline-success">글쓰기</button></a>
  </div>
</body>
</html>
