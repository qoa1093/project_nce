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
	var oriMenu = ['사전','뉴스','증권','부동산','지도','VIBE','웹툰']; //기본메뉴
	var selMenu = []; //개인선택한 메뉴(저장으로 최종 확정된 선택된 메뉴)
  var tmpMenu = []; //메뉴 설정에서 선택한 메뉴
  var oriHref = ['https://dict.naver.com/'];
  var selHref = [];  
  var tmpHref = [];

			//메뉴 더보기 버튼 클릭
			$('.menu .more-btn').click(function(){
					$('.box3 .menu-box').show();
					$('.box3 .menu .menu-btn-box').show();
					$(this).hide();
					$('.menu .fold-btn').show();
          				
			})

			//접기 버튼 클릭
			$('.menu .fold-btn').click(function(){
				//접기+더보기 버튼
					$(this).hide();
					$('.menu .more-btn').show();
				//메뉴 박스 
					$('.box3 .menu-box').hide();
					$('.box3 .menu-box .menu-box1').show(); //메뉴 링크
					$('.box3 .menu-box .menu-box2').addClass('display-none'); //메뉴 체크박스 가림

				//메뉴 버튼 박스
					$('.box3 .menu .menu-btn-box').hide();
					$('.box3 .menu .menu-btn-box .btn-box1').show(); //서비스 전체보기, 메뉴 설정 버튼을 보여주고
					$('.box3 .menu .menu-btn-box .btn-box2').hide(); //초기화, 저장 버튼은 감춤
					
				//검은 메뉴 출력 부분
					setMenuBox(selMenu, oriMenu, selHref, oriHref);
          tmpMenu = [];	//@@
          tmpHref = [];
          initCheckbox(selMenu);			
			})

			//메뉴 설정 버튼 클릭
			$('.box3 .set-btn').click(function(){
					$('.box3 .menu-box1').hide();
					$('.box3 .menu-box2').removeClass('display-none');
					$('.box3 .btn-box2').show();
					$('.box3 .btn-box1').hide();
					initMenuBox(selMenu);
          tmpMenu = selMenu.slice(0); //@@
          tmpHref = selHref.slice(0);
			})


    // 6월 29일 예제 : 박스에 선택 추가하기
      //메뉴 설정에서 체크박스 클릭

      $('.menu-list input[type=checkbox]').click(function(){
        var value = $(this).val(); //클릭한 요소의 value값 가져옴
        var state = $(this).prop('checked');
        var href = $(this).attr('data-target');
        //console.log(state);
        if(state){
          //배열에 추가
          if(tmpMenu.length == 4){
            $(this).prop('checked', !state);// 체크값을 false로
            alert('최대 4개');
            return;
          }
          tmpMenu.push(value);
          tmpHref.push(href);
        }else{
          //배열에서 제거
          var index = tmpMenu.indexOf(value); //해당 요소의 위치를 찾음
          tmpMenu.splice(index,1);
          tmpHref.splice(index,1);
        }
        initMenuBox(tmpMenu);
        
      })
      //메뉴설정에서 저장버튼
        // save-btn click -> tmp = sel -> remove -> set
        $('.btn-box2 .save-btn').click(function(){
          
          
          selMenu = tmpMenu.slice(0);
          selHref = tmpHref.slice(0);         
          $('.menu .fold-btn').click();
          console.log(selMenu);
          //setMenuBox(selMenu,oriMenu);//@@-
        })

        $('.btn-box2 .init-btn').click(function(){
          alert('초기설정으로 돌아갑니다.');
          selMenu = []; 
          selHref = [];         
          //initMenuBox(selMenu);
          $('.menu .fold-btn').click();
        })


})

/* 함수 모음 */	
  /* 메뉴설정을 눌렀을때 검은 메뉴 창에 메뉴를 선택할 수 있는 박스를 보여주도록 화면을 구성하는 함수
      선택된 메뉴가 있으면 글자가, 아니면 박스가 보이도록 하는 역할(최대4개)
  */
			function initMenuBox(arr){		
				$('.black-menu-list .list-item').each(function(index){
					$(this).removeClass('input-box selected display-none');
					$(this).find('a').attr('href','#');
					//5번째 검은색 메뉴를 안보이게 함
					if(index >=4){
						$(this).addClass('display-none');
					}
					//선택된 메뉴를 화면에 미리 출력
					else if(arr.length > index){
						$(this).find('a').text(arr[index]);
					}
					//남은 부분을 검은색 빈 박스로 변경
					else{
						$(this).find('a').text('');
						$(this).addClass('input-box');
						if(index == arr.length){
							$(this).addClass('selected');
						}
					}
				})
			}
			/* 선택된 메뉴에 따라 검은색 메뉴를 보여주는 부분 
					선택된 메뉴가 없으면 기본 메뉴를 화면에 보여준다
			*/
			function setMenuBox(selArr, oriArr, selHref, oriHref){	
				//선택된 메뉴가 있으면 선택된 메뉴를 화면에 출력하고 선택된 메뉴가 없으면 미리 지정된 메뉴 출력
				//하기 위해 arr를 상황에 따라 선정
				var arr = selArr.length == 0? oriArr : selArr;
				var hrefArr = selHref.length == 0? oriHref : selHref;
		
				$('.black-menu-list .list-item').each(function(index){
					$(this).removeClass('display-none');
					//메뉴를 보여줘야 하기 때문에 메뉴 선택할때 사용된 박스를 제거
					$(this).removeClass('selected input-box');
					if(index < arr.length){
						$(this).find('a').text(arr[index]);
						$(this).find('a').attr('href', hrefArr[index]);
					}else{
						$(this).addClass('display-none');
					}
				})
			}
			//메뉴 설정에서 선택된 메뉴에 따라 체크 박스 체크여부가 결정되게 하는 함수
			function initCheckbox(arr){
				$('.menu-list input[type=checkbox]').each(function(){
					var value = $(this).val();
					//선택된 메뉴에 값이 있으면
					if(arr.indexOf(value) >= 0){
						$(this).prop('checked',true);
					}else{
						$(this).prop('checked',false);
					}
				})
				
			}