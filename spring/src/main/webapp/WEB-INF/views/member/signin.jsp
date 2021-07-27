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
	<label class="form-group">
		<input type="checkbox" name="useCookie" value="true"> 자동 로그인
	</label>
	<button type="submit" id="loginBtn" class="btn btn-outline-success col-12">로그인</button>
	<a href="<%=request.getContextPath()%>/find/pw" class="btn btn-outline">비밀번호 찾기</a>
	<a href="<%=request.getContextPath()%>/find/id" class="btn btn-outline ml-2">아이디 찾기</a>
</form>
<!--  
<script type="text/javascript">
 $(function(){
	 $('#loginBtn').click(function(){
		 var id = $('[name=id]').val();
		 var pw = $('[name=pw]').val();
		 var useCookie = $('[name=useCookie]').is(':checked') ? true : false;
		 var data = {'id' : id, 'pw' : pw, 'useCookie' : useCookie};
		 console.log(data);
		 return;
		 $.ajax({
			 type : 'post',
			 url : '<%=request.getContextPath()%>/member/signin',
			 data : JSON.stringify(data),
		 //dataType : "json", //서버에서 제이슨 형태로 보내주는 경우 사용(클래스의 객체를 보내주는 경우, map을 이용하여 보내주는 경우)
			 contentType : "application/json; charset=utf-8",
			 success : function(result, status, xhr){
					//console.log(result.id);
					//console.log(result['id']);
					if(result != 'success'){
						alert('아이디 또는 비밀번호가 틀렸습니다.')
					}else{
						alert('로그인 성공');
						location.href="<%=request.getContextPath()%>/";
					}
				},
				error : function(xhr,status,e){
					
				}
		 })
	 })
 })
</script>
-->

</body>
</html>
