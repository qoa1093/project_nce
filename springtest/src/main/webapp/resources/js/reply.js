/**
 * 함수안에 있으면 전역 x 코드 밖에 있으면 전역함수(어디에서든 사용가능)
 */
var replyService = (function(){
	
	function insert(contextPath, data){
		// ajax코드 넣어주기
		//console.log('댓글 등록');
		$.ajax({
			type : 'post',
			url : contextPath + '/reply/ins', //404에러 : 이 경로를 처리하는 곳이 없어서
			data : JSON.stringify(data),
			contentType : "application/json; charset=utf-8",
			success : function(result){ // 하나만 넣어도 괜찮음(다른두개를 못씀)
				console.log(result); 
				if(result == 'OK'){
					replyList(contextPath, data['rp_bd_num'],1);
					$('.reply-input').val('');
					alert('댓글이 등록되었습니다.');		
				}
			}
					
		})
	}
	function replyList(contextPath, rp_bd_num, page){
		$.ajax({
			type : 'get',
			dataType : "json",
			url : contextPath + '/reply/list/'+ rp_bd_num +'/'+ page,
			success : function(result){ 
				//1.console.log(result['replylist']);
				//2.console.log(result['pm']);
				var str = '<hr style = "background:red;"/>';
				for(reply of result['replyList']){
					//console.log(reply)
					str +=
						'<div>'+
						'<label>'+reply['rp_me_id']+'</label>'+
						'<div class="form-control mb-2">'+reply['rp_content']+'</div>'+
						'</div>';
				}
				str += '<hr style = "background:red;"/>';
				$('.reply-list').html(str);//기존 댓글 덮어쓰기 위해서 append는 기존 댓글 아래에 붙이는 것
				
				var pmStr = '';
				var pm = result['pm'];
				if(pm.prev)
					pmStr += '<li class="page-item" data="'+(pm.startPage - 1)+'"><a class="page-link" href="#">이전</a></li>';
				for(i = pm.startPage;i<=pm.endPage;i++){
					if(pm.criteria.page == i)
						pmStr += '<li class="page-item active"data="'+i+'"><a class="page-link" href="#">'+ i +'</a></li>';
					else	
			    		pmStr += '<li class="page-item"data="'+i+'"><a class="page-link" href="#">'+ i +'</a></li>';					
				}
				if(pm.next)
			    	pmStr += '<li class="page-item"data="'+(pm.endPage + 1)+'"><a class="page-link" href="#">다음</a></li>';

				$('.pagination').html(pmStr);
			}
		})
	}
	
	return{ //중괄호{}객체 /[]배열 / return{}은 객체를 리턴 / replyService.name은 replyService['name']과 같은 기능 / replyService.insert() 객체로 만들어서 만든 메소드를 밖에서 사용 
		name : '서비스',
		insert : insert,
		list/*얘의 이름으로 바깥에서 부름 리턴값이라서*/ : replyList/* 이건 js내부 메소드명*/
	}
	
})(); // 즉시실행함수 : 만들자마자 바로 사용 $는 그 상황에서만