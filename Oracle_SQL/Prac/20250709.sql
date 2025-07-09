-------subQuery-------
/*
    [서브 쿼리]
        - 두 개 이상의 테이블의 정보가 필요할 경우 서브쿼리를 이용한다.
    ++ 개념
        - 하나의 select 문장의 절 안에 또 하나의 select 문장을 포함하고 있는 것
        - 단일행 서브쿼리, 다중행 서브쿼리
        
        **단일행 서브쿼리
            - 단일행 서브쿼리는 내부 select 문장으로부터 오직 하나의 행만을 반환하는 것을 의미함
            - 단일행 비교연산자 (* =, >, >=, <, <=, <> )
        
        **다중행 서브쿼리
            - 서브쿼리에서 반환되는 결과가 하나 이상의 행일때 사용하는 쿼리
            - 다중행 서브쿼리는 다중행 연산자를 이용해야한다
            - 단일행 연산자 (*IN, ANY, SOME, ALL, EXIST)
                **IN** 메인쿼리의 비교조건이 서브쿼리의 결과 중 하나라도 일치하면 참을 반환
                **ANY, SOME** 메인쿼리의 비교조건이 서브쿼리의 검색 결과와 하나 이상을 일치하면 참을 반환
                **ALL** 메인쿼리의 비교조건이 서브쿼리의 검색 결과와 모든 값이 일치하면 참을 반환
                **EXIST** 메인쿼리의 비교조건이 서브쿼리의 결과 중에서 만족하는 값이 하나라도 존재하면 참을 반환
                
*/

select deptno from emp where ename= 'SCOTT';
select dname from dept where deptno = 20;
select dname from dept where deptno = (select deptno from emp where ename = 'SCOTT');
--    메인 쿼리                                서브 쿼리
-- 서브 쿼리는 비교 연산자의 오른쪽에 기술해야 하며, 반드시 괄호 안에 둘러싸여야한다.
-- 서브 쿼리는 메인 쿼리가 실행되기 전에 한번만 실행된다.
-- SMITH와 같은 부서에서 근무하는 사원의 모든 정보를 출력하시오.

select deptno from emp where ename = 'SMITH';
select * from emp;
select * from emp where deptno = (select deptno from emp where ename = 'SMITH');

-- 평균 급여보다 더 많은 급여를 받는 사원을 검색하여 이름, 급여를 출력하시오.
select TRUNC(avg(sal)) from emp;
select ename, sal from emp;
select ename, sal from emp where sal > (select TRUNC(avg(sal)) from emp);

-------------- 다중 행 서브쿼리
-- 급여를 3000이상 받는 사원이 소속된 부서와 동일한 부서에서 근무하는 사원을 출력하라
select distinct (deptno) from emp where sal >= 3000;
select ename,sal, deptno from emp where deptno in (select distinct (deptno) from emp where sal >= 3000);

-- all : 메인 쿼리의 비교 조건이 서브쿼리의 검색결과 모두 일치하면 참
-- 30번 소속 사원들 중에서 급여를 가장 많이 받은 사원보다 
-- 더 많은 급여를 받는 사원의 이름, 급여를 출력하라.
select Sal from emp where deptno = 30;
select ename, sal from emp where sal > ALL (select max (Sal) from emp where deptno = 30);

-- any : 메인쿼리의 비교조건이 서브쿼리의 검색결과와 하나 이상만 일치하면 참
-- 부서번호가 30번인 사원들의 급여 중 가장 작은 값보다 많은 급여를 받는 사원의 이름, 급여를 출력하라.
select min (sal) from emp where deptno = 30;
select ename, sal from emp where sal > any (select sal from emp where deptno = 30);

/*null
    아래의 모든 문제를 서브 쿼리를 활용하여 작성하시오.
    1. SCOTT의 급여와 동일하거나 더 많이 받는 사원명과 급여를 출력하시오.
    2. 직급(JOB)이 사원(CLARK)인 사람의 부서의 부서번호와 부서명과 지역을 출력하시오.
    3. 이름에 T를 포함하고 있는 사원들과 같은 부서에서 근무하고 있는 사원의 번호와 이름을 출력하시오.
    4. 부서의 위치가 DALLAS인 모든 사원의 이름, 부서 번호를 출력하시오.
    5. SALES 부서의 모든 사원의 이름과 급여를 출력하시오.
    6. KING 에게 보고하는 모든 사원의 이름과 급여를 출력하시오.
       즉, KING에게 보고하는 사원(MGR＝KING)인 사원을 의미한다.
    7. 자신의 급여가 평균 급여보다 많고, 이름에 S가 들어가는 사원과 동일한 부서에 
       근무하는 사원의 사원번호, 이름, 급여를 출력하라.
*/

-- 1. SCOTT의 급여와 동일하거나 더 많이 받는 사원명과 급여를 출력하시오.
SELECT ENAME, SAL FROM EMP 
WHERE SAL >= (SELECT SAL FROM EMP WHERE ENAME = 'SCOTT');

-- 2. 직급(JOB)이 사원(CLARK)인 사람의 부서의 부서번호와 부서명과 지역을 출력하시오.
SELECT DEPTNO, DNAME, LOC
FROM DEPT
WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB = 'CLERK');

-- 3. 이름에 T를 포함하고 있는 사원들과 같은 부서에서 근무하고 있는 사원의 번호와 이름을 출력하시오.
SELECT DISTINCT(DEPTNO) FROM EMP WHERE ENAME LIKE '%T%';
SELECT EMPNO, ENAME FROM EMP WHERE DEPTNO 
IN (SELECT DISTINCT(DEPTNO) FROM EMP WHERE ENAME LIKE '%T%');

-- 4. 부서의 위치가 DALLAS인 모든 사원의 이름, 부서 번호를 출력하시오.
SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS';
SELECT ENAME, DEPTNO FROM EMP WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS');

-- 5. SALES 부서의 모든 사원의 이름과 급여를 출력하시오.
SELECT DEPTNO FROM DEPT WHERE DNAME = 'SALES';
SELECT ENAME, SAL FROM EMP WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = 'SALES');

-- 6. KING 에게 보고하는 모든 사원의 이름과 급여를 출력하시오.
SELECT EMPNO FROM EMP WHERE ENAME = 'KING';
SELECT ENAME, SAL, MGR FROM EMP WHERE MGR IN (SELECT EMPNO FROM EMP WHERE ENAME = 'KING');

-- 7. 자신의 급여가 평균 급여보다 많고, 이름에 S가 들어가는 사원과 동일한 부서에 
--       근무하는 사원의 사원번호, 이름, 급여를 출력하라.
SELECT TRUNC(AVG(SAL)) FROM EMP;
SELECT DISTINCT (DEPTNO) FROM EMP WHERE SAL>2073;
SELECT ENAME FROM EMP WHERE ENAME LIKE '%S%';

SELECT EMPNO, ENAME, SAL FROM EMP WHERE DEPTNO IN
(SELECT DISTINCT (DEPTNO) FROM EMP WHERE SAL> (SELECT TRUNC(AVG(SAL))
FROM EMP) AND ENAME LIKE '%S%');

---------------------END SUBQUERY--------------------
/*
    [새로운 테이블을 생성]
    = 형식 =
    CREATE TABLE 테이블명 (
    컬럼명  자료형 (크기) 제약조건,
    컬럼명  자료형 (크기),
    컬럼명  자료형 (크기),
    컬럼명  자료형 (크기),
    );
    
    테이블 생성 : CREATE
    테이블 변경 : ALTER
    테이블 삭제 : DROP
    테이블 이름 변경 : RENAME
    
    [테이블 자료형]
    CHAR => 2000BYTE 까지
    VARCHAR2 => 4000BYTE 까지
    NUMBER => 최소가 4BYTE
    NUMBER(크기), NUMBER (W, D)  7, 2(*7번째 열에서 2번째 행에 넣는다)
    DATA, BLOB(바이너리 데이터 저장), CLOB(텍스트 데이터 저장)
        (**TIMESTAMP (DATE) 형** 일반 DATE보다 많이 씀)
    ROWID : 테이블에서 행의 위치를 지정한 논리 주소 값
    
    [테이블 명과 컬럼 명을 부여하기 위한 규칙]
    1. 반드시 문자로 시작해야한다.
    2. 1~30자까지 가능하다
    3. A~Z 까지의 대소문자, 0 ~ 9의 숫자, 특수문자 (_,#, $)만 가능하다
    4. 예약어는 사용 불가하다.
    5. 공백은 허용불가
*/

-- 사원번호, 사원명, 급여 3개의 컬럼으로 구성된 EMP01 테이블을 생성하라.
CREATE TABLE EMP01 (
    EMPNO NUMBER(4),
    ENAME VARCHAR2 (20),
    SAL NUMBER (7,2)    
    );
-- DROP TABLE EMP01; 테이블 삭제 가능
SELECT * FROM TAB;
DESC EMP01; --구조 보는 코드
DESC EMP; --
SELECT * FROM EMP01;
CREATE TABLE EMP02 AS SELECT * FROM EMP;

DESC EMP;
DESC EMP01;

/* 
    ALTER TABLE 로 테이블 구조 변경
    ALTER TABLE 명령어는 테이블에서 컬럼의 추가, 삭제, 컬럼의 타입이나 길이를 변경할 때 사용함
    ADD COLUMN : 새로운 컬럼 추가
    MODIFY COLUMN : 기존 컬럼을 변경
        [주의사항] 
            1. 해당 컬럼에 자료가 없는 경우
              - 컬럼의 데이터 타입을 변경할 수 있다.
              - 컬럼의 크기를 변경할 수 있다.
            2. 해당 컬럼에 자료가 있는 경우
              - 컬럼의 데이터 타입을 변경할 수 없다.
              - 컬럼의 크기는 늘릴 수는 있지만 현재 가지고 있는 크기보다 작게 변경할 수 없다
    DROP COLUMN : 기존 컬럼을 삭제
    */
ALTER TABLE EMP01;
MODIFY (JOB VARCHAR2(30));
DESC EMP01;
ALTER TABLE EMP01
DROP COLUMN JOB;

DROP TABLE EMP01;
DROP TABLE EMP02;

ALTER TABLE EMP01
ADD (job VARCHAR2 (9));

SELECT * FROM TAB;

-- 휴지통 보기
SELECT * FROM RECYCLEBIN;
DESC RECYCLEBIN;

-- 휴지통 비우기
PURGE RECYCLEBIN;

CREATE TABLE EMP01 AS SELECT * FROM EMP;

-- 휴지통에 넣지 않고 바로 삭제
DROP TABLE EMP01 PURGE;

RENAME EMP01 TO EMP02;
SELECT * FROM EMP02;
DELETE FROM EMP02;
ROLLBACK;
TRUNCATE TABLE EMP02;
ROLLBACK;