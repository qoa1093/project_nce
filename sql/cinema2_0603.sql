create database if not exists cinema2;

use cinema2;


CREATE TABLE if not exists `movie` (
	`mo_num`	int	NOT NULL,
	`mo_title`	varchar(50)	not NULL,
	`mo_contents`	longtext	not NULL,
	`mo_director`	varchar(100)	not NULL,
	`mo_main_actor`	longtext	not NULL,
	`mo_sub_actor`	longtext	NULL,
	`mo_opening_date`	date	 NULL,
	`mo_genre`	varchar(100)	not NULL,
	`mo_runtime`	int	not NULL,
	`mo_rating`	int	not NULL,
    primary key(mo_num)
);

CREATE TABLE if not exists `theater` (
	`th_branch`	varchar(50)	NOT NULL,
	`th_address`	varchar(50)	NULL,
	`th_transport`	longtext	NULL,
    primary key(th_branch)
);

CREATE TABLE if not exists `screen_room` (
	`sr_num`	int	NOT NULL,
	`sr_th_branch`	varchar(50)	NOT NULL,
	`sr_name`	varchar(50)	not NULL,
	`sr_personnel`	int	not NULL default 0,
	`sr_location`	varchar(50)	not NULL,
    primary key(sr_num),
    foreign key(sr_th_branch) references theater(th_branch)
);

CREATE TABLE if not exists `screen` (
	`sc_num`	int	NOT NULL,
	`sc_mo_num`	int	NOT NULL,
	`sc_start_time`	char(5)	not NULL,
	`sc_end_time`	char(5)	not NULL,
	`sc_date`	date	not NULL,
	`sc_sr_num`	int	NOT NULL,
	`sc_type`	varchar(10)	not NULL default '2D',
    primary key(sc_num),
    foreign key(sc_mo_num) references movie(mo_num),
    foreign key(sc_sr_num) references screen_room(sr_num)
);

CREATE TABLE if not exists `seat` (
	`se_num`	int	NOT NULL,
	`se_sr_num`	int	NOT NULL,
	`se_name`	char(3)	not NULL,
    primary key(se_num),
    foreign key(se_sr_num) references screen_room(sr_num)
);

CREATE TABLE if not exists `member` (
	`me_id`	varchar(20)	NOT NULL,
	`me_name`	varchar(50)	not NULL,
	`me_level`	varchar(10)	not NULL default 'bronze',
	`me_point`	int	not NULL default 0,
    primary key(me_id)
);

CREATE TABLE if not exists `ticket` (
	`ti_num`	int	NOT NULL,
	`ti_personnel`	int	not NULL default 1,
    primary key(ti_num)
);

CREATE TABLE if not exists `reservation` (
	`re_num`	int	NOT NULL,
	`re_me_id`	varchar(20)	NOT NULL,
	`re_sc_num`	int	NOT NULL,
	`re_se_num`	int	NOT NULL,
	`re_price`	int	not NULL default 0,
	`re_ti_num`	int	NOT NULL,
    primary key(re_num),
    foreign key(re_me_id) references `member`(me_id),
    foreign key(re_sc_num) references screen(sc_num),
    foreign key(re_se_num) references seat(se_num),
    foreign key(re_ti_num) references ticket(ti_num)
);

-- 입력 빼먹으면 추가하는 코드
-- ALTER TABLE `screen_room` ADD CONSTRAINT foreign key(sr_th_branch) references theater(th_breanch);

/*해당 영화제목을 입력하기 위한 insert문 작성*/
insert into movie 
values(1, '컨저링3-악마가시켰다','모든것은 악마가 시켰다!','마이클 차베즈', '베라 파미가, 패트릭 윌슨', '줄리안 힐리야드',210603,'공포',112,15);

/*영화 정보 확인하는 쿼리문 - 컨저링3을 확인*/
select * from movie where mo_title like '%컨저링3%'; -- concat('%','컨저링 3', '%')

/*cgv청주성안길 영화관 정보 입력 */
insert into theater
values('CGV청주성안길', '충청북도 청주시 상당구 북문로 1가 180-1', '교통안내 : 버스 이용시 지하상가 정류장 하차');
select * from theater;

/*컨저링3의 오늘 상영시간을 확인하는 쿼리문*/
select sc_start_time from screen
	join movie on sc_mo_num = mo_num
	where mo_title like '%컨저링 3%'and sc_date like '2021-06-03%';

/*컨저링3의 cgv청주성안길 지점의 샹영정보를 확인하는 쿼리문*/
select mo_title, sr_th_branch, screen.* from screen
 join screen_room	on	sc_sr_num = sr_num
 join movie	on	mo_num = sc_mo_num
where mo_title like '%컨저링3%' and th_branch like '%성안길%';

select screen.* from screen
	where sc_mo_num = (select mo_num from movie where mo_title like '%컨저링3%') 
    and sc_sr_num = (select sr_num from screen_room where sr_th_branch like '%성안길%');
/* cgv청주성안길 지점의 1관의 예매가능한 좌석정보를 확인하는 쿼리문*/
select se_name from seat
	join screen_room on sr_num = se_sr_num
		where sr_name like '1관' and sr_th_branch like 'CGV청주성안길';
select se_name from seat
	where se_sr_num =
    (select sr_num from screen_room 
		where sr_name like '1관' and sr_th_branch like 'CGV청주성안길');
        
/* 'CGV청주성안길' 컨저링3이 9:00에 있을때 해당 영화의 선택 가능한 좌석을 확인
-- 해당 영화의 상영관 정보를 알아야 좌석 정보를 알수있다.
-- 해당 영화 예매내역 중 예약된 좌석 현황
-- 해당 영화의 예매 가능한 좌석 정보를 확인
*/
select se_name from seat 
	where se_sr_num =
    (select sr_num from screen_room join screen on sc_Sr_num = sr_num
    where sr_th_branch like 'CGV청주성안길' 
		and sc_start_time like '9:00'
        and sc_date like '2021-06-03%'
        and sc_mo_num = (select mo_num from movie where mo_title like '%컨저링3%'));
-- 제목이 컨저링3인 영화번호와 /같은 영화번호/9시 시작/청주성안길 영화관/에서 상영시간표의 상영관번호와 상영관의 번호가 같을때
-- 상영관의 번호들
-- 즉 제목이 컨저링3/9시/청주성안길점을 만족하는 상영관
select sr_num from screen_room join screen on sc_Sr_num = sr_num
    where sr_th_branch like 'CGV청주성안길' 
		and sc_start_time like '9:00'
        and sc_date like '2021-06-03%'
        and sc_mo_num = (select mo_num from movie where mo_title like '%컨저링3%');
select sc_num, sc_sr_num from screen
	where sc_sr_num =
    (select sr_num from screen_room where sr_th_branch like 'CGV청주성안길')
    and sc_start_time like '9:00'
    and sc_date like '2021-06-03%'
    and sc_mo_num = (select mo_num from movie where mo_title like '컨저링3%');
    
-- 해당 영화 예매 내역 중 예약된 좌석 현황
select se_num from seat where se_num in
	(select re_se_num from reservation where re_sc_num = ('상영시간번호')); 
    
-- 해당 영화에서 (오늘 9:00 컨저링3)예약 가능한 좌석
select se_name from seat 
	where se_sr_num = ('상영관번호')
	and se_name not in ('예약된 좌석명');
-- 예약 가능한 좌석은 전체 좌석에서 예약된 좌석을 제외한(포함하지 않은)좌석들   
    
-- abc123 회원이 관람했던 영화 리스트를 확인
select re_me_id, mo_title from movie 
	join screen on mo_num = sc_mo_num
    join reservation on sc_num = re_sc_num
	where  re_me_id = 'abc123';
    
    
 select re_me_id, mo_title from movie 
	where  mo_num in
    (select sc_mo_num from screen 
    join reservation on sc_num = re_sc+num 
    where re_me_id = 'abc123');
       
  /* 요구사항명세서를 통해 ERD 작성하는 과정이 DB 설계
  SQL
  - DDL
    create : 테이블/ DB를 생성
    drop : 테이블/ DB를 삭제
    alter : 테이블/ DB를 수정(속성, 제약조건등을 수정)
  - DML (CRUD)
    insert : 튜플을 추가
    select : 튜플을 검색
    update : 튜플을 수정
    delete : 튜플을 삭제
  - DCL
	truncate : 테이블을 초기화
    
    delete와 truncate 비교
    - delete를 이용하여 데이터를 삭제하면 auto_increment을 가지는 속성이 있는 경우 기존 값을 이어서 증가
    - truncate를 이요하여 데이터를 삭제하면 auto_increment를 가지를 송성이 있는 경우 1부터 시작
    - truncate은 전체를 한번에 삭제하지만 delete를 한행씩 삭제해서 전체를 삭제하기 때문에 delete가 느림
    - 전체를 초기화하는경우 truncate을 이용
    - 일부만 삭제하는경우 delete를 사용
    
    select [all|distinct] 속성 from 테이블
    [where 조건]
    [group by 속성]
    [having 조건]
    [order by [asc|desc]]
    [limit 시작번지, 갯수 | limit 갯수]
    
    join : 여러 테이블들을 연결하여 원하는 검색을 함
     - 주로 외래키를 이용함
  
	insert into 테이블명[(속성,...,속성)] values(값,...,값)[(값, ...,값)];
    update 테이블명 set 속성 = 값 [where 조건];
    delete from 테이블 [where 조건];
    
    키
     - 슈퍼키(유일성) : 튜플을 0개 또는 하나만 검색할 수 있게 하는 속성들
     - 후보키(최소성) : 슈퍼키 중에서 필수적인 속성만으로 구성된 키
     - 기본키 : 후보키중에 대표할 수 있도록 중에 선정된 키, primary key
     - 대체키 : 기본키가 되지 못한 후보키(), unique
     - 외래키 : 다른 테이블의 기본키값 또는 null을 가지는 키
     
     프로시저
      - 메소드처럼 기능을 미리 지정해서 원할때 직접 호출해서 사용
     
     트리거
      - 튜플이 추가/수정/삭제 되었을 때 다른 테이블에 있는 값을 변경할 시 사용
      - 해당 동작이 자동으로 실행되게 할때 사용
     
    DB 복습
    1. DB설계(ERD) - 작은 규모의 시스템(과일가게에서 과일 판매시스템)부터 설계하는 연습을 하고, 이후에 규모가 큰 시스템을 설계하는 연습
    2. 검색 연습 : 원하는 정보를 가져오기 위한 쿼리문 연습
  */
  
    
    