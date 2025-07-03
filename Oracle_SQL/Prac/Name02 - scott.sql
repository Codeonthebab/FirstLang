select * from tab;
desc emp; -- 테이블 구조 확인
select * from emp; -- emp 테이블을 모든 사원을 검색하라
select * from dept;
desc dept;
/*보고 싶은 특정만 검색할때, from 다음엔 열 이름이 나와야함*/
select empno, ename from emp where deptno=20;
select * from emp order by empno desc; -- emp 테이블을 모든 사원 번호를 기준으로 내림차순 검색하라
desc dept;
/*
    select
    - 테이터를 조회하기 위한 dml
    - 형식
     select 열이름 or 컬럼명 from 테이블명;
*/ 
select * from tab; -- 현재 데이터베이스에 저장된 테이블을 출력하라 는 명령
show user;
-- dept 테이블의 모든 내용을 출력하시오.
select * from dept; -- 모든 내용 출력
select * from emp;

-- 컬럼 이름에 별칭 지정하기
-- 컬럼을 기술한 다음에 as라는 키워드를 쓴 후에 별칭을 기술
-- 별칭을 부여할 때 공백 문자, $._. # 특수 문자를 표현하고 싶거나 대소문자를 구별하고 싶은 경우
-- 더블 쿼터(" ")를 사용한다. as를 생략하고 " " 만 기입
select deptno as departmentNo, dname as departmentName from dept;
select deptno departmentNo, dname departmentName from dept;
select deptno "departmentNo", dname "departmentName" from dept;
select deptno "$no", dname "$name" from dept;
select deptno "부서번호", dname "부서이름" from dept;

/*
중복된 데이터를 한번만 출력하는 명령어
distinct
ex) emp 테이블에서 컬럼 job(*직책)을 표시하되 중복된 값일 경우 한번만 출력하시오.
*/

select distinct job from emp;

/*
    where 조건절과 비교연산자
    
    비교연산자
    =, >, <, >=, <=, [<>, !=, ^= (*같지 않다. 표기)]
*/
select * from emp;
-- 급여를 3000이상 받는 사원을 출력하라. (*쿼리문 작성해서 풀수있음) 
select empno, ename, sal from emp where sal >= 3000;
-- 급여를 3000미만인 사원을 출력하라. (*쿼리문 작성해서 풀수있음) 
select empno, ename, sal from emp where sal < 3000;

-- 사원테이블 중에서 부서번호가 10번인 사원을 모든 정보를 출력하시오.
select * from emp where deptno = 10;
-- 사원테이블에서 급여가 2000미만이 되는 사원의 정보 중 사원번호, 이름, 급여를 출력하시오.
select empno, ename, sal from emp where sal < 2000;
/*
    [문자 데이터 조회]
  - 문자 데이터는 반드시 싱클 쿼터 안에 표시해야 함. 
  - 대소문자는 반드시 구분해야함
    [Ex]
  - 이름이 scott인 사원에 대하여 사원번호, 사원이름, 급여를 출력하시오.
*/
select empno, ename, sal from emp where ename = 'SCOTT';
-- 이름이 MILLER 인 사원의 대하여 사원번호, 사원이름, 급여를 출력하시오.
select empno, ename, sal from emp where ename = 'MILLER';

/*
    [날짜 데이터 조회]
    - 반드시 싱글 쿼터 안에 표시해야한다. 형식은 '년/월/일' 형식으로 기술함
    [EX]
    - 1985년 이후에 입사한 사원에 사원이름과 입사일을 출력하라.
    select ename, hiredate from emp where hiredate >= '85/01/01';
*/
select ename, hiredate from emp where hiredate >= '1985/01/01';

/*
    [논리 연산자]
    - and : 두 조건을 모두 만족해야함
    - or : 두 조건 중 하나만 만족하면 됨
    - not : 조건에 만족하지 못하는 것
*/
-- and 연산자는 여러 조건을 만족해야하는 경우 사용한다
--  부서 번호가 10번이고, 직급이 Manager인 사원의 이름, 번호, 직급을 출력하시오.
select empno, ename, job from emp where deptno = 10 and job = 'MANAGER';
-- 급여가 1000에서 3000사이에 있는 사원 출력
select empno, ename, job from emp where SAL >= 1000 and SAL <= 3000;
/*
    between and 연산자
    - 특정 범위 내에 속하는 데이터를 알아보려고 할 때 사용하는 연산자
        형식 : 컬럼명 between 시작 and 종료
*/
-- 급여가 1000에서 3000사이에 있는 사원 출력
select empno, ename, SAL from emp where SAL between 1000 and 3000;

-- or 연산자 : 두 조건 중 한가지라도 만족한 경우에 사용함
-- 부서번호가 10번이거나 직급이 MANAGER 인 사원을 이름, 번호, 직급을 출력하라.
select empno, ename,deptno,job from emp where deptno = 10 or job = 'MANAGER';
-- 사원번호가 7844이거나 7654이거나 7521인 사원을 이름, 번호, 직급을 출력하라.
select empno, ename, job from emp where empno = 7844 or empno = 7654 or empno = 7521;

/*
    in 연산자 : 동일한 컬럼이 여러 개의 값 중, 하나인지를 알아보고자 할 때 사용하는 연산자.
        - 형식 : 컬럼명 in (값1, 값2, 값3...);
*/
select empno, ename, sal from emp where empno in(7844, 7654, 7521) ; 

/*
    not : 조건에 반대가 되는 논리값을 구함
*/
 -- 부서 번호가 10번이 아닌 사원을 부서번호, 이름, 직급을 출력하라.
 select ename, job, deptno from emp where not deptno = 10;
 -- 사원번호가 7844이거나 7654이거나 7521이 아닌 사원을 이름, 번호, 직급을 출력하라.
 select empno, ename, job from emp where not empno in (7844,7654,7521);
 
 /*
    [LIKE 연산자]
    - 검색하고자 하는 값을 정확히 모를 경우 와일드 카드와 같이 사용하여
      원하는 값을 얻고자할 경우 사용함
        형식 : 컬럼명 LIKE 패턴 
        
        [와일드 카드]
        % : 문자가 없거나 하나 이상의 문자가 어떤 값이 오던 상관이 없다
            ** %는 검색하고자 하는 값을 정확히 모를 경우 사용한다. **
            %는 몇개의 문자가 오던 상관이 없다는 의미
            
        _ : 하나의 문자가 어떤 값이 오든 상관 없음
            한 문자대신 사용하는 것임
 */
 -- % : -> K로 시작하는 사원을 정보를 출력하시오.
 select ename, empno from emp where ename like 'K%';
 -- % : -> K로 끝나는 사원을 정보를 출력하시오.
 select ename, empno from emp where ename like '%K';
 -- % : -> K가 들어가는 사원을 정보를 출력하시오.
 select ename, empno from emp where ename like '%K%';
 
 -- _ : 이름의 두번째 글자가 A인 사원의 정보를 출력하라
 select ename, empno from emp where ename like '_A%';
 -- 이름에 A를 포함하지 않는 사람의 정보를 출력하라
 select ename, empno from emp where ename not like '%A%';
 
 /*
    NULL 을 위한 연산자
    - 오라클에서는 컬럼에 null 값이 저장되는 것을 허용한다
      NULL은 미확정, 알 수 없는 값, 0도 아닌 빈 공간도 아닌 어떤 값이
      존재하지만 어떤 값인지 알 수 없다는 의미이다
      
    - null은 연산, 할당, 비교가 불가능하다.
 */ 
 -- 커미션을 받지 않은 사원을 출력하시오.
 select ename, comm, job from emp where comm = null;
 -- null이 저장되어 있는 경우에는 비교 연산자로 판정할 수 없다.
 /*
    [is null과 is not null 이란 연산자가 있다]
    - 특정 컬럼 값인지를 비교할 경우에는 비교 연산자를 사용하지만
      null 일 경우엔 is null 연산자를 사용
      null 값이 아닌 경우엔 is not null 연산자를 사용
      
    is null : null 이면 만족
    is not null : null 이면 만족하지 않음
        - null은 값이 아니므로 = 또는 != 으로 비교할 수 없다.
 */
  select ename, comm, job from emp where comm is not null;
  
  -- 자신의 직속상관이 없는 사원의 이름과 직급과 직속 상관의 사원번호를 출력하라.
  select empno, ename, mgr, job from emp where mgr is null;
  
  /*
    [정렬을 위한 order by 절]
    order by 절은 행을 정렬하는데 사용하며, 쿼리문 맨 뒤에 기술하며, 정렬의 기준이 되는
    컬럼명 뒤에 또는 select 절에서 명시된 별칭을 사용할 수 있음
         
            - 오름차 (ASC) -           - 내림차 (DESC)-
    숫자      작은 값 부터                  큰 값 부터
    문자      사전 순으로                  사전의 역순으로
    날짜      빠른 날짜 순                 늦은 날짜 순
    null  가장 마지막에 나온 null       가장 먼저 나온 null
    
    영문자의 경우 소문자를 가장 큰 값으로, null 값은 모든 값 중에서 가장 작은 값으로 인식함
            
  */
  
  -- ASC : 사원번호를 기준으로 오름차순 정렬하시오.
  select empno, ename from emp order by empno asc;
  -- DESC : 사원번호를 기준으로 내림차순으로 정렬하시오.
  select empno, ename from emp order by empno DESC;
  -- ASC : 급여를 기준으로 오름차순 정렬하시오.
  select empno, ename,SAL from emp order by SAL asc;
  -- 입사일이 가장 최근인 사원 순으로 번호, 이름, 입사일을 출력하라.
  select empno, hiredate, ename, SAL FROM EMP ORDER BY hireDATE DESC;
  
  select 24*60*60 from dual;
  DESC DUAL;
  -- 한개의 문자만을 저장할 수 있고, X라는 값을 가진 단 하나의 행만을 저장하고 있다
  SELECT * FROM DUAL;
  
  