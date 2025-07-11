-------------------------- VIEW START -------------------------
/*
    [VIEW]
     - 보다란 의미를 갖고 있다.
        실제 테이블(물리테이블)에 저장된 데이터를 뷰를 통해서 볼 수 있도록 한다
        뷰는 가상 테이블이고 이는 실제 테이블과 거의 동일하게 사용함
        
    [VIEW의 사용 목적]
        1. 직접적인 테이블 접근을 제한하기 위해 사용한다.
        2. 복잡한 질의를 쉽게 만들기 위해서 사용한다.
        
    [VIEW의 특징]
        1. 뷰는 테이블에 대한 제한을 가지고 테이블의 일정한 부분만 보일 수 있는
            가상의 테이블이다.
        2. 뷰는 실제 자료를 갖지는 않지만, 뷰를 통해서 테이블을 관리할 수 있다.
        3. 하나의 테이블에 뷰의 개수는 제한이 없다.
        
    [기본 테이블] 
        1. 뷰에 의해서 제한적으로 접근해서 사용하는 실질적으로 데이터를 저장하고
            물리적인 테이블을 말한다
        
*/
select * from tab;
desc emp01;
create view view_emp10
as select empno, ename, job, deptno from emp01 where deptno=10;
drop view view_emp10;

drop table emp01;
create table emp01 as select * from emp;
select * from emp01;

select empno, ename, sal, deptno from emp01 where deptno=10;

/*  [VIEW 생성]
        - 뷰는 테이블처럼 하나의 개체로서 테이블을 생성할 때와 
             유사하게 create view 명령으로 생성한다. 
       ** CREATE [OR REPLACE] [FORCE] [NOFORCE] VIEW VIEW_NAME
            AS SUBQUERY
            WITH CHECK OPTION
            WITH READ ONLY; -- 읽기만 가능하다. 
            (*조회(SELECT)만 가능하단 뜻, insert/update/delete 명령 사용안됨)
       
       ** [OR REPLACE]
        - 새로운 뷰를 만들 수 있을 뿐만 아니라, 기존에 뷰가 존재하더라도 
            삭제하지 않고 새로운 구조의 뷰로 변경할 수 있다.
       
       ** [FORCE],[NOFORCE]
        - 기본 테이블의 존재 여부에 상관없이 뷰를 생성한다.
       
       ** [WITH CHECK OPTION]
        - 해당 뷰를 볼 수 있는 
*/

create view view_emp10
as select empno, ename, sal, deptno from emp01
where deptno=10;

select * from view_emp10;

-- 뷰를 작성할 때 기술한 서브 쿼리문이 어떻게 작성되어 있는지를 확인함
/* [USER_VIEWS -> 데이터 딕셔너리]
        - 사용자가 생성한 모든 뷰에 대한 정의 저장되어 있음
            뷰의 이름을 위한 VIEW_NAME, 서브쿼리를 확인할 수 있다.
*/

select VIEW_NAME, TEXT FROM USER_VIEWS;

/* [VIEW의 동장 원리]
    - 사용자가 뷰에 대해서 질의를 하면 user_views에서 뷰에 대한 정의를 조회한다.
    - 기본 테이블에 대한 뷰의 접근 권한 살핀다.
    - 뷰에 대한 질의를 기본 테이블에 대한 질의를 변환한다.
    - 기본 테이블에 대한 질의를 통해 데이터를 검색한다.
    - 검색 결과를 출력한다.
    
    [VIEW의 종류]
    - 단순뷰 (기본테이블이 1개)와 복합뷰 (기본테이블이 1개이상 : 최소 2개)
    ------------------------------------------------------------------------
            ** 단순 VIEW **                     ** 복합 VIEW **
          하나의 테이블로 생성                    여러개의 테이블로 생성
        그룹 함수의 사용이 불가능함               그룹함수의 사용이 가능함
        distinct 사용이 불가능 함               distinct 사용이 가능함
DML(insert/update/delete)이 사용 가능     DML(insert/update/delete)이 사용 불가능함
    ------------------------------------------------------------------------            
*/
-- 단순뷰 DML (insert/update/delete)이 사용가능
insert into view_emp10 values(8000, 'angel', 7000, 10); 
-- VIEW로 삽입하면 기본 테이블에 영향을 미친다.
DELETE FROM VIEW_EMP10 where EMPNO=8000;
select * from view_emp10; 
select * from emp01;

-- 뷰를 대상으로 실행한 DML 명령은 기본 테이블에 영향을 미친다.
-- 단순 뷰에 컬럼을 한글로 적용할 수 있다.
CREATE OR REPLACE VIEW VIEW_EMP10(사원번호, 사원명, 급여, 부서번호)
AS SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP01;    -- 한글로 분기점 넣기 쌉 가능

-- 컬럼에 별칭을 사용해서 뷰를 생성하더라도 기본테이블의 컬럼명에는 영향을 주지 못한다.
select * from emp01;

-- 복합 뷰
-- 부서별 급여 총액과 평균을 구하는 작업을 뷰로 생성해 보자.
create or replace view view_sal
as select deptno, sum(sal) 
as "SALsum", trunc(avg(SAL)) as"SALavg" from emp01 group by deptno;
select * from view_sal;

select * from emp01;
desc emp;
desc dept01;

CREATE VIEW VIEW_EMP_DEPT
AS SELECT E.EMPNO, E.ENAME, E.SAL, E.DEPTNO, D.DNAME, D.LOC
FROM EMP E, DEPT D
where e.deptno = d.deptno
order by EMPNO DESC;

SELECT * FROM VIEW_EMP_DEPT;
-- 뷰삭제
-- 뷰를 삭제하는 것은 가상 테이블이기 때문에 USER_VIEWS에 저장된 뷰의 정의를 삭제하는 것임
DROP VIEW VIEW_SAL;
SELECT VIEW_NAME, TEXT FROM USER_VIEWS;

/* 뷰 수정 : or REPLACE
        기본테이블이 없이 뷰를 생성하기 위한 force 옵션
            - 기본 테이블이 없더라도 뷰를 생성할 수 있다.
*/
select * from tab;
CREATE OR REPLACE FORCE VIEW VIEW_NOTBLE
as select empno, ename, deptno from emp20 where deptno=10;
select * from view_notable;

/*  [WITH CHECK OPTION]
        - 뷰 생성 시 조건으로 지정한 컬럼 값을 변경하지 못하도록 하는 것임
*/
CREATE OR REPLACE VIEW VIEW_CHK20
as SELECT empno, ename, sal, comm, deptno from emp01 where deptno=20 with check option;

UPDATE VIEW_CHK20 SET DEPTNO=10 WHERE SAL >= 5000;
-- 급여가 5000이상인 사원을 10번 부서로 이동하라
select * fROM view_chk20;
-- with read only : 기본 테이블이 어떤 컬럼에 대해서도 내용을 절대 변경할 수 없다.
CREATE OR REPLACE VIEW VIEW_READ30
AS SELECT EMPNO, ENAME, SAL, COMM, DEPTNO FROM EMP01 
WHERE DEPTno=30 WITH READ ONLY;
UPDATE VIEW_READ30 SET COMM=1000;

------------------------------- END VIEW ----------------------------

--------------------SEQUENCE----------------------
/* 시퀀스는 유일한 값을 생성해주는 오라클 객체다.
    시퀀스를 생성하면 기본키와 같이 순차적으로 증가하는 컬럼을 자동적으로 생성할 수 있게 한다.
    
    [시퀀스 생성 형식]
    CREATE SEQUENCE 시퀀스명
    START WITH N
    INCREMENT BY N
    MAXVLAUE N / NOMAXVALUE
    MINVALUE N / NOMINVALUE
    CYCLE / NOCYCLE
    CACHE N / NOCACHE;
    
    START WITH N
      - 시퀀스의 시작 값을 지정
    INCREMENT BY N
      - 시퀀스의 증가 값을 지정
    MAXVLAUE N / NOMAXVALUE
      - 최대 값을 지정 / 무한대로
    MINVALUE N / NOMINVALUE
      - 최소 값을 지정 / 무한 소
    CYCLE / NOCYCLE
      - 최대 값까지 증가하면 다시 최소 값부터 시작
        기본 디폴트 값은 NOCYCLE (* 지정하지 않을 경우 자동으로 됨)
    CACHE N / NOCACHE;
      - 메모리 상의 시퀀스 값을 관리
        기본 값은 20임
        원칙적으론 노 사이클이라서 관리하지 않음(NOCACHE).
*/
-- 시작 1이고, 1씩 증가, 최대 값이 100만(1,000,000)까지 되는 시퀀스를 생성하라.
CREATE SEQUENCE EMP_SEQ
START WITH 1
INCREMENT BY 1
MAXVALUE 1000000;

DROP TABLE EMP01;
CREATE TABLE EMP01
as SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE 1=0;
SELECT * FROM EMP01;
insert into emp01 values (emp_SEQ.NEXTVAL, 'JULIA', SYSDATE);
-- CURRVAL : 시퀀스의 현재값을 반환
select emp_seq.currval from dual;

-- NEXTVAL : 현재 시퀀스 값을 다음값에 반환

/*
    [CURRVAL, NEXTVAL을 사용할 수 있는 경우]
        - SUBQUERY가 아닌 SELECT문
        - INSERT 문의 SELECT 문
        - INSERT 문의 VALUES 절
        - UPDATE 문의 SET 절
    [CURRVAL, NEXTVAL을 사용할 수 없는 경우]
        - VIEW의 SELECT 절
        - DISTINCT 키워드가 있는 SELECT 절
        - GROUP BY, HAVING, ORDER BY 절이 있는 SELECT 문
        - SELECT, DELETE, UPDATE의 서브 쿼리
        - CREATE TABLE, ALTER TABLE 명령의 기본 값
    
    [시퀀스의 수정 & 삭제] 
        ** 시퀀스 수정 형식 **
        ALTER SEQUENCE 시퀀스 명
        START WITH N
        INCREMENT BY N
        MAXVALUE N / NOMAXVALUE
        MINVALUE N / NOMINVALUE
        CYCLE / NOCYCLE
        CACHE N / NOCACHE
        
    [시퀀스의 삭제]
        DROP SEQUENCE 시퀀스명;
*/
