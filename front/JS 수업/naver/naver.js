var id;
$(function(){
	//right2박스 컨텐츠 롤링 기능
	id = rollingLeft('.right2 .view-box .contents-box','li',800,1500); 
	$('.right2').hover(function(){
			clearInterval(id);				
		},function(){
			id = rollingLeft('.right2 .view-box .contents-box','li',800,1500);
		})
		//right2박스 컨텐츠 다음버튼
	$('.right2 .btn-box .next-btn').click(function(){
		if(!$('.right2 .contents-box li').first().is(':animated')){
			var width = $('.right2 .contents-box li').first().width();// ㅣli태그에 패딩준 경우는 innerwidth로 주어야함(패딩+가로길이 합)
			$('.right2 .contents-box li').first().animate({'margin-left': -width + 'px'},800,function(){
				$(this).detach().appendTo('.right2 .contents-box').removeAttr('style');
			})
		}
	})
	//right2박스 컨텐츠 이전 버튼
	$('.right2 .btn-box .prev-btn').click(function(){
		if(!$('.right2 .contents-box li').first().is(':animated')){
			var width = $('.right2 .contents-box li').first().width();    
			$('.right2 .contents-box li').last().detach().prependTo('.right2 .contents-box')
				.css('margin-left', -width + 'px').animate({'margin-left':0},800);	
		}
	})

	/*$('.menu.container .more-btn').click(function(){
		
		$('.men-box').toggle();
		$('.plus-btn').toggle();
	})*/
	


})