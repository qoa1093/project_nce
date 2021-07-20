<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html>
<head>
<title>메인</title>
</head>
<body>
	<button id= "btn">클릭</button>
	<script type="text/javascript">
		$(function(){
			$('#btn').click(function(){
				//data 유무 여부 
				//data 속성이 없는 경우 : url에 정보를 전달해도 되는 경우
				$.ajax({
					async : true,
					type : 'get',
					url : '<%=request.getContextPath()%>/springtest/123',
					success : function(result, status, xhr){
						console.log(result);
						
					},
					error : function(xhr,status,e){
						console.log('에러발생');
					}
					
				})
				console.log('춥다');
				//data 속성이 있는 경우 : 전달할 정보가 길거나 중요한 경우
				//dataType : 서버에서 전달한 데이터 타입을 지정
				//contentType : 서버로 전달할 데이터 타입을 지정
				//async : 비동기화 하는 경우 true, 동기화 하는 경우 false
				/*
				$.ajax({
				 type : 'post',
				 url : '<%=request.getContextPath()%>/member/signin',
				 data : JSON.stringify(data),
			 	//dataType : "json", //서버에서 제이슨 형태로 보내주는 경우 사용(클래스의 객체를 보내주는 경우, map을 이용하여 보내주는 경우)
				 contentType : "application/json; charset=utf-8",
				 success : function(result, status, xhr){
						
					},
					error : function(xhr,status,e){
						
					}
				})
				*/
		 	})
		})
	</script>
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
