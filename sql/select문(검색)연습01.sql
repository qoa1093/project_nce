-- example 데이터베이스 생성
-- create database example;
-- example 데이터베이스 선택
-- use example;

-- 고객테이블 생성;
/*
 create table 고객(
 고객아이디 varchar(20) not null,
 고객이름 varchar(10) not null,
 나이 int,
 등급 varchar(10) not null,
 직업 varchar(10),
적립금 int default 0,
 primary key(고객아이디)
 );
 */
 -- 제품테이블 생성
 /*
 create table 제품(
 제품번호 char(3) not null,
 제품명 varchar(20),
 재고량 int,
 단가 int,
 제조업체 varchar(20),
 primary key(제품번호)
 -- check (재고량 >= 0 and 재고량 <= 10000)
 );
 */
 -- 주문테이블 생성
 /*
 create table 주문(
 주문번호 char(3) not null,
 주문고객 varchar(20),
 주문제품 char(3),
 수량  int,
 배송지 varchar(30),
 주문일자 datetime,
 primary key(주문번호),
 foreign key(주문고객) references 고객(고객아이디),
 foreign key(주문제품) references 제품(제품번호)
 );
*/
 -- desc 주문;
 -- 고객 테이블에 고객 데이터 추가
 /*
 insert into 고객(고객아이디, 고객이름, 나이, 등급, 직업, 적립금)
 values('apple','정소화',20,'gold','학생',1000),
 ('banana','김선우',25,'vip','간호사',2500),
 ('carrot','고명석',28,'gold','교사',4500),
 ('orange','김용욱',22,'silver','학생',0),
 ('melon','성원용',35,'gold','회사원',5000),
 ('peach','오형준',null,'silver','의사',300),
 ('pear','채광주',31,'silver','회사원',500);
*/
SELECT * FROM example.주문;
-- 제품 테이블에 제품 데이터 추가
/*
 insert into 제품(제품번호, 제품명, 재고량, 단가, 제조업체)
 values('p01','그냥만두', 5000, 4500,'대한식품'),
 ('p02','매운쫄면', 2500, 5500,'민국푸드'),
 ('p03','쿵떡파이', 3600,2600,'한빛제과'),
 ('p04','맛난초콜렛', 1250, 2500,'한빛제과'),
 ('p05','얼큰라면', 2200, 1200,'대한식품'),
 ('p06','통통우동', 1000, 1550,'민국푸드'),
 ('p07','달콤비스켓', 1650, 1500,'한빛제과');
 */
 -- 주문 테이블에 주문 데이터 추가
 /*
 insert into 주문(주문번호, 주문고객, 주문제품, 수량, 배송지, 주문일자)
 values('o01', 'apple', 'p03', 10, '서울시 마포구', '2013-01-01' ),
 ('o02', 'melon', 'p01', 5, '인천시 계양구', '2013-01-10' ),
 ('o03', 'banana', 'p06', 45, '경기도 부천시', '2013-01-11' ),
 ('o04', 'carrot', 'p02', 8, '부산시 금정구', '2013-02-01' ),
 ('o05', 'melon', 'p06', 36, '경기도 용인시', '2013-02-20' ),
 ('o06', 'banana', 'p01', 19, '충청북도 보은군', '2013-03-02' ),
 ('o07', 'apple', 'p03', 22, '서울시 영등포구', '2013-03-15' ),
 ('o08', 'pear', 'p02', 50, '강원도 춘천시', '2013-04-10' ),
 ('o09', 'banana', 'p04', 15, '전라남도 목포시', '2013-04-11' ),
 ('o10', 'carrot', 'p03', 20, '경기도 안양시', '2013-05-22' );
 */
 -- 고객 명단 확인(고객의 전체 정보를 확인)
 select * from 고객; -- 고객이란 테이블에 있는 모든 속성값을 확인

-- 고객 명단에서 고객들의 등급을 확인(등급만 확인)
-- all | distinct 생략하면 all이 적용됨
-- select문에서 테이블명 앞에 데이터베이스명을 안쓰면 현재 선택된 데이터베이스에 따라 쿼리문이 실행되지 않을 수도 있다.
select distinct 등급 from 고객;

-- 고객의 등급을 확인(고객아이디와 등급을 확인)
select 고객아이디, 등급 from 고객;
-- 검색 결과의 속성 이름을 변경, 즉 줄여서 표현하고 싶을때 : as, 해당 검색 결과에서만 바뀜
select 고객아이디 as '아이디', 등급 from 고객;

-- 아이디가 apple인 고객의 주문 내역 확인 작업
select * from 주문 where 주문고객 = 'apple';

-- 제품명이 p01인 제품이 주문된 내역을 확인
select * from 주문 where 주문제품 = 'p01';

-- 제조업체가 한빛제과인 제품의 목록을 확인
select 제품명 from 제품 where 제조업체 = '한빛제과';

-- 5개 이상 주문한 고객의 아이디를 확인
select distinct 주문고객 as '아이디' from 주문 where 수량 > 4;

-- 단가가 2000원 이상 3000원 이하인 제품명을 확인
select 제품명, 단가 from 제품 where 단가 >= 2000 and 단가 <= 3000;

-- 조건에서 속성 = '문자열'로 확인하면 해당 문자열과 완전히 일치하는 것들을 확인
-- 고객이름이 오 인 고객리스트를 확인(이때 like는 =와 같은 역할)
/* like '%검색어%' : 검색어가 포함된 문자열
   like '검색어%'  : 검색어로 시작하는 문자열(길이상관x)
   like '%검색어'  : 검색어로 끝나는 문자열(길이상관x)
   like '검색어__' : 검색어로 시작하는 5자 길이의 문자열
   like '__검%'	 : 3번째 글자가 '검'인 문자열
*/
select * from 고객 where 고객이름 like '%용%';

-- 고객이름이 3글자인 고객의 리스트를 확인
select * from 고객 where 고객이름 like '___';

-- 고객의 성이 김씨인 고객의 리스트를 확인
select * from 고객 where 고객이름 like '김%';

-- 속성의 값이 null인지 아닌지 확인할때 is null || is not null을 이용
-- 나이가 null로 저장된 고객의 이름을 확인
select 고객이름 from 고객 where 나이 is null;

-- 나이가 null이 아닌 고객의 이름을 확인
select 고객이름 from 고객 where 나이 is not null;

-- 정렬은 order by 속성명1, 속성명2, ... [asc|desc]로 정렬할 수 있다. ([오름차순|내림차순])
-- order by는 where과 별개
-- 고객을 고객 이름순으로 역 정렬
select * from 고객 order by 고객이름 desc; 

-- 고객을 고객 등급순으로 정렬
select * from 고객 order by 등급; 

-- 고객의 등급을 기준으로 정렬한 후 이름 순으로 정렬
-- 고객을 고객 이름순으로 정렬
select * from 고객 order by 등급 asc, 고객이름 asc; 

-- count : 속성값의 개수 | max : 속성값의 최댓값 | min : 속성값의 최솟값 | sum : 속성 값의 합계 | avg : 속성 값의 평균
-- 가입된 고객의 수 
select count(고객아이디) from 고객;
select count(*) from 고객;
-- 가입된 고객 중 최고령자
select max(나이) from 고객;
-- 가입된 고객 중 최연소자의 나이
select min(나이) from 고객;
-- 판매된 제품수(총 판매수량)
select sum(수량) as '판매량' from 주문;
-- 제품의 평균 가격
select avg(단가) from 제품;
-- 아이디가 apple인 회원의 평균 주문량 확인
select avg(수량) as 'apple의 평균 주문량' from 주문 where 주문고객 = 'apple';
-- group by는 where절 다음에 order by 앞에 있어야한다.
-- 주문 제품별 총 판매 수량을 확인
select 주문제품, sum(수량) as '판매수량' from 주문 group by 주문제품;  
-- 고객별 총 주문 수량
select 주문고객, sum(수량) as '주문수량(누적)' from 주문 group by 주문고객;
-- 제조업체별 제품수와 제품들의 최고가와 최저가를 확인
select 제조업체, count(*) as 제품수, max(단가) as 최고가, min(단가) as 최저가 from 제품 group by 제조업체;

-- having : 그룹에서 조건을 걸고 싶을때 사용하는 절로 집계함수를 이용할 수 있다
-- 제품수가 3개 이상인 제조업체
-- select 제조업체 from 제품 where count(*) >= 3 group by 제조업체; -- 에러남 : 그룹절에서는 집계함수 이용할수없음
select 제조업체 from 제품 group by 제조업체 having count(*) >= 3;

-- 컴퓨터학과의 교수님 수를 확인
select pr_dep as '학과', count(pr_dep)from portal.professor where pr_dep = '컴퓨터';
select count(*) from portal.professor where pr_dep = '컴퓨터' group by pr_dep;

-- 교수번호 P2002140001인 교수님이 강의하는 강의 리스트 확인
select * from portal.class where cl_pr_num = 'P2002140001'; 

-- 학점이 2학점 이상인 강의리스트를 확인
select * from portal.class where cl_point >= 2;

-- 월요일에 수업하는 강의 리스트 확인
select * from portal.class where cl_schedule like '%월%';

-- 2020학번 학생들을 확인 
select * from portal.student where st_num like '2020%';

-- 2020135001 학생이 2021MSC004 강의를 수강했을때 사용해야하는 쿼리문
insert into course(co_st_num, co_cl_code) values('2020135001', '2021MSC004');

select * from portal.course;
-- 2020135001 학번 학생이 수강한 강의 수 확인
select count(*) as '수강한 강의수' from course where co_st_num = '2020135001';

-- 2020135001 학번 학생이 2021년도에 수강한 강의수 확인
select count(*) as '2021년도 수강한 강의수' from course where co_st_num = '2020135001' and co_cl_code like '2021%'; 

-- [조인검색] : 여러개의 테이블을 연결하여 데이터를 검색
-- join은 한 테이블로 원하는 모든 정보를 가져올 수 없을때 여러 테이블을 하나로 만들어서 가져와야 하는 경우에 사용
-- 2020135001 학생의 수강한 강의제목을 하나의 테이블로 확인할 수 있다(x), 수강테이블에서 2020135001학생이 수강한 강의코드는 확인할수 있지만 제목은 확인이 불가
-- 2020135001 학생의 수강한 강의코드를 하나의 테이블로 확인할 수 있다(o), 수강테이블에서 확인 가능

-- select 테이블명1.속성명1, 테이블2.속성2, ... 테이블2.속성1 from 테이블1, 테이블2 where 조건

-- 2020135001 학생의 수강한 강의 제목을 확인하기 위해서 course(수강정보) ,class(강의제목) 2개 테이블 필요
select co_st_num as '학번',cl_title as '강의명' from course, class where co_cl_code = cl_code and co_st_num = '2020135001';	
-- @@@ where문 빼면 co_cl_code 하나당 cl_code 전체가 들어가는 불상사가.., and문으로 학생 걸러냄

-- P2000135001 교수님의 강의를 들은 학생 명단
select st_name from course, class, student where co_cl_code = cl_code and co_st_num = st_num and cl_pr_num = 'P2000135001';


-- select 속성1, 속성2, ... from 테이블1 join 테이블2 on 테이블1.외래키 = 테이블2.기본키;
-- 위에 한 2020135001학번 학생이 수강한 강의명을 확인하는 코드를 join을 이용하여 확인
select co_st_num as '학번', class.cl_title as '강의명'  
from course 
	join class 
		on course.co_cl_code = class.cl_code 
			where course.co_st_num = '2020135001';

-- join할때 두 테이블의 속성명이 겹치지 않는경우 속성 이름앞에 테이블명을 생략해도 된다
-- 네트워크를 강의하는 교수님 이름을 확인하는 커리문
select pr_name, cl_title from class 
	join professor
		on pr_num = cl_pr_num
			where cl_title = '네트워크'; 

-- apple 고객이 주문한 가격을 확인
select 주문번호, 주문고객, (수량*단가) as '가격' from 주문
join 제품
on 주문제품 = 제품번호 
where 주문고객 = 'apple';

-- 그냥만두가 판매된 갯수
select 제품명, sum(수량) as '판매갯수'from 제품
 join 주문
 on 주문제품 = 제품번호
 where 제품명 = '그냥만두';







