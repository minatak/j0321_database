show tables;

-- 기본키(primary key) : 테이블을 대표하는 키, 중복을 허용하지 않는다. 기본키는 여러개가 올 수 있다. 
create table test1 (
	idx   int not null auto_increment primary key,
	name  varchar(20) not null,
	age   int default 20,
	address varchar(50)
);
desc test1;
drop table test1;
insert into test1 values(default, '홍길동', default,'서울'); -- value 뒤에 s 무조건 붙이기 (values가 맞음)
insert into test1 values(default, '김말숙', default,'청주'); -- s 안붙여도 실행이 되긴 하지만 붙이는게 좋음
insert into test1 values(1, '소나무', 55,'제주'); -- s 안붙여도 실행이 되긴 하지만 붙이는게 좋음
select * from test1;
/*
create table test2 (
	idx   int not null auto_increment primary key,
	name  varchar(20) not null,
	age   int default 20,
	test2Code varchar(10) not null,
	primary key (idx, test2Code) -- primary key를 두개 이상 만들기 위해서는 이렇게 설정할 수 있다! 그러나 사용하기 애매해서 이렇게는 잘 안씀
);
*/
create table test2 (
	idx   int not null auto_increment,
	name  varchar(20) not null,
	age   int default 20,
	test2Code varchar(10) not null,
	primary key (idx,test2Code)
);

desc test2;
drop table test2;
insert into test2 values (default, '이기자',23,'aaa');
insert into test2 values (default, '김길자',33,'bbb');
insert into test2 values(1, '소나무', 55,'ccc');
insert into test2 values(default, '소나무', 55,'ccc');
select * from test2;

-- UNIQUE KEY	: 중복불허를 위해 설정하는 키 (PRIMARY KEY를 대신해서 중복을 불허시키고자 할 때 사용한다.)
create table test3 (
	idx   int not null auto_increment,
	name  varchar(20) not null,
	age   int default 20,
	job varchar(10) not null,
	address  varchar(20) not null,
	test3Code varchar(10) not null,
	primary key (idx),
	UNIQUE KEY(test3Code)
);

desc test3;
drop table test3;
insert into test3 values (default, '소나무',12,'학생','서울','eee');
insert into test3 values (default, '대나무',45,'학생','서울','ddd');
insert into test3 values (default, '사과나무',45,'학생','서울','fff');
insert into test3 values (1,'감나무',19,'학생','fff'); -- (처음에는 되지만 이후에는 안됨)
insert into test3 values (default,'감나무',19,'eee'); -- X
select * from test3;

/*
 * 외래키(foreign key)
 	 하나의 테이블에서 다른 테이블의 정보를 찾기 위해 연결하준느 역할을 할 때 지정하는 키이다.
 	 조건: 현재 테이블에 별도의 외래키로 설정하려한다면, 반드시 상대쪽 테이블의 해당 필드는 primary key이이거나 unique key로 등록되어있어야한
 	 또한, 외래키로 지정하려는 필드는 상대쪽 테이블의 해당필드속성과 같아야한다.
 */

create table test4 (
	idx   int not null auto_increment primary key,
	gender char(2) default '남자',
	test2Idx int not null,
	test3Code varchar(10) not null,
	foreign key (test2Idx) references test2 (idx), 
	foreign key (test3Code) references test3 (test3Code)
);
desc test4;
drop table test4;
insert into test4 values (default, default,1,'ggg');
insert into test4 values (default, default,1,'ccc');
select * from test4;

-- select 필드명 from 테이블명 where 조건식 옵션;
select *,gender from test3, test4;
select test3.*,gender from test3, test4;
select test4.idx,gender from test3, test4;
select t3.idx,t4.gender from test3 as t3, test4 t4;

select t3.*,t4.gender from test3 t3, test4 t4 where t3.test3Code = t4.test3Code; -- 이렇게 만드는 join이 inner join(내부 조인) 이라고 한다!

