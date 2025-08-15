create table tempmember (
id	varchar2 (20) not null,
password varchar2 (20) not null,
name varchar2 (20) not null,
men_num1 varchar2 (6) not null,
men_num2 varchar2 (7) not null,
e_mail varchar2 (30) not null,
phone varchar2 (30) not null,
zipcode varchar2 (7) not null,
address varchar2 (60) not null,
job varchar2 (30) not null,
primary key (id)
);

select * from tempmember;
select * from tempmember;
insert into tempmember values ('aaaa', '1111', '미스타홍', '000301', '2010101', 'Mshong@naver.com', '02-0000-1234', '100-100', '서울특별시 영등포구 영등포동 신안빌딩', '개백수')
insert into tempmember values ('bbbb', '2222', '미스타홍', '000401', '1010101', 'Mrhong@naver.com', '02-3442-1334', '133-120', '서울특별시 강서구 공항동 백정빌딩', '개백정')
insert into tempmember values ('cccc', '3333', '갓물주', '900401', '2313131', 'okanemana@naver.com', '02-7632-3333', '122-111', '서울특별시 강남구 압구정동 압구정현대', '건물주')