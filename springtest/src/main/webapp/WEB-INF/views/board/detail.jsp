<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>게시판</title>
	<style type="text/css">
		.recommend-btn{
			font-size : 30px;
		}
		.fa-thumbs-down{
			transform :rotateY(180deg);
		}
	</style>
</head>
<body>
	<div class="container">
		<h1>게시판</h1>
		<div class="form-group">
			<label>제목</label>
			<input type="text" class="form-control" name="title" value="<c:out value="${board.title}"/>" readonly>
		</div>
		<div class="form-group">
			<label>작성자</label>
			<input type="text" class="form-control" name="writer" value="${board.writer}" readonly>
		</div>
		<div class="form-group">
			<label>작성일</label>
			<input type="text" class="form-control" name="registered" value="${board.dateTime}" readonly>
		</div>
		<div class="form-group">
			<label>조회수</label>
			<input type="text" class="form-control" name="views" value="${board.views}" readonly>
		</div>
		
		<div class="form-group">
			<a href="#" class="recommend-btn up">
				<c:choose>
					<c:when test="${recommend != null && recommend.state == 1}">
						<i class="fas fa-thumbs-up"></i>
					</c:when>
					<c:otherwise>
						<i class="far fa-thumbs-up"></i>
					</c:otherwise>
				</c:choose>
			</a>
			<a href="#" class="recommend-btn down">
				<c:choose>
					<c:when test="${recommend != null && recommend.state == -1}">
						<i class="fas fa-thumbs-down"></i>
					</c:when>
					<c:otherwise>
						<i class="far fa-thumbs-down"></i>
					</c:otherwise>
				</c:choose>
			</a>
		</div>
		<div class="form-group">
			<label>내용</label>
			<div class="form-control" style="min-height:400px;">${board.contents}</div>
		</div>
		<div class="form-group">
			<label>첨부파일</label>
			<c:forEach items="${fileList }" var="file">
				<a class="form-control" href="<%=request.getContextPath()%>/board/download?fileName=${file.name}">${file.ori_name }</a>
			</c:forEach>
		</div>
		<div class="reply form-group">
		  <label>댓글</label>
		  <div class="contents">
		  	<div class="reply-list">
		  	<!-- 이 안에다가 앞으로 이 화면에 달릴 댓글들 리스트를 불러와서 보여줄 것임 -->
		  	</div>
		  	<ul class="pagination justify-content-center"></ul>
			  <div class="reply-box form-group">
		  		<!-- 이 안에 있는 목록들은 디비로 보내서 댓글 목록에 추가될 것임 -->
		  		  <textarea class="reply-input form-control mb-2" placeholder="댓글내용을 입력하세요."></textarea>		  		  
				  <button type="button" class="reply-btn btn btn-outline-success">등록</button>
			  </div>
		  </div>
		</div>
		<div class="input-group">
			<a href="<%=request.getContextPath()%>/board/list" class="mr-2"><button class="btn btn-outline-danger">목록</button></a>
			<c:if test="${board != null && user.id eq board.writer }">
				<a href="<%=request.getContextPath()%>/board/modify?num=${board.num}" class="mr-2"><button class="btn btn-outline-danger">수정</button></a>
				<form action="<%=request.getContextPath()%>/board/delete" method="post" class="mr-2">
					<input type="hidden" value="${board.num }" name="num">
					<button class="btn btn-outline-danger">삭제</button>
				</form>
			</c:if>
		</div>
	</div>
	<script type="text/javascript">
	$(function(){
		var msg = '${msg}';
		printMsg(msg);
		history.replaceState({},null,null);
	})
	function printMsg(msg){
		if(msg == '' || history.state){
			return ;
		}
		alert(msg);
	}
	$(function(){
		$('.recommend-btn').click(function(e){
			e.preventDefault();
			var board = ${board.num};
			var state = $(this).hasClass('up')? 1 : -1;
			$.ajax({
				 type : 'get',
				 url : '<%=request.getContextPath()%>/board/recommend/'+ board + '/' + state,				 
				 success : function(result, status, xhr){
						console.log(result); //여기 리절트는 그냥 내가 쓰고싶은 이름으로 : 서버에서 보내준 데이터 받아서 그냥 내가 지정한 이름으로 받는것임
						$('.recommend-btn i').removeClass('fas').addClass('far');
						if(result == 'UP'){
							alert('해당 게시글을 추천했습니다.');
							$('.recommend-btn.up i').addClass('fas');
						}else if(result == 'DOWN'){
							alert('해당 게시글을 비추천했습니다.');
							$('.recommend-btn.down i').addClass('fas');
						}else if(result == 'GUEST'){
							alert('추천/비추천을 하려면 로그인 하세요.');
						}else if(result == 'CANCEL'){
							if(state == 1){
								alert('추천을 취소했습니다.');
							}else{
								alert('비추천을 취소했습니다.');
							}
						}
					},
					error : function(xhr,status,e){
						console.log('에러발생');
					}
			 })
		})
	})
	
	$(function(){
		$('.reply-btn').click(function(){
			var rp_bd_num = '${board.num}'; // 따옴표 붙이는경우 잘못된 게시글 갔을때 에러나지 않도록 = ; 형태가 됨 -> 문법에러 -> 게시글번호가 없어도 빈 문자열(원하는결과아니어도 자바스크립에선 에러 ㄴㄴ)
			var rp_content = $('.reply-input').val();
			var rp_me_id = '${user.id}';
			//console.log('게시글번호 :' + rp_bd_num);
			//console.log('댓글내용 :' + rp_content);
			//console.log('댓글아이디 :' + rp_me_id);
			var data = {
					rp_bd_num/*속성명*/ : rp_bd_num,/*변수명*/
					rp_content : rp_content,
					rp_me_id : rp_me_id
					};
			//console.log(data); //js에서는 아래 코드가 안먹힘 (jsp) 그래서 따로 만들어줌
			var contextPath = '<%=request.getContextPath()%>'; 
			$.ajax({
				 type : 'post',
				 url : contextPath + '/reply/ins', //404에러 : 이 경로를 처리하는 곳이 없어서
				 data : JSON.stringify(data),
				 contentType : "application/json; charset=utf-8",
				 success : function(result){ // 하나만 넣어도 괜찮음(다른두개를 못씀)
						console.log(result); 
						//
					},
					error : function(xhr,status,e){
						
					}
			 })
		})
	})
	</script>	
</body>
</html>