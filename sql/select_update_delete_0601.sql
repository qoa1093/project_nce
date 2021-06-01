-- ppt7 80p 서브쿼리문을 이용한 데이터검색

/*방법1
달콤비스켓의 제조업체를 검색한 후 눈을 ㅗ확인한 후 확인한 제조업체로 제품명, 단가를 검색
=> 올바른 방법이 아니다
=>개발자가 해당 작업을 하기위해 매번 눈으로 확인한 후 입력할 수 없기 때문에*/
select 제조업체 from 제품 where 제품명 = '달콤비스켓';
select 제품명, 단가 from 제품 where 제조업체 ='한빛제과' ;

/*방법2.
 서브쿼리를 이용*/
 select 제품명, 단가 from 제품 where
	제조업체 = (select 제조업체 from 제품 where 제품명 = '달콤비스켓');
    
/*문제2.
 바나나 고객이 주문한 제품의 제품명과 제조업체를 검색*/
 
 /*방법1.*/
 select 제품명, 제조업체 from 주문
	join 제품 on 주문제품 = 제품번호 where 주문고객 = 'banana';
 
 /*방법2.
 서브쿼리 이용*/
 select 제품명, 제조업체 from 제품
	where 제품번호 in (select 주문제품 from 주문 where 주문고객 = 'banana');
 -- =을 통해서 확인할 수 없음 서브쿼리의 결과가 1개이상이라고 오류가 뜸
 
 /*문제3.
	banana 고객이 주문하지 않은 제품의 제품명과 제조업체를 검색 */
/*방법1. (잘못된 쿼리)
join을 이용 : banana 고객이 아닌 고객이 주문한 제품들*/
 select distinct 제품명, 제조업체 from 주문
	join 제품 on 주문제품 = 제품번호 where 주문고객 <> 'banana'; -- <>뿐만 아니라 != 도 가능
    
  /*방법2. 
  서브쿼리 이용*/
  select 제품명, 제조업체 from 제품 
		where 제품번호 not in (select 주문번호 from 주문 where 주문고객 = 'banana');
        
/* 문제4.
	대한식품이 제좐 모든 제품의 단가보다 비싼 제품의 제품명, 단가, 제조업체 검색*/
select 제품명, 단가, 제조업체 from 제품 
	where 단가 > all (select 단가 from 제품 where 제조업체 = '대한식품');
    
/* 문제5.
	2013년 3월 15일에 제품을 주문한 고객의 고객이름을 검색 */
/*방법1. join 이용*/
select 고객이름 from 고객
	join 주문 on 고객아이디 = 주문고객
	where 주문일자 = '2013-03-15';
    
/*방법2. exists와 서브쿼리 이용 */
select 고객이름 from 고객 
	where exists (
		select * from 주문 
			where 주문일자 = '2013-03-15' and 주문고객 = 고객아이디);    
    
/*SQL - DDL, DML, DCL
DDL - create, alter, drop
DML(CRUD) - select, insert, update, delete

insert into 테이블명[(속성1, 속성2, ... 속성n)]
	values(값1, 값2, ... 값n)[, (값1, 값2, ..., 갑n)]
    
select [all|distinct] 속성1, 속성2, ... 속성n from 테이블
	[where 조건]
    [group by 속성 [having]]
    [order by 속성 [desc|asc]]
    
update 테이블명
	set 
		속성명1 = 값1,
        속성명2 = 값2,
        속성명 3 = 값3,
        ...
        [where 조건];
        
delete from 테이블명 [where 조건];

delete문은 해당 조건을 만족하는 튜플을 삭제
조건이 생략되면 전체 튜플을 삭제

update문은 조건이 없으면 모든 튜플에 대해 수정을 적용
update문에 조건절을 생략하거나 조건절이 기본키에 대한 조건이 아니면 
mysql 워크벤치에서는 안정성을 위해 업데이트문을 실행하지 않음
실행하려면 워크벤치 기본 설정을 변경
단, 워크벤치가 아닌 커맨드라인클라이언트로 접속해서 실행하면 설정에 상관없이 실행됨 
에디트 - 프리퍼런스 -sql에디터 - 맨밑에 체크박스
*/

update professor
	set
		pr_pw = 'abc123';
    
/* P2000135001 교수님의 이름을 고길동으로 수정*/
update professor
		set pr_name = '고길동'
			where pr_num = 'P2000135001';
            
-- delete
create table if not exists board(
	bd_num int auto_increment,
    bd_title varchar(50) not null,
    bd_is_del char(1) not null default 'N',
    primary key(bd_num)
    );
-- 게시글 5개 등록
insert into board(bd_title)
	values('제목1'),('제목2'),('제목3'),('제목4'),('제목5');

select * from board;

-- 1번 게시글 삭제
update board set bd_is_del = 'Y' where bd_num = 1;

-- 삭제되지 않은 게시글 검색
select * from board where bd_is_del = 'N';    


/*
DCL : 데이터 제어어
grant : 특정 데이터베이스 사용자에게 권한 부여
revoke : 특정 데이터베이스 사용자에게 권한 회수
commit : 트랜잭션의 작업이 정상적으로 완료됨을 알려줌
rollback : 트랜잭션 작업이 비정상적으로 완료되었을때 복구
*/

/*
정규화 : 데이터베이스를 효율적으로 관리하기 위해 데이터 중복을 제거하면서 무결성을 유지하기 위한 기법(쪼개기)
제1정규화 : 속성의 값이 원자값을 갖도록 테이블을 분해
제2정규화 : 완전 함수 종속을 만족하도록 테이블을 분해
		 기본키의 부분집합으로 속성을 검색하면 안된다
제3정규화 : 이행종속을 제거하도록 테이블을 분해
-이행종속이란?
A->B, B->C, A->C 가 성립

반정규화 : 정규화로 테이블이 너무 많아서 검색할 때 너무 많은 join이 필요한 경우 
		반정규화 활용하여 테이블에 속성을 추가

*/
/*소녀시대가 부른 노래를 검색
sing 테이블에 가수이름을 저장하는 sn_si_name을 추가하여(반정규화) 쿼리문 작성*/
select so_title from sing
	join `source`
		on so_num = sn_so_num
	where si_name = '소녀시대';
/*소녀시대 3집앨범의 수록곡을 확인하기 위한 쿼리문
list 테이블에 가수이름을 저장하는 li_st_name을 추가하여(반정규화) 쿼리문 작성
*/
select so_title from `source`
	join `list`
		on so_num = li_so_num
	join album
        on al_num = li_al_num
	where li_si_name = '소녀시대' and al_title like '%3집%';

/* 트리거와 크로시저 : 사용을 안하는 것이 좋다
	프로시저 : 사용자가 만든 함수로 호풀하여 사용
    트리거 : 데이터가 추가, 수정, 삭제가 일어나는 경우 미리 지정된 작업이 자동으로 실행됨
	delimiter 기호
    create trigger 트리거명 
    {before/after} { insert | update | delete } on 테이블명
    for each row
    begin
		코드작성;
	end 기호
    delimiter ;
    delimiter 기호 
    : 문장의 마지막을 알려주는 기호를 ; 대신 지정한 기호로 대체
	: 코드작성부분에서 ;이 나왔을때 실행되지 않도록 ;을 무시하게 하기위해서 사용	
*/
use portal;
/* 학생이 강의를 수강신청하면 해당 강의의 현재 정원이 1증가하는 트리거 */
drop trigger if exists insert_course;
delimiter //
create trigger insert_course after insert on course
for each row
begin
	update class
		set cl_now_count = cl_now_count + 1
        where cl_code = new.co_cl_code;
end //
delimiter ;
-- 해당 데이터베이스의 트리거 확인
show triggers;

use example;
/*주문 테이블에 주문내역이 추가되면 제품 테이블의 재고량이 변하는 트리거 작성*/
drop trigger if exists insert_order;
delimiter //
create trigger insert_order after insert on `주문`
for each row
begin
	update `제품`
		set 재고량 = 재고량 - new.수량
        where 제품번호 = new.주문제품;
end //
delimiter ;

-- 트리거 실행문에서 조건문 사용해보기
drop trigger if exists test_order;
delimiter //
create trigger test_order after insert on `주문`
for each row
begin
	/*if문 문법
    if 조건 then
		쿼리문;
	elseif 조건 then
		쿼리문;
	else
		쿼리문;
	end if;
    */
    /* 변수 선언
    - 변수선언(begin 바로 밑에 변수들을 모아서 선언해야함)
    declare 변수명 타입 default 초기값;
    - 변수 선언시 변수명 앞에 _를 붙으면 좋다. 속성이름과 구분하기 좋음
    - 변수 저장
     set 변수명 = 값;
    */
    declare _amount int default 0;
    declare _state varchar(10);
    set _amount = 10;
    set _amount = (select count(*) from 주문);
    if _amount > 10 then
		set _state = '만다';
	elseif _amount > 5 then
		set _state = '적절';
	else
		set _state = '적음';
	end if;
end //
delimiter ;
/*포르시저
	drop procedure if exists 프로시저명;
    delimiter 기호
    create procedure 프로시저명(
		{in|out} 변수명1,	-- out은 리턴값 in은 매개변수값
        {in|out} 변수명2,
        ...
	)
    begin
		구현;
	end 기호
    delimiter ;
    
    - 프로시저 호출
    call 프로시저명(뱐수들);
    */
drop procedure if exists addOrder;
    delimiter //
    create procedure addOrder(
		in _id varchar(20),	
        in _product char(3),
        in _amount int,
        in _address varchar(30),
        in _date varchar(20)
        
	)
    begin
		declare _count int default 0;
        declare _order_num char(3);
        set _count = (select count(*) from 주문) + 1;
        set _order_num = concat('o', _count);
        -- set _order_num = 'o13';
        insert into `주문` values(_order_num, _id, _product, _amount, _address, _date);
		select * from `주문`;
    end //
    delimiter ;

call addOrder('apple','p01',15,'충북 청주시', '2021-06-01');

-- 주문 - 제품
-- right join : 오른쪽인 제품을 기준으로 join을 하는데 
-- 제품과 연결된 주문내역이 없으면 주문에 해당하는 속성들이 값을 nulll로 채워서 보여줌

-- 주문과 제품 테이블에서 그냥 join은 inner join이면서, left join에 해당 
/* 
select * from A left join B on A.속성 = B.속성;는
select * from B right join A on A.속성 = B.속성;와 같다
*/

select * from `주문 `right outer join `제품`
on 주문제품 = 제품번호; 
