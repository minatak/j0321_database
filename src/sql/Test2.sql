show tables;

create table insarok (
	idx    int not null auto_increment primary key, /* 고유번호 */ 
	buser  varchar(10) not null, 										/* 부서명 */
	name   varchar(20) not null, 										/* 부서원(성명) */
	jikwi  varchar(10) not null, 										/* 직위 */
	gender char(2) not null default '남자', 					/* 성별 */
	age    int default 25,							  					/* 나이 */
	ipsail datetime not null default now(), 				/* 입사일(기본값:오늘날짜) */
	address varchar(50)
	/* primary key (idx) */
);
desc insarok;
-- drop table insarok;

insert into insarok values (default,'인사과', '홍길동','과장',default,38,'1993-1-5','서울');
insert into insarok values (default,'총무과', '김말숙','부장',default,38,'1992-12-5','청주');
insert into insarok values (default,'영업과', '이기자','사장',default,30,'1995-11-5','인천');
insert into insarok values (default,'자재과', '강감찬','대리',default,40,'1997-2-5','서울');
insert into insarok values (default,'인사과', '소나무','과장',default,28,'1995-5-25','부산');
insert into insarok values (default,'총무과', '대나무','사원',default,38,'1992-1-12','서울');
insert into insarok values (default,'인사과', '탁민아','과장',default,45,'1995-3-15','인천');
insert into insarok values (default,'영업과', '이규희','사원',default,31,'2000-1-25','서울');
insert into insarok values (default,'총무과', '김기자','사원',default,26,'2013-1-5','부산');
insert into insarok values (default,'인사과', '이순신','사원',default,40,'1998-1-31','서울');
insert into insarok values (default,'영업과', '고인돌','사원',default,44,'1987-9-7','청주');
insert into insarok values (default,'인사과', '가나다','사원',default,30,'1995-8-25','부산');
insert into insarok values (default,'영업과', '최민영','대리',default,58,'1998-12-24','청주');
insert into insarok values (default,'영업과', '조현서','부장',default,62,'2005-11-3','청주');
insert into insarok values (default,'영업과', '나다라','부장',default,38,'2004-6-4','부산');
insert into insarok values (default,'영업과', '이규혁','대리',default,29,'2006-6-7','서울');
insert into insarok values (default,'자재과', '조현서','과장',default,35,'1993-8-3','인천');
insert into insarok values (default,'인사과', '홍길자','과장',default,20,'1994-5-28','청주');
insert into insarok values (default,'자재과', '손흥민','사원',default,20,'1995-7-17','제주');
insert into insarok values (default,'총무과', '오하늘','대리',default,50,'1996-1-5','대전');
insert into insarok values (default,'인사과', '홍길동','과장',default,47,'1997-9-5','인천');

select * from insarok;

-- insarok 테이블의 성명/직위/주소 필드만 모든 자료 표시
select name,jikwi,address from insarok;

-- 홍길동 레코드만 출력
select * from insarok where name='홍길동';

-- 서울에 사는 홍길동 레코드만 출력
select * from insarok where address='서울' and name='홍길동';

-- 홍길동 사원만 출력
select * from insarok where jikwi='사원' and name='홍길동';

-- '서울'에 사는 모든 사람
select * from insarok where address='서울';

-- 서울에 살지 않는 직원
select * from insarok where address != '서울';
select * from insarok where address <> '서울';

-- 입사년도가 2000년 이전에 입사한 직원을 보여주시오
select * from insarok where ipsail < '2000-1-1';

-- 입사년도가 2000~2010년에 입사한 직원을 보여주시오
select * from insarok where ipsail >= '2000-1-1' and ipsail <= '2010-12-31';
-- ㄴ 앞의 범위 연산자 대신 between~and 변경가능
select * from insarok where ipsail between '2000-1-1' and '2010-12-31';

-- 30대 회사원을 출력
select * from insarok where age >= 30 and age <= 39;
select * from insarok where age between 30 and 39;

-- 서울/부산에 사는 직원
select * from insarok where address = '서울' or address='부산';
-- 앞의 or 연산자는 in()으로 변경가능
select * from insarok where address in('서울','부산');

-- 서울/부산에 사는 사원
select * from insarok where jikwi='사원' and address in('서울','부산');

-- '김'씨만 출력
select * from insarok where name like '홍%';

-- '나무'로 끝나는 직원 출력
select * from insarok where name like '%나무';

-- '이규혁'을 '이재혁'으로 이름을 바꾸면?
update insarok set name ='이재혁' where name = '이규혁';
update insarok set name ='가재' where name='가나다';

-- 이름중에 '재'란 글자를 포함한 직원의 직급을 '과장'으로 변경하시오
select * from insarok where name like "%재%";
update insarok set jikwi='과장' where name like "%재%";

-- 이름 중 두번째 글자가 '나'인 직원은?
select * from insarok where name like '_나%';

-- 이름중에 '재'란 글자를 포함한 직원 중 '서울'에 사는 직원의 이름과 입사일, 주소
select name,ipsail,address from insarok where name like '%재%' and address='서울';

-- 이름중에 '재'란 글자를 포함한 직원 중에서 '서울'에 사는 직원중 나이가 40 이상인 직원을 퇴사시키시오
select * from insarok where name like '%재%' and address='서울';
delete from insarok where name like '%재%' and address='서울' and age >= 40;

-- 이름 오름차순으로 출력하시오 (순서: order by ~~, 오름차순: asc(생략가능), 내림차순: desc)
select * from insarok order by name;
select * from insarok order by name desc;

-- 남자인 자료중에서 나이 오름차순으로 출력
select * from insarok where gender='남자' order by age;

-- 남자인 자료중에서 나이 오름차순으로, 같은 나이면 입사일 내림차순으로 출력
select * from insarok where gender='남자' order by age, ipsail desc;

-- '이재희'의 성별을 '여자'로 변경
update insarok set gender='여자' where name='이규희' or name='탁민아';

-- 전체 자료중 5명만 출력하시오 (입력 순서중 앞에서 5개)
select * from insarok limit 5;

-- 전체 자료중 뒤에서(나중에 입력한 순서로) 5명만 출력하시오 
select * from insarok order by idx desc limit 5;

-- 남자회원 5명만 나이 내림차순으로 보여주시오 (limit 출력갯수)
select * from insarok where gender='남자' order by age desc limit 5;

-- 남자회원중에서 앞에서 2명을 빼고, 5명만 출력하시오 (limit 인덱스번호, 출력갯수)
select * from insarok where gender='남자' order by idx limit 2,5;
