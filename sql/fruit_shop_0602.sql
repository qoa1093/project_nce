/* 과일가게에서 과일판매를 관리하려고 한다
이를 ERD로 작성한 후 DB와 테이블을 생성하시오
DB명 : fruit_shop2
(조건)해당 가게에서 판매될 모든 과일은 미리 등록되어있다고 가정
과일 입고, 출고, 판매
판매 내역 구매 내역 

과일
- 과일명(기본키), 가격, 단위, 재고량

거래
- 거래번호, 과일명, 구분, 수량, 날짜, 판매가격

*/

create database if not exists fruit_shop2;
use fruit_shop2;
CREATE TABLE  if not exists `fruit` (
	`fr_name`	varchar(15)	NOT NULL,
	`fr_price`	int	not NULL default 0,
	`fr_unit`	varchar(10)	not NULL default 'box',
	`fr_amount`	int	not NULL default 0,
    primary key(fr_name)
);

CREATE TABLE  if not exists `trade` (
	`tr_num`	int	NOT NULL,
	`tr_amount`	int	not NULL default 0,
	`tr_type`	varchar(4)	not NULL default 'sell',
	`tr_price`	int	not NULL default 0,
	`tr_date`	datetime not NULL default current_timestamp,
    `tr_fr_name`	varchar(15)	NOT NULL default 0,
    primary key(tr_num),
    foreign key(tr_fr_name) references fruit(fr_name)
);

-- 사과가 입고되기 위해서 fruit 테이블에 사과 정보가 등록되어있어야한다.
insert into fruit values('사과', 10000, 'box', 0);
select * from fruit;

-- 사과 100상자 입고되었다. 상자당 단가는 10000원.
 -- trade 테이블 insert후 fruit 테이블에 재고량을 update
insert into trade(tr_num, tr_amount, tr_type, tr_price, tr_fr_name) 
	values(1, 100, 'buy', 1000000, '사과');
select * from trade;

update fruit set fr_amount = fr_amount + 100 where fr_name = '사과';


-- 손님이 사과1상자를 개당 20000원에 구매를 했다.오늘 과일 판매액을 확인했다.
-- 총 매출액 확인

-- 트리거
-- 과일을 입고하거나 판매하면 재고량이 입고 또는 판매량에 맞춰서 변하는 트리거를 생성