<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html>
<head>
<title>메인</title>
</head>
<body>
	<div class="container">
		<div class="form-group">
			<input type="text" class="form-control mt-2" placeholder="회원가입시 등록한 이메일주소를 입력하세요." name="email">	
		</div>
		<button type="button" id="findIdBtn" class="btn btn-outline-success">아이디 찾기</button>
	</div>
		<script type="text/javascript">
			$(function(){
				$(document).on('click','#findIdBtn',function(){
					var email = $('[name=email]').val();
					$.ajax({
						type : 'post',						
						url : '<%=request.getContextPath()%>/find/id/',
						data : {email : email},
						success : function(res){
							//console.log(res);
							alert('가입된 아이디를 메일로 전송했습니다.');
						}
					})
				})
			})
		</script>
</body>
</html>
