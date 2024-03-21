show tables;

create table test (
	idx int not null auto_increment primary key, /* 고유번호 */
	name varchar(20) not null,				-- 성명
	age int default 20,								-- 나이
	gender varchar(2) default '남자',		-- 성별
	job varchar(20) default '기타',			-- 직업
	address varchar(50)								-- 주소
);

desc test;


drop table test;
delete from test;

insert into test values (default,'홍길동',default,default,default,'서울');
insert into test values (default,'김말숙',34,'여자',default,'청주');
insert into test values (default,'이기자',52,'남자',default,'부산');
insert into test values (default,'김연아',default,'여자',default,'제주');
insert into test values (default,'손흥민',33,default,default,'서울');

insert into test values (default,'소나무',55,default,default,'제주'); -- auto increment에 숫자를 직접 적는건 정말 위험함. default 적기
insert into test values (default,'대나무',11,'여자','학생','제주');
insert into test values (default,'감나무',22,'남자','회사원','서울'); 


select * from test;

delete from test where name='손흥민';

/* 레코드 수정하기 : update 테이블명 set 필드명='수정내용' where '조건(필드명=값)'; */
update test set age=25 where name='홍길동';

-- 남자들의 나이를 1살씩 모두 더해주시오
update test set age = age+1 where gender='남자';

-- 서울에 사는 사람들만 보여주시오
select * from test where address='서울';

-- 서울과 부산에 사는 사람들을 보여주시오
select * from test where address='서울' or address='부산';

-- 나이가 30살 미만인 회원을 보여주시오
select * from test where age < 30;

-- 나이가 30살 미만인 여자회원을 보여주시오
select * from test where age < 30 and gender='여자';

-- 청주에 사는 회원 확인?
select * from test where address = '청주'; 

-- 청주에 사는 회원 삭제?
delete from test where address = '청주';

-- '청주/남자/19/강감찬' 인 회원을 등록하시오
insert into test value('강감찬',19,default,'청주');

-- 서울에 사는 '여자'회원의 나이를 2살씩 빼주시오
update test set age=age-2 where gender='여자' and address='서울'; 

-- test 테이블의 구조 보기
desc test;

-- 필드 구조변경 (alter table~~~~)
alter table --은 무조건 써야함(변경시)

-- test 테이블에 job 필드(직업명은 5글자 이내, 기본값: 기타)-컬럼(필드=컬럼)을 추가(add column)하시오
alter table test add column job varchar(6) default '기타';

-- test 테이블에 job 필드 삭제하기(drop column)
alter table test drop column job;

-- test 테이블의 job 필드 길이를 20자로 수정하시오(modify column)
alter table test modify column job varchar(20);

-- test 테이블의 name 필드명을 irum 필드로 변경하시오
alter table test change column name irum varchar(20);
alter table test change column irum name varchar(20);

-- test 테이블에 고유번호(idx)를 추가하시오 - 기본키(구분이 될 수 있는 중복을 배제한 필드) 
alter table test add column idx int not null auto_increment primary key;

-- idx=5번 삭제하시오
delete from test where idx=7;

-- 고유번호(idx) 값을 5번부터 시작하도록 설정하시오
alter table test auto_increment = 5;

