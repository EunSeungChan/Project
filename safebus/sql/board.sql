drop table board;
drop table users;

create table users (
     id         varchar2(8) primary key,        
     password   varchar2(8) not null,  
     name       varchar2(20) not null,   
     role       varchar2(5) default 'user' 
);

create table board (
     seq       number(5)    primary key,   
     title     varchar2(100) not null,    
     content   varchar2(2000) not null,     
     regdate   date         default sysdate,  
     cnt       number(5)   default 0, 
     id       varchar2(8)  references users
);


회원등록
insert into users (id,password,name) values('','','');
insert into users (id,password,name) values('java01','1234','홍길동');
insert into users (id,password,name) values('java02','1234','아무개');

insert into users (id,password,name,role) 
  values('admin','1234','admin','admin');
commit;


게시판 글등록

insert into board (seq,title,content,regdate,cnt,id) 
values((select nvl(max(seq),0)+1 from board),
              '공지사항','~~~',default,default,'admin');

insert into board (seq,title,content,id) 
values((select nvl(max(seq),0)+1 from board),'공지사항','~~~','admin');

insert into board (seq,title,content,id) 
values((select nvl(max(seq),0)+1 from board),'연습용1','~~~','java01');

insert into board (seq,title,content,id) 
values((select nvl(max(seq),0)+1 from board),'연습용2','~~~','java01');


select * from board;

select * from board where id='java01';

select * from board where seq=1;

select to_char(regdate,'mm'),count(*) 
from board group by to_char(regdate,'mm');

글삭제


로그인 
select * from users where id='' and password='';
select * from users where id='java01' and password='1234';
select * from users where id='java01' and password='0000';
select * from users where id='admin' and password='1234';

/* 로그인 */

select nvl(nvl2(id,'성공',null),'실패') as "로그인 여부"
from users right join dual 
on id ='java' and password = 'java01';

select nvl(nvl2(id,'성공',null),'실패') as "로그인 여부"
from users right join dual
on id ='java' and password = 'java02';

/* 글 수정 */
update board set content = 'jsp jps jspsdpf sjp', title ='jsp' where seq = 4;
/* 글 삭제 */
delete from board where title is null;
/* 데이터검색 */
select * from board 
where (lower(title) like lower('%PO%'))
or (lower(content) like lower('%PO%'));


/* 회원정보 수정 */
update users set role = 'user';
update users set role = 'admin' where id='java';

drop table book;
create table book(
   bookno number(5) ,
   title  varchar2(12),
   author varchar2(12),
   price number(5)  check(price>0),
   pubdate date default sysdate
);
alter table book add CONSTRAINT book_bookno_pk primary key(bookno);
alter table book drop constraint book_bookno_pk;

drop table b;
create table b(
   bookno int ,
   title  char(20)
);

select * from (select rownum row#,ename,job,sal 
from (select * from emp order by sal desc)
)where row#  between 5 and 9;


