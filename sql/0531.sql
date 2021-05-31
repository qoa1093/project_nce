/*
가수 테이블(앱스) : singer
-가수번호  : si_num, int, auto_increment, (##기본키)
-가수명(그룹명) : si_name, varchar(50),  
-데뷔년도 : si_start_year, int
-소속사 : si_agerncy, varchar(30)
*/
create database music;
use music;
create table if not exists singer(
si_num int auto_increment, -- 기본키, 여러 속성중 하나만 가능
si_name varchar(50),  
si_start_year int,
si_agerncy varchar(30),
primary key(si_num),
check(si_start_year >=0 and si_start_year<=9999)
);

/*아티스트 테이블(레이나,리지) : artist
-번호 : ar_num, int, auto_increment(##기본키)
-생일 : ar_birth, datetime
-현재소속사 : ar_agency, varchar(30)
-아티스트명 : ar_name, varchar(50)
-본명 : ar_rname, varchar(50)
*/
create table if not exists artist(
ar_num int auto_increment,
ar_birth date not null,
ar_agency varchar(30),
ar_name varchar(50) not null,
ar_rname varchar(50) not null,
primary key(ar_num)
);

/*멤버 테이블(오캬에 레이나, 앱스에 레이나) : member
-어떤 가수그룹에 아티스트가 있는지..
-번호 : me_num int auto_increment(##기본키)
-가수번호 : me_si_num int (외래키) not null
-아티스트번호 : me_ai_num int (외래키) not null
-포지션 : me_position varchar(20)*/
create table if not exists `member`(
me_num int auto_increment,
me_si_num int not null,
me_ar_num int not null,
me_position varchar(20),
primary key(me_num),
foreign key (me_si_num) references singer(si_num), 
foreign key (me_ar_num) references artist(ar_num)
);

/*음원 테이블 : sourse
-음원번호(##기본키) : so_num int auto_increment
-제목 : so_title varchar(50) not null
-가사 : so_lyric longtext not null
-공개일 : so_public_day datetime not null
-작곡가 : so_songwriter varchar(50) not null
-작사가 : so_lyricist varchar(50) not null*/
create table if not exists `source`(
so_num int auto_increment,
so_title varchar(50) not null,
so_lyric longtext not null,
so_public_day datetime not null,
so_songwriter varchar(50) not null,
so_lyricist varchar(50) not null,
primary key(so_num)
);

/*음원포함된가수 테이블 : sing
음포가 번호(##기본키) sn_num int auto_increment,
음원번호 sn_so_num int not null, -- 외래키
가수번호 sn_si_num int not null, -- 외래키
피쳐링여부 sn_featuring char(1) not null
*/
create table if not exists sing(
sn_num int auto_increment,
sn_so_num int not null, -- 외래키
sn_si_num int not null, -- 외래키
sn_featuring char(1) not null,
primary key(sn_num),
foreign key(sn_so_num) references sourse(so_num),
foreign key(sn_si_num) references singer(si_num)
);
/*앨범 테이블 : album(
-앨범번호(##기본키) al_num int auto_increment,
앨범타이틀명 al_title varchar(50) not null,
발매일등 al_issue_date date);
(대표곡) */
create table if not exists album(
al_num int auto_increment,
al_title varchar(50) not null,
al_issue_date date,
primary key(al_num)
);
/*앨범포함된가수 테이블 - issue
앨포가번호(##기본키) is_num int auto_increment,
앨범번호 is_al_num int,--외래
가수번호 is_si_num int) -- 외래;*/
create table if not exists issue(
is_num int auto_increment,
is_al_num int not null, -- 외래
is_si_num int not null, -- 외래
primary key(is_num),
foreign key(is_al_num) references album(al_num),
foreign key(is_si_num) references singer(si_num)
); 
/*앨범포함된음원 테이블(앨범에 포함된 음원들이 어떤 음원인지 알려주는 테이블) : list
앨포음번호 li_num int auto_increment, 
앨범번호 li_al_num int not null, -- 외래
음원번호 li_sonum int not null, -- 외래
 대표곡여부 li_main char(1) not null);
*/
create table if not exists list(
li_num int auto_increment, 
li_al_num int not null, -- 외래
li_so_num int not null, -- 외래
li_main char(1) not null,
primary key(li_num),
foreign key(li_al_num) references album(al_num),
foreign key(li_so_num) references `source`(so_num)
 );

/* 소녀시대가 부른 노래를 검색할 때 필요한 쿼리문
singer 테이블(가수이름), source 테이블(노래명),
sing 테이블(가수번호, 음원번호)
*/

select so_title from singer
	join sing
		on si_num = sn_si_num
	join `source`
    on so_num = sn_so_num
where si_name = '소녀시대';

/*소녀시대의 멤버들을 검색하기 위한 쿼리문*/
select ar_name from singer
	join `member`
		on me_si_num = si_num
	join artist
		on me_ar_num = ar_num
	where si_name = '소녀시대';
/* 소녀시대의 3집 앨범의 수록곡들을 확인하기 위한 쿼리문 
소녀시대의 노래들 중 3집 앨범에 있는 노래들
소녀시대의 노래들 중 / album테이블과 list테이블을 확인해야함
 */
 /*조인을 하는 경우 순서에 따라 검색시간이 달라짐*/
select so_title from (select * from singer where si_name = '소녀시대') as singer_search
	join sing
		on si_num = sn_si_num
	join `source`
		on so_num = sn_so_num
	join `list`
		on li_so_num = so_num
	join album
		on li_al_num = al_num
	where al_title like '%3집%';
    
    
/* 노래 제목이 거짓말이 들어간 노래를 확인하는 쿼리문*/
select so_title from `source` where so_title like '%거짓말%';

/* 노래 제목 또는 가사에 거짓말이 포함된 노래를 확인하는 쿼리문 */
select so_title from `source` where so_title or so_lyric like '%거짓말%';
	
/*sm 소속 아티스트 목록을 확인하는 쿼리문*/
select ar_name from artist where ar_agency like '%sm%';

/*태연이 활동한 그룹들을 확인하는 쿼리문*/
select si_name from `member`
	join singer
		on me_si_num = si_num
	join artist
     on me_ar_num = ar_num
where ar_name = '태연';

/* 태연이 피처링한 노래들을 확인하는 쿼리문
singer 테이블 : 태연, sing 테이블 : 피처링 여부
source 테이블 : 노래
*/
select so_title from singer
join source
	on sn_so_num = so_num
join sing
	on sn_si_num = si_num
    where si_name = '태연' and sn_featuring = 'Y';
    
/* 소녀시대의 메인 타이틀곡들을 확인하는 쿼리문 작성
singer 테이블, source 테이블,  */
select so_title from (select * from singer where si_name = '소녀시대') as singer_search
	join sing
		on si_num = sn_si_num
	join `source`
		on so_num = sn_so_num
	join `list`
		on li_so_num = so_num
	join album
		on li_al_num = al_num
	where li_main = 'Y';



