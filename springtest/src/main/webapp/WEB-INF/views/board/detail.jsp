<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>게시판</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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
		<div class="form-group">
		  <label>댓글</label>
		  <div class="reply-list">
		  <!-- 이 안에다가 앞으로 이 화면에 달릴 댓글들 리스트를 불러와서 보여줄 것임 -->
		  </div>
		  <div class="reply-insert">
		  <!-- 이 안에 있는 목록들은 디비로 보내서 댓글 목록에 추가될 것임 -->
		  <textarea id="reply" class="form-control" name="contents" placeholder="댓글내용을 입력하세요."></textarea>
		  <button class="reply-btn btn btn-outline-success">등록</button>
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
	/*
	$(function(){
		$('.reply-btn').click(function(){
			$.ajax({
				 type : 'post',
				 url : '<%=request.getContextPath()%>/board/reply/',
				 dataType : ReplyVO, 
				 success : function(result, status, xhr){
						console.log(result); 
						//
					},
					error : function(xhr,status,e){
						
					}
			 })
		})//이부분 내일 다시 수정할 것 데이터 타입~ 이거 뭐였는지 기억안남 아직 디테일 부분만 건드렸음
	})*/
	</script>	
</body>
</html>