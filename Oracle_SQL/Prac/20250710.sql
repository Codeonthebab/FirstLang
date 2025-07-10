select * from tab;
/*
    [DML]
    - 테이블에 내용을 추가, 수정, 삭제
    
    [테이블에 새로운 행을 추가하는 insert 문]
        1. 특정 컬럼에만 데이터를 입력하는 경우
            형식 : insert into 테이블명 (컬럼명1, 컬럼명2, ..컬럼명n) 
                   values (값1, 값2, .., 값n );  <<<각 컬럼명에 대응하는 값이 들어가줘야함
        
        2. 모든 컬럼에 데이터를 입력하는 경우
            형식 : insert into 테이블명 values (값1, 값2, .. 값n);

*/

-- dept01 테이블 생성
desc dept;
create table dept01 (  -- 테이블 생성
deptno number (2),
dname varchar2 (14),
loc varchar2 (13));
select * from dept01; -- 테이블 생성한거 확인
drop table dept01; -- 테이블 삭제
-- 부서번호 10, 부서이름 ACCOUNTING 지역 NEW YORK (테이블에 데이터 값 입력)
insert into dept01 values (20, 'RESEARCH', 'DALLAS'); 
insert into dept01(deptno, dname, loc) values (10, 'ACCOUNTING', 'NEW YORK');
show user;
insert into dept01 select * from dept;
delete from dept01;
insert into dept01 (deptno, dname) values (10, 'ACCOUNTING'); -- 암시적 null 값 삽입
insert into dept01 (deptno, dname, loc) values (20, 'RESEARCH', null); -- 명시적 null 값 삽입
insert into dept01 (deptno, dname, loc) values (30, 'SALES', ''); -- 명시적 null값 삽입

/*
    [테이블 내용을 수정하기 위한 update]
    ** 형식 **
        - update 테이블명 set 컬럼명 = 값, where 조건
*/

select * from emp01;
create table emp01 as select * from emp; -- 서브 쿼리를 이용해 emp테이블을 emp01로 땡겨옴

-- 모든 사원을 부서번호를 30번으로 수정하시오.
update emp01 set deptno = 30; -- 모든 데이터를 일괄 수정할 경우 조건절 생략 가능
rollback;

-- 모든 사원의 급여를 10% 올린 값으로 수정하시오
update emp01 set sal = sal*1.1;

-- 모든 사원의 입사일을 오늘로 변경하시오.
update emp01 set hiredate = sysdate;

-- 특정 행만 변경 : update 문에 where 절을 추가하면 된다
-- 부서 번호가 10번인 사원의 부서 번호를 30번으로 변경하시오.
update emp01 set deptno = 30 where deptno = 10;

-- 급여가 3000이상인 사원만 급여 인상 10프로 인상하시오.
update emp01 set sal= sal*1.1 where sal >= 3000;

-- 1987년에 입사한 사원의 입사일을 오늘로 수정하시오.
update emp01 set hiredate = sysdate where substr (hiredate, 1 , 2) = 87;

-- 테이블에서 두개 이상 수정할 때에는 콤마로 구분해서 수정한다
/*
    [테이블에서 2개 이상의 컬럼 값 변경]
        - 테이블에서 하나의 컬럼이 아닌 여러개의 컬럼값을 변경하려면
          기존 set 절에 콤마(,)를 추가하고, [컬럼 = 값]을 추가 기술하면 된다
*/
-- scott 사원의 부서번호는 10번, 직급은 manage로 변경
update emp01 set deptno = 10, job = 'MANAGE' where ename = 'SCOTT';
select * from emp01;

-- scott의 입사일을 오늘로, 급여를 50, 커미션 4000 로 변경
update emp01 set hiredate = sysdate, sal = 50, comm = 4000 where ename = 'SCOTT';

/* 
    [테이블에 불필요한 행을 삭제하기 위한 delete]
     **형식** 
        - 특정 조건으로 삭제
         delete from 테이블명 where 조건
        - 모든 데이터를 삭제
         delete from 테이블명
*/
select * from tab; -- 전체 테이블 확인
select * from dept01;
delete from dept01; -- 모든 데이터 삭제
rollback;
delete from dept01 where deptno = 30; -- 특정조건인 '부서번호 30번'만 삭제
/*   -- delete 와 truncate 명령의 차이점
    [delete]
          1. delete 명령어를 사용하여 행을 삭제할 경우 행이 많으면 
             행이 삭제될 때마다 많은 자원이 소모된다.
          2. delete 명령은 삭제 이전 상태로 원상 복구할 수 있는 경우를 생각해서
             rollback 정보를 저장하고 있기 때문임
            
    [truncate]
          1. DDL 명령문으로 rollback 할 수 없다
          2. rollback 정보를 만들지 않고 즉시 commit 하기에 빠르고
             효율적인 방법이다
*/
/*  ** 트랜잭션
    - 데이터 베이스에서 데이터를 처리하는 하나의 논리적인 작업단위를 의미
    - 트랜잭션은 insert, update, delete 명령은 메모리상에만 변경되다가
      특정단위로 하드디스크의 실제 파일인 데이터베이스에 저장되는 단위를 의미함
        
    [commit과 rollback]
    - commit : 모든 작업들을 정상적으로 처리하겠다고 확정하는 명령어로 
                트랜잭션의 처리 과정을 데이터베이스에 모두 반영하기 위해서
                변경된 내용을 모두 영구 저장한다
            ** commit 명령어를 수행하게 되면 하나의 트랜잭션 과정이 종료됨 **
        
    - rollback : 작업 중 문제가 발생되어서 트랜잭션 처리 과정에서 변경된 사항을 취소하는 명령어
            ** rollback 명령어 역시 트랜잭션과 과정을 종료하게 된다 **
            ** rollback은 트랜잭션으로 인한 하나의 묶음 처리가 시작되기 이전 상태로 되돌림 **
                    여러 DNL 명령어들은 하나의 논리적인 작업단위인 트랜잭션으로 묶을 수 있음
                    마지막으로 실행한 커밋 명령 이후부터 새로운 커밋 명령을 실행하는 시점까지
                    수행된 모든 DML 명령어를 의미한다
                    
    장점
    1. 데이터의 무결성을 보장한다.
    2. 영구적으인 변경 전에 데이터의 변경사항을 확인 할 수 있다
    3. 논리적으로 연관된 작업을 고룹화할 수 있다
    
    ** rollback 명령어는 이전 commit한 곳까지만 복구된다 **
    
    - 자돟 commit 명령과 자동 rollback 명령이 되는 경우
        SQL PLUS가 정상적으로 종료되면 자동으로 commit되고
        비정상적으로 종료되면 자동으로 rollback 됨    
*/

drop table dept01; -- dept01 테이블 삭제
create table dept01 -- dept 새로운 테이블 제작
as select * from dept;
select * from dept01;
delete from dept01;
select * from dept01;
rollback;
select * from dept01;

-- 부서번호 20번 사원에 대한 정보만 삭제
delete from dept01 where deptno=20;
select * from dept01;
commit;
rollback;

-- 커밋 이후에는 rollback 명령어는 아무 소용이 없다.
/*
    [무결성 제약 조건의 개념과 종류]
        - 무결성 계약 조건은 데이터를 추가, 수정, 삭제하는 과정에서 
            무결성을 유지할 수 있도록 제약을 주는 것을 말한다
        - 무결성이란 데이터베이스 내에 데이터의 확장성을 유지하는 것을 의미하고
            제약조건이란 바람직하지 않은 데이터가 저장되는 것을 방지 하는 것을 말함
    
    [무결성 제약]
        ** not null : null을 허용하지 않는다
        ** unique : 중복된 값을 허용하지 않는다, 항상 유일한 값을 갖도록 한다
        ** primary key : not null 과 unique가 결합이 된 형태
                            즉, null도 허용X, 중복된 값x
        ** foreign key : 참조되는 테이블의 컬럼의 값이 존재하면 허용
        ** check : 저장 가능한 데이터의 값의 범위나 조건을 지정하여 설정한 값만을 허용        
*/
-- not null 제약조건
drop table emp01;
-- 사원명, 사원번호, 직급, 부서번호로 구성된 제약조건이 없는 emp01 테이블을 생성
create table emp01 (
empno number (4),
ename varchar2 (10),
job varchar2 (9),
deptno number (2)
);
insert into emp01 values (null, null, 'SALESMAN', 30);
select * from emp01;
drop table emp02;
create table emp02 (
empno number (4) not null,
ename varchar2 (10) not null,
job varchar2 (9) ,
deptno number (2)
);
insert into emp02 values (null, null, 'SALESMAN', 30); --위쪽 테이블 조건에 not null이 포함되었기 때문에 삽입(insert) 안됌
insert into emp02 values (7399, 'RINOUE', 'SALESMAN', 30);
select * from emp02;

create table emp03 (
empno number (4) unique, -- 중복 허용하지 않곘다는 뜻
ename varchar2 (10) not null,
job varchar2 (9) ,
deptno number (2)
);
insert into emp03 values (7399, 'RINOUE', 'SALESMAN', 30);

create table emp04 (
empno number (4) unique not null, -- 중복 허용하지 않음, null 값도 허용하지 않음
ename varchar2 (10) not null,
job varchar2 (9) ,
deptno number (2)
);
insert into emp04 values (7399, 'RINOUE', 'SALESMAN', 30);
insert into emp04 values (null, 'RINOUE', 'SALESMAN', 30);

create table emp05 (
empno number (4) primary key, -- not null + Unique
ename varchar2 (10) not null,
job varchar2 (9) ,
deptno number (2)
);
insert into emp05 values (7399, 'RINOUE', 'SALESMAN', 30);
insert into emp05 values (null, 'RINOUE', 'SALESMAN', 30);

/* [제약조건 확인]
    제약조건 (constraints)의 에러 메세지에 대한 정확한 원인을 알기 위해서
    오라클에서 제공해주는 user_constraints 데이터 딕셔너리가 있다
    제약 조건명, 제약조건유형, 제약조건이 속한 테이블명
*/
-- 제약 조건 확인
select constraint_name, constraint_type, table_name from user_constraints where table_name = 'EMP05';
/*
    [constraint_type은 P, R, U, C 4가지가 있음
    P : primary key
    R : foreign key
    U : Unique
    C : check not null
*/
-- 제약 조건이 지정된 컬럼명으로 확인
select * from user_cons_columns where table_name = 'EMP05';

desc dept;
drop table dept01;
create table dept01 (
deptno number (2) not null,
dname varchar2 (14),
loc varchar2 (13));

desc dept01;
select * from dept01;
insert into dept01 values(10, 'ACCOUNTING', 'NEW YORK');
insert into dept01 values(20, 'RESEARCH', 'DALLAS');
insert into dept01 values(30, 'SALES', 'CHICAGO');
insert into dept01 values(40, 'OPERATIONS', 'BOSTON');
commit;

drop table emp05; -- 테이블 삭제
-- Emp01 오류 찾기
SELECT deptno, COUNT(*)  -- dept01 테이블의 추가된 카운트 수 확인
FROM dept01
GROUP BY deptno
HAVING COUNT(*) > 1;

DELETE FROM dept01 a  -- dept01 테이블의 모든 행 삭제
 WHERE a.rowid > (
    SELECT MIN(b.rowid)
      FROM dept01 b
     WHERE a.deptno = b.deptno
);

ALTER TABLE dept01
ADD CONSTRAINT pk_dept01 PRIMARY KEY (deptno);
commit;
-------------------------------
create table emp05 (
empno number (4) primary key,
ename varchar2(10) not null,
job varchar2 (9),
deptno number (4) references dept01 (deptno)
);

insert into emp05 values(7499, 'ALLEN', 'SALESMAN', 50);
-- 부모 테이블에 50번인 부서번호가 존재하지 않기 때문에 안됌
insert into emp05 values(7499, 'ALLEN', 'SALESMAN', 30);
select * from emp05;
select constraint_name, constraint_type, table_name, r_constraint_name from user_constraints where table_name = 'EMP05';

/* check 제약 조건
    - 입력되는 값을 체크하여 설정된 값 이외의 값이 들어오면 오류메세지와 함께 수행을 못한다.
    */
    create table emp06 (
    empno number (4) primary key,
    ename varchar2 (10) not null,
    gender varchar2 (1) check (gender in ('M', 'F'))
    );
    
    insert into emp06 values(7555, 'JONES', 'M');
    select * from emp06;
    
    select constraint_name, constraint_type, table_name, search_condition
    from user_constraints where table_name = 'EMP06';
    
/* 
    [제약 조건명 지정]
      **제약 조건명 명명규칙**
       [테이블]_[컬럼명]_[제약조건유형]
        ex) EMP06_EMPNO_PK
                
*/
drop table emp05;
create table emp05 (
empno number (4) constraint EMP05_EMPNO_PK primary key,
ename varchar2(10) constraint EMP05_ENAME_NN not null,
job varchar2 (9) constraint EMP05_JOB_UK UNIQUE,
deptno number (4) constraint EMP05_DEPTNO_FK references dept01 (deptno)
);

insert into emp05 values(7499, 'ALLEN', 'SALESMAN', 30);
SELECT * FROM EMP05;
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, R_CONSTRAINT_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'EMP05';