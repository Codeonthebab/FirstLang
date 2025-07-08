-- LAST_DAY : 해당 월의 마지막 날짜
SELECT SYSDATE, LAST_DAY(SYSDATE) FROM DUAL;

-- round : 한달의 기준일 때 16일을 기준으로 반올림
--         한 주일 때 한 주가 시작되는 날짜
-- 입사 일을 달 기준으로 반 올림한다
select hiredate, round (hiredate, 'MONTH') FROM EMP;

-- TRUNC 함수 : 날짜도 잘라낼 수 있다
--       형식 : TRUNK (DATE, 'MONTH')
--             입사일을 월 기준으로 잘라낸다.
SELECT HIREDATE, TRUNK (HIREDATE, 'MONTH') FROM EMP;

-------변환 함수
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY-MM-DD') FROM DUAL;
-- 사원들의 입사일을 출력하되, 요일까지 표기하시오.
SELECT TO_CHAR(HIREDATE, 'YYYY/MM/DD DAY') FROM EMP;
SELECT TO_CHAR(HIREDATE, 'YYYY/MM/DD DY') FROM EMP;
-- 문자 -> 데이로 전환
SELECT ENAME, HIREDATE FROM EMP WHERE HIREDATE = to_DATE(19810220, 'YYYYMMDD');

--  올해 며칠이 지났는지를 계산하는 쿼리문을 작성하시오
SELECT TRUNC( SYSDATE-TO_DATE('2025/01/01', 'YYYY/MM/DD')) FROM DUAL;

-- TO_NUMBER : 숫자형으로 변환한다
SELECT '1000'+'2000' FROM DUAL;
SELECT TO_NUMBER ('10,000', '999,999' ) + TO_NUMBER ('20,000', '999,999') FROM DUAL;

-- 일반 함수
-- NVL, DECODE, CASE

SELECT NVL (NULL, 3) + 0 FROM DUAL;
SELECT ENAME, SAL, COMM, NVL(COMM, 0), JOB FROM EMP;

-- 연봉을 계산하기 위해서 급여에 12를 곱하고, 커미션을 더함
SELECT ENAME, SAL, COMM, SAL*12, SAL*12+NVL(COMM, 0) FROM EMP;

-- 모든 사원은 자신의 상관이 있다, 그런데 사원테이블에 유일하게 상관이 없는
-- 행이 존재 한다. 그 사원의 MGR 컬럼값이 NULL이다, 상관이 없는 사원만
-- 출력하되, MGR 컬럼값은 NULL 대신에 CEO로 출력하시오.
SELECT ENAME, SAL, NVL((TO_CHAR(MGR, '9999')), 'CEO') FROM EMP WHERE ENAME = 'KING';

-- DECODE : 조건문 (조건에 맞을 경우에 처리하는 함수)
/* 형식
    DECODE (표현식, 조건1, 결과1,
                   조건2, 결과2,
                   조건3, 결과3,
                   기본 결과 N)
*/
SELECT * FROM DEPT;
SELECT * FROM EMP;

SELECT DEPTNO, 
    DECODE (DEPTNO, 10, 'ACCOUNTING',
                    20, 'RESEARCH',
                    30, 'SALES',
                    40, 'OPERATIONS') AS DNAME FROM EMP;

/*
    조건에 따라 서로 다른 처리가 가능한 case 함수
    
    case 표현식 when 조건1 then 결과1
               when 조건2 then 결과2
               when 조건3 then 결과3
               when 조건4 then 결과4
               else 결과 n
               end
*/
select ename, deptno,
        case when deptno = 10 then 'ACCOUNTING'
            when deptno = 20 then 'RESEARCH'
            when deptno = 30 then 'SALES'
            when deptno = 40 then 'OPERATIONS'
        end DNAME
from emp;

/* 직급에 따라 급여를 인상한다
    사원명, 사원번호, 직급, 급여를 출력한다
    직급이 'ANAIYST' => 5%
          'SALESMAN' => 10%
          'MANAGER' => 15%
          'CLERK' => 20% 인상
          decode 함수를 이용해서 완성하라
           SAL*12, SAL*12+NVL(COMM, 0) FROM EMP;
*/
SELECT ENAME, deptno, job,
    decode (job, 'clerk', sal *1.20,
                'MANAGER', SAL * 1.15,
                'SALESMAN', SAL * 1.10,
                'ANALYST', SAL * 1.05,
                SAL) AS "급여인상" from emp;
                
SELECT ENAME, JOB,
    CASE WHEN JOB = 'CLERK' THEN SAL * 1.20
        WHEN JOB = 'MANAGER' THEN SAL * 1.15
        WHEN JOB = 'SALESMAN' THEN SAL * 1.10
        WHEN JOB = 'ANALYST' THEN SAL * 1.05
        ELSE SAL END AS "급여인상" FROM EMP;
        

-- 그룹 함수
SELECT SUM (SAL) FROM EMP;
SELECT AVG (SAL) FROM EMP;
SELECT MAX (SAL) FROM EMP;
SELECT MIN (SAL) FROM EMP;
SELECT COUNT (COMM) FROM EMP;
SELECT COUNT (*), COUNT(COMM) FROM EMP;
SELECT COUNT(*), (COUNT (DISTINCT JOB)) FROM EMP;

-- 사원들을 사원번호를 기준으로 그룹지어라
SELECT DEPTNO FROM EMP GROUP BY DEPTNO;
SELECT DEPTNO, SUM(SAL), AVG(SAL) FROM EMP GROUP BY DEPTNO;
SELECT DEPTNO, MAX(SAL), MIN(SAL) FROM EMP GROUP BY DEPTNO;

-- 부서별로 사원수와 커미션을 받는 사원 수를 구하시오.
SELECT COUNT(*), COUNT(COMM) FROM EMP GROUP BY DEPTNO;

SELECT DEPTNO, AVG(SAL) FROM EMP GROUP BY DEPTNO HAVING AVG(SAL) >= 2000;
SELECT DEPTNO, MAX(SAL),MIN(SAL) FROM EMP GROUP BY DEPTNO HAVING MAX(SAL) > 2900;

/*
    [조인 (JOIN)]
        한 개 이상의 테이블에서 원하는 결과를 얻기 위한 방법
        
    [조인 종류]
        EQUI JOIN    : 동일한 컬럼을 기준으로 조인
        NONEQUI JOIN : 동일한 컬럼이 없을 경우 조인
        OUTER JOIN   : 조인 조건에 만족하지 않는 행도 출력 시킴
        SELF JOIN    : 한 테이블 내에서 조인 
        
    [조인의 기본 규칙]
        1. 기본 키와 외래 키를 통한 다른 테이블을 행과 연결
        2. 연결 키 사용으로 테이블과 테이블이 결합
        3. where 절에서 조인 조건을 사용함
        4. 명확성을 위해 컬럼 이름 앞에 테이블 명 또는 테이블 별칭을 사용함
*/
select * from emp, dept; -- 크로스 조인 : 2개 이상의 테이블이 조인될 때 공통된 컬럼에 의한 결합
select e.ename, d.dname 
from emp e, dept d 
where e.deptno = d.deptno 
and e.ename = 'SCOTT';

select * from salgrade;

select e.ename, e.sal, s.grade from emp e, salgrade s where e.sal between s.losal and s.hisal; 

-- outer join
--  행이 조인 조건에 만족하지 않을 경우 그 행은 결과에 나타나지 않게 되는데
--  이때 조인 조건에 만족하지 않는 행들도 출력하게 하는 조인을 outer 조인이라고 함
select distinct (deptno) from emp;
select deptno from dept;
-- Outer Join을 하기 위해서 사용하는 기호는 (+) 이며 
-- 조인 조건에서 정보가 부족한 컬럼 명 뒤에 위치하게 된다
select e.ename, d.deptno, d.dname from emp e, dept d where e.deptno(+)=d.deptno;
select e.ename from emp e;

-- self 조인 : 자기 자신과 조인을 맺는 것을 말함
select work.ename, manager.ename from emp work, emp manager where work.mgr = manager.empno;

-- 사원의 이름과 그의 매니저 이름을 출력하는 쿼리문을 작성하시오.
select work.ename ||'의 매니저는', manager.ename || ' 이다' as "그의 매니저" from emp work, emp manager where work.mgr = manager.empno;
/*
    [아래의 모든 문제는 조인을 활용하여 쿼리문을 작성하시오.]
        1. 사원들의 이름, 부서번호, 부서이름을 출력하시오.
        2. 부서번호가 30번인 사원들의 이름, 직급, 부서번호, 위치를 출력하시오.
        3. 커미션을 받는 사원의 이름, 커미션, 부서이름 및 부서 위치를 출력하시오.
        4. DALLAS에 근무하는 사원의 이름, 직급, 부서번호, 부서이름을 출력하시오. (*join으로 할 것)
        5. 이름에 A가 들어가는 사원들의 이름과 부서 이름을 출력하시오.
        6. 사원 이름과 직급, 급여, 급여 등급(salegrades)을 출력하시오.
        7. 사원 이름, 부서 번호와 해당 사원과 같은 부서에 근무하는 사원을 출력하시오. (* self join으로 할 것)
*/
-- 1. 사원들의 이름, 부서번호, 부서이름을 출력하시오.
select e.ename, e.deptno, d.dname from emp e, dept d where e.deptno = d.deptno;

-- 2. 부서번호가 30번인 사원들의 이름, 직급, 부서번호, 위치를 출력하시오.
select e.ename, e.deptno, e.job, d.deptno, d.loc
from emp e, dept d
where e.deptno = d.deptno
and d.deptno = 30;

-- 3. 커미션을 받는 사원의 이름, 커미션, 부서이름 및 부서 위치를 출력하시오.
select e.ename, d.deptno, e.comm, d.dname, d.loc 
from emp e, dept d where e.comm > 0;

-- 4. DALLAS에 근무하는 사원의 이름, 직급, 부서번호, 부서이름을 출력하시오. (*join으로 할 것) -- 다시
select e.ename, e.mgr, e.job, d.deptno, d.loc from emp e, dept d 
where e.deptno = d.deptno and d.loc = 'DALLAS';

-- 5. 이름에 A가 들어가는 사원들의 이름과 부서 이름을 출력하시오.
select e.ename, d.dname from emp e, dept d 
where e.deptno = d.deptno
and e.ename like '%A%';

-- 6. 사원 이름과 직급, 급여, 급여 등급(salgrade)을 출력하시오.
select e.ename, e.mgr, e.sal, s.grade from emp e, dept d, salgrade s;

-- 7. 사원 이름, 부서 번호와 해당 사원과 '같은 부서에 근무하는 사원'을 출력하시오. (* self join으로 할 것)
select e.ename, dname, e1.ename, e.deptno from emp e, emp e1, dept
where e.deptno = e1.deptno and e.deptno = dept.deptno;

select a.ename, dname, a.deptno, b.ename 
from emp a, emp b, dept where a.deptno = dept.deptno 
and a.deptno = b.deptno;