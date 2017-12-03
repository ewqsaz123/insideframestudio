--------------테이블 생성----------------
CREATE TABLE member (
	email varchar(45) not null primary key,
	pw varchar(45) not null,
	name varchar(20) not null,
	mtype varchar(15) not null,
	admin int default 0,
	mimage varchar(100),
	birth varchar(20),
	height int,
	weight int,
	phone varchar(20),
	sex varchar(4)
);

CREATE TABLE career (
	careerno int auto_increment primary key,
	email varchar(45) not null,
	type varchar(15),
	title varchar(45),
	roll varchar(15),
	cdate varchar(30),
	movieno int
);


CREATE TABLE board (
	idx int auto_increment primary key,
	writer varchar(45),
	btitle varchar(100),
	bdate varchar(20),
	btype varchar(20),
	bcount int
);

CREATE TABLE movie(
	movieno int auto_increment primary key,
	mtitle varchar(45),
	movieimage varchar(100),
	director varchar(45),
	youtubelink varchar(100),
	category varchar(20),
	mdate varchar(30),
	likeno int,
	mcount int,
	movieinfo TEXT
);

CREATE TABLE categoryno(
	category varchar(45) primary key,
	no int,
	seq int
);

alter table member change image mimage varchar(100);

drop table board;
drop table movie;
drop table board_comment;
drop table movieno_comment;
commit;
CREATE TABLE board(
	idx int auto_increment primary key,
	writer varchar(20) not null,
	btitle varchar(100) not null,
	bdate varchar(20) not null,
	btype varchar(20) not null,
	content TEXT,
	bcount int
); 
select * from board;
CREATE TABLE board_comment(
	commentno int auto_increment primary key,
	comment_board int,
	commentid varchar(45),
	commentdate varchar(15),
	commentcontent TEXT
); 

alter table movieno_comment modify mcommentdate varchar(30);
alter table board_comment modify commentdate varchar(30);

CREATE TABLE movieno_comment(
	mcommentno int auto_increment primary key,
	comment_movieno int,
	mcommentid varchar(45),
	mcommentdate varchar(15),
	mcommentcontent TEXT
); 
commit;
--------------테이블 삭제----------------
drop table member;
drop table profile;
drop table career;
drop table movieinfo;

--------------테이블 조회----------------
SELECT * FROM member;

select * from career;

alter table career add movieno int;

select * from member where mtype = '배우' and sex='남';

SELECT * FROM profile;

select * from member where email = 'ysung1223@nate.com';

delete from member where email = 'ysung1223@nate.com';

alter table member drop column profileno;

alter table member add column sex varchar(4);

alter table member modify weight int;


alter table member modify height int;

ALTER TABLE member CHANGE type mtype varchar(15);
ALTER TABLE career CHANGE date cdate varchar(15);
drop table movie;

insert into member(email,pw,name,mtype,sex,height,birth) values("ysung1223@nate.com","1234","여성","감독","여",170,"19940404");
insert into member(email,pw,name,mtype,sex,height,birth) values("ysung1@nate.com","4324","봉수","배우","여",170,"19760404");
insert into member(email,pw,name,mtype,sex,height,birth) values("ysung321@nate.com","4","기철","배우","여",168,"19960404");
insert into member(email,pw,name,mtype,sex,height,birth) values("ysung12321@nate.com","44","길동","감독","남",190,"19910404");
insert into member(email,pw,name,mtype,sex,height,birth) values("ysud1@nate.com","4334","동건","배우","남",177,"19840404");
insert into member(email,pw,name,mtype,sex,height,birth) values("ysung1223@nde.com","1234","여성","감독","남",187,"19890404");

insert into member(email,pw,name,mtype,sex,height,birth) values("ydsfdg1@nate.com","4324","봉수","배우","남",163,"19870404");
insert into member(email,pw,name,mtype,sex,height,birth) values("yzdg321@nate.com","4","기철","배우","여",153,"19970404");
insert into member(email,pw,name,mtype,sex,height,birth) values("yzg12321@nate.com","44","길동","감독","남",188,"19980404");
insert into member(email,pw,name,mtype,sex,height,birth) values("fsgwgd1@nate.com","4334","동건","배우","남",184,"19950404");
insert into member(email,pw,name,mtype,sex,height,birth) values("231223@nate.com","1234","여성","감독","여",123,"19960404");

insert into member(email,pw,name,mtype,sex,birth) values("ysaf1@nate.com","4324","봉수","감독","남","19940404");
insert into member(email,pw,name,mtype,sex,birth) values("afng321@nate.com","4","기철","배우","남","19980404");
insert into member(email,pw,name,mtype,sex,birth) values("yhgg12321@nate.com","44","길동","배우","남","19990404");
insert into member(email,pw,name,mtype,sex,birth) values("ykhd1@nate.com","4334","동건","배우","남","19930404");
insert into member(email,pw,name,mtype,sex,birth) values("ysuur223@nate.com","1234","여성","감독","남","19930404");
insert into member(email,pw,name,mtype,sex,birth) values("y2141@nate.com","4324","봉수","배우","남","19920404");
insert into member(email,pw,name,mtype,sex,birth) values("fsfd321@nate.com","4","기철","배우","남","19910404");
insert into member(email,pw,name,mtype,sex,birth) values("fsddf12321@nate.com","44","길동","감독","남","19900404");
insert into member(email,pw,name,mtype,sex,birth) values("ydfddfdgd1@nate.com","4334","동건","배우","남","19960404");

alter table profile modify email varchar(45);

delete from member;

alter table profile modify profileno int not null auto_increment;

alter table career modify email varchar(45);

insert into career(email,type,title,roll,date) values('ysung1223@nate.com', '영화', '킬러의 보디가드', '감독','20170830');
insert into career(email,type,title,roll,date) values('ysung12321@nate.com', '영화', '잭 더 자이언트 킬러', '감독','20130228');
insert into career(email,type,title,roll,date) values('ysung1223@nde.com', '영화', '킬러들의 수다', '감독','20011012');
insert into career(email,type,title,roll,date) values('fsddf12321@nate.com', '영화', '킬러들의 도시', '감독','20090305');
insert into career(email,type,title,roll,date) values('ysuur223@nate.com', '영화', '레이디킬러', '감독','20040604');

insert into career(email,type,title,roll,date) values('ysung1@nate.com', '영화', '레이디킬러', '여형사역','20170802');
insert into career(email,type,title,roll,date) values('ysud1@nate.com', '영화', '레이디킬러', '남동생역','20160414');
insert into career(email,type,title,roll,date) values('ykhd1@nate.com', '영화', '레이디킬러', '경찰관역','20080215');
insert into career(email,type,title,roll,date) values('ykhd1@nate.com', '영화', '집으로', '버스기사역','20101124');
insert into career(email,type,title,roll,date) values('ykhd1@nate.com', '연극', '김종욱 찾기', '송혁진역','20130604');
insert into career(email,type,title,roll,date) values('ykhd1@nate.com', '연극', '운수좋은 날', '김첨지역','20030404');
insert into career(email,type,title,roll,date) values('ykhd1@nate.com', 'CF', 'SK브로드밴드', '남고생역','20141019');
insert into career(email,type,title,roll,date) values('ykhd1@nate.com', 'CF', '비타500', '대학생역','20110106');

insert into career(email,type,title,roll,cdate,movieno) values('ykhd1@23.com', '영화', '변호인', '대학생역','20170802',5);
insert into member(email,pw,name,mtype,sex,birth) values("ykhd1@23.com","4334","동건","배우","남","19960404");

insert into career(email,type,title,roll,cdate,movieno) values('yk1@23.com', '영화', '변호인', '감독','20170802',5);
insert into member(email,pw,name,mtype,sex,birth) values("yk1@23.com","4334","정만수","감독","남","19960404");

select * from movie;


delete from career where email = 'ykhd1@23.com';
delete from member where email='ykhd1@23.com';

delete from career where email = 'yk1@23.com';
delete from member where email='yk1@23.com';
commit;

select * from movieno_comment;

delete from movieno_comment;
delete from movie;
commit;

insert into movie(mtitle,movieimage,director,category,mdate,likeno,mcount) values('섹스앤더시티','movieimage1.jpg','ysung1223@nate.com','comedy','20170802',0,0);
insert into movie(mtitle,movieimage,director,category,mdate,likeno,mcount) values('여성이와아이들','movieimage2.jpg','ysung1223@nate.com','comedy','20170802',0,0);
insert into movie(mtitle,movieimage,director,category,mdate,likeno,mcount) values('괴물','movieimage3.jpg','ysung1223@nate.com','actionAndThriller','20170802',0,0);
insert into movie(mtitle,movieimage,director,category,mdate,likeno,mcount) values('밀정','movieimage4.jpg','ysung1223@nate.com','romance','20170802',0,0);
insert into movie(mtitle,movieimage,director,category,mdate,likeno,mcount) values('변호인','movieimage5.jpg','ysung1223@nate.com','drama','20170802',0,0);
insert into movie(mtitle,movieimage,director,category,mdate,likeno,mcount) values('택시기사','movieimage6.jpg','ysung1223@nate.com','drama','20170802',0,0);
insert into movie(mtitle,movieimage,director,category,mdate,likeno,mcount) values('아이언맨','movieimage7.jpg','ysung1223@nate.com','actionAndThriller','20170802',0,0);
insert into movie(mtitle,movieimage,director,category,mdate,likeno,mcount) values('토르','movieimage8.jpg','ysung1223@nate.com','actionAndThriller','20170802',0,0);
insert into movie(mtitle,movieimage,director,category,mdate,likeno,mcount) values('삼육대학교','movieimage9.jpg','ysung1223@nate.com','horror','20170802',0,0);

select * from movie;

insert into board(writer, btitle, bdate, btype, content,bcount) values('윤여성','테스트게시판','2017.11.06','배우구함','테스트게시판',0);
insert into board(writer, btitle, bdate, btype, content,bcount) values('윤여성','테스트게시판','2017.11.06','배우구함','테스트게시판',0);
insert into board(writer, btitle, bdate, btype, content,bcount) values('윤여성','테스트게시판','2017.11.06','배우구함','테스트게시판',0);
insert into board(writer, btitle, bdate, btype, content,bcount) values('윤여성','테스트게시판','2017.11.06','배우구함','테스트게시판',0);
insert into board(writer, btitle, bdate, btype, content,bcount) values('윤여성','테스트게시판','2017.11.06','배우구함','테스트게시판',0);
insert into board(writer, btitle, bdate, btype, content,bcount) values('윤여성','테스트게시판','2017.11.06','배우구함','테스트게시판',0);
insert into board(writer, btitle, bdate, btype, content,bcount) values('윤여성','테스트게시판','2017.11.06','배우구함','테스트게시판',0);
insert into board(writer, btitle, bdate, btype, content,bcount) values('윤여성','테스트게시판','2017.11.06','배우구함','테스트게시판',0);
insert into board(writer, btitle, bdate, btype, content,bcount) values('윤여성','테스트게시판','2017.11.06','배우구함','테스트게시판',0);
insert into board(writer, btitle, bdate, btype, content,bcount) values('윤여성','테스트게시판','2017.11.06','배우구함','테스트게시판',0);
insert into board(writer, btitle, bdate, btype, content,bcount) values('윤여성','테스트게시판','2017.11.06','배우구함','테스트게시판',0);
insert into board(writer, btitle, bdate, btype, content,bcount) values('윤여성','테스트게시판','2017.11.06','배우구함','테스트게시판',0);
insert into board(writer, btitle, bdate, btype, content,bcount) values('윤여성','테스트게시판','2017.11.06','배우구함','테스트게시판',0);
insert into board(writer, btitle, bdate, btype, content,bcount) values('윤여성','테스트게시판','2017.11.06','배우구함','테스트게시판',0);
insert into board(writer, btitle, bdate, btype, content,bcount) values('윤여성','테스트게시판','2017.11.06','배우구함','테스트게시판',0);
insert into board(writer, btitle, bdate, btype, content,bcount) values('윤여성','테스트게시판','2017.11.06','배우구함','테스트게시판',0);

select * from career;

select * from career where email = 'ykhd1@nate.com';
------------------------profile 테이블 사용x--------------------------------
CREATE TABLE profile (
	profileno int not null primary key,
	email varchar(45) not null,
	image varchar(100),
	birth varchar(15),
	height int,
	weight int,
	hobby varchar(15),
	phone varchar(20),
	foreign key (email) references member (email)
);
------------------------------------------------------------------------

select * from career where email IN (select email from member);

select * from career where email IN (select email from member where roll='감독');

select * from member where name like '%기%';

select * from member where name;

select * from member where mtype='감독';

select * from career where email in (select email from member where name like '%여%');


select * from career where title like '%킬러%' and roll='감독';


select * from member where email in (select distinct email from career where title like '%킬러%' and roll='감독');


select distinct email from career where title like '%킬러%';


select * from member where 

select * from member where email in (select distinct email from career where title like '%킬러%' and roll='감독')";


select * from movie;
update movie set youtubelink='https://www.youtube.com/embed/79B2iwpV1jA' where movieno='5';
update movie set movieinfo='“당신의 소중한 돈을 지켜드립니다”
1980년대 초 부산. 
 빽 없고, 돈 없고, 가방끈도 짧은 세무 변호사 송우석(송강호). 부동산 등기부터 세금 자문까지 남들이 뭐라든 탁월한 사업수완으로 승승장구하며 부산에서 제일 잘나가고 돈 잘 버는 변호사로 이름을 날린다. 
 대기업의 스카우트 제의까지 받으며 전국구 변호사 데뷔를 코 앞에 둔 송변. 하지만 우연히 7년 전 밥값 신세를 지며 정을 쌓은 국밥집 아들 진우(임시완)가 뜻하지 않은 사건에 휘말려 재판을 앞두고 있다는 소식을 듣는다. 국밥집 아줌마 순애(김영애)의 간절한 부탁을 외면할 수 없어 구치소 면회만이라도 도와주겠다고 나선 송변. 
 하지만 그곳에서 마주한 진우의 믿지 못할 모습에 충격을 받은 송변은 모두가 회피하기 바빴던 사건의 변호를 맡기로 결심하는데... 
 
 “제가 하께요, 변호인. 하겠습니더”' where movieno='5';
set password for 'root'@localhost = password('1116');

select mv.youtubelink,mv.movieimage,mv.movieinfo,mv.mdate,mb.mimage,mb.mtype,mb.name,c.roll from member as mb,movie as mv, career as c where mb.email=c.email and mv.movieno=c.movieno and mv.movieno=5

select * from member;
select * from career;

update board set bcount=bcount+1 where idx=
