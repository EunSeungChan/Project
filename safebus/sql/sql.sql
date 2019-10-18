drop table userinfo cascade CONSTRAINT;

drop table userinfo;
create table userinfo (
	userid    varchar2(15) primary key,
	username   varchar2(20),
	userpwd    varchar2(10),
	email      varchar2(50),
	phone      varchar2(15),
	address    varchar2(100),
	img        varchar2(200)

);
insert into userinfo (userid, username, userpwd, email, phone, address)
values ('admin', '관리자', 'a1234', 'admin@multicampus.co.kr', '02-1234', '서울 역삼');

insert into userinfo (userid, username, userpwd) values ('user01', '길동이', '1234');
commit;

add = "insert into userinfo (userid, username, userpwd, email, 
                                 phone,address) values (?, ?, ?, ?, ?, ?)";

login = "select * from userinfo where userid=? and userpwd = ?";

user1 = "select * from userinfo where userid = ?";

list = "select * from userinfo ";

update ="update userinfo set email=?,phone=?,address=? where userid =?";

delete = "delete from userinfo where  userid  = ? ";

sql1 = "select * from userinfo where "+condition +" like '%'||?||'%'";



select * from (select rownum row#,ename,job,sal 
from (select * from emp order by sal desc)
)where row#  between 5 and 9;





board 테이블 생성   p111
drop table board;
create table board(
     seq         number(5) primary key,
     title       varchar2(100) not null,
     writer      varchar2(30) not null,
     content     varchar2(2000) not null,
     regdate     date  default sysdate,
     cnt         number(5) default 0,
     userid      varchar2(15),
     constraint board_userid_fk FOREIGN KEY(userid) REFERENCES userinfo(userid)
);

insert into board values(1,'연습용01','나그네','.... 잘보고갑니다.',sysdate,default,'java01');

insert into board (seq,title,writer,content,userid)
    values((select nvl(max(seq),0)+1 from board),'연습용01','나그네','.... 잘보고갑니다.','java01');

select * from board;
commit;



users 테이블 생성
drop table users cascade CONSTRAINT;
create table users(
     id         varchar2(8) primary key,
     name       varchar2(20) not null,
     pw       varchar2(8) not null,
     role          varchar2(5) default 'User'
);

insert into users values('java01','홍길동','1234',default);
insert into users (id,pw,name) values('java02','1234','고길동');
commit;


