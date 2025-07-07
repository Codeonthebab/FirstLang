/*
단일행 함수
    문자 함수
     - LOWER(char) : 모든 문자를 소문자로 변환
     - UPPER(char) : 모든 문자를 대문자로 변환
     - INITCAP(char) : 첫 글자만 대문자로, 나머지는 소문자로 변환
     - CONCAT(char1, char2) : 두 문자열을 연결 (|| 연산자와 동일)
     - SUBSTR(char, position, [length]) : 문자열의 특정 부분(sub-string)을 추출
     - LENGTH(char) : 문자열의 길이를 반환
     - INSTR(char, substring, [position], [occurrence]) : 특정 문자가 처음 나타나는 위치를 반환
     - LPAD(char, n, [pad_str]) / RPAD(char, n, [pad_str]) : 왼쪽/오른쪽에 특정 문자를 채워 총 n자리를 만듦 (Left/Right Padding)
     - CONVERT(char, dest_char_set, [source_char_set]) : 문자열을 지정된 문자 집합으로 변환
     - CHR(n) : 아스키 코드 값(n)에 해당하는 문자를 반환
     - ASCII(char) : 문자의 아스키 코드 값을 반환 (설명이 반대로 되어 있어서 수정했어요!)
     - REPLACE(char, search_str, [replace_str]) : 문자열에서 특정 문자(search_str)를 다른 문자(replace_str)로 변경
        
    숫자함수
     - ABS(n) : 숫자의 절댓값을 반환
     - COS(n) : 숫자의 코사인 값을 반환 (라디안 값)
     - EXP(n) : e의 n 제곱 값을 반환
     - FLOOR(n) : 숫자보다 작거나 같은 최대 정수를 반환 (내림)
     - LOG(base, n) : n의 base 로그 값을 반환
     - POWER(n1, n2) : n1의 n2 제곱 값을 반환
     - SIGN(n) : 숫자의 부호를 반환 (양수: 1, 음수: -1, 0: 0)
     - SIN(n) : 숫자의 사인 값을 반환 (라디안 값)
     - TAN(n) : 숫자의 탄젠트 값을 반환 (라디안 값)
     - ROUND(n, [integer]) : 숫자를 지정한 자릿수에서 반올림
     - TRUNC(n, [integer]) : 숫자를 지정한 자릿수에서 버림 (Truncate)
     - MOD(n1, n2) : n1을 n2로 나눈 나머지를 반환
        
    날짜함수
     - SYSDATE : 현재 시스템의 날짜와 시간을 반환 (오늘 날짜)
     - MONTHS_BETWEEN(date1, date2) : 두 날짜 사이의 개월 수를 반환
     - ADD_MONTHS(date, n) : 특정 날짜에 n개월을 더한 날짜를 반환
     - NEXT_DAY(date, char) : 특정 날짜를 기준으로 다음번 특정 요일의 날짜를 반환
     - LAST_DAY(date) : 특정 날짜가 속한 달의 마지막 날짜를 반환
     - ROUND(date, [format]) : 특정 날짜를 지정한 형식(년, 월, 일 등)에 맞춰 반올림
     - TRUNC(date, [format]) : 특정 날짜를 지정한 형식에 맞춰 버림 
        
    변환함수
     - TO_CHAR(date|number, [format]) : 날짜나 숫자 데이터를 지정된 형식의 문자열로 변환
     - TO_DATE(char, [format]) : 문자열 데이터를 지정된 형식의 날짜 데이터로 변환
     - TO_NUMBER(char) : 문자열 데이터를 숫자 데이터로 변환
        
    일반함수
     - NVL(expr1, expr2) : expr1이 NULL이면 expr2를, 아니면 expr1을 반환
     - DECODE(expr, search1, result1, [search2, result2...], [default])
       : IF-THEN-ELSE 논리를 구현. expr과 search가 같으면 result를 반환
     - CASE ... WHEN ... THEN ... ELSE ... END : DECODE보다 더 유연한 표준 SQL의 조건문

    그룹함수
        - sum, avg, count, max, min, 
          stdev(표준편차), STDDEV(표준편차), VARIANCE(분산)
*/

select 'DataBase', LOWER ('DATABASE') FROM DUAL;
select LOWER(ename) FROM EMP; -- 소문자 LOWER
select UPPER(ename) FROM EMP;
-- 직급이 MANAGER인 사원을 검색하시오.
select empno, ename, job from emp where job=upper('MANAGER');

select initcap ('DataBase Progaramming') from dual;
-- 사원테이블의 10번 부서 소속의 이름의 첫 글자만 대문자로 출력하시오.
select ename, initcap(ename) from emp where deptno = 10;
-- 'Smith'란 이름을 갖은 사원의 번, 이름, 급여, 커미션을 출력하되, 
-- initcap과  upper 메소드를 사용하라
select initcap(ename), empno, sal, comm from emp where ename = upper('Smith');
select concat('Data', 'Base') from Dual;
select length('DataBase'), length ('데이터베이스'), lengthB('데이터베이스') from dual;

-- 직원 중 이름이 4자인 직원의 이름을 소문자로 출력하시오.
select LOWER(ename), SAL, EMPNO from EMP where length (ename) = 4;
-- 이름이 6글자 이상인 사원의 사원번호, 이름, 급여를 출력하시오.
select empno, ename, SAL from emp where length (ename) >= 6;
select substr ('database', -4, 3) from dual ; -- -를 쓰면 뒤에서부터 3개

--20번 부서 사원들 중 입사년도를 추출하여 출력하시오.
select ename, empno, hiredate, substr(hiredate, 1, 2) from emp where deptno=20 and substr (hiredate, 1, 2) = 87;
-- 이름이 K로 끝나는 직원을 검색하시오.
select ename, hiredate from emp where substr(ename,-1, 1)='K';
select ename from emp where ename like '%K';

select instr('DataBase' , 'a', 5, 1) from dual;
select instr('DataBase' , 'B') from dual;
select instrb('판타스틱' , '스', 4, 1) from dual;

-- 이름의 두 번째 자리에 A가 있는 사원의 사번, 이름, 직급을 출력하라.
SELECT ename, empno, job FROM emp WHERE SUBSTR(ename, 2, 1) = 'A';
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '_A%';

SELECT RPAD('DATABASE', 20, '#') FROM DUAL;
SELECT LPAD('DATABASE', 20, '#') FROM DUAL;
SELECT TRIM(LEADING FROM '               DATABASE                 ') FROM DUAL;
SELECT TRIM(TRAILING FROM '               DATABASE                 ') FROM DUAL;
-- SMITH => mit
SELECT ENAME, TRIM('S' FROM ENAME) FROM EMP WHERE ENAME = 'SMITH';
SELECT ENAME, TRIM('H' FROM ENAME) FROM EMP WHERE ENAME = 'SMITH';

-- 숫자 함수
SELECT ABS(-41) FROM DUAL;
SELECT FLOOR(34.45678) FROM DUAL;
SELECT ROUND (35.123,2) FROM DUAL;
SELECT ROUND (47.51, 0) FROM DUAL;
SELECT ROUND (834.11, -1) FROM DUAL; -- 1의 자리 이하를 전부 절삭함

--일의 자리에서 반올림
SELECT ROUND (834.12, -1) FROM DUAL;
--십의 자리에서 반올림
SELECT ROUND (834.12, -2) FROM DUAL;
-- 버림
SELECT TRUNC (12.345,2) FROM DUAL;
-- 나머지 구하기
SELECT MOD (34, 5) FROM DUAL;
-- 사번이 짝수인 사원들의 4번과 이름과 직급을 출력해라.
SELECT EMPNO, ENAME, JOB FROM EMP WHERE MOD(EMPNO, 2)=0;

--날짜함수
--현재날짜
SELECT SYSDATE-1 어제, SYSDATE 오늘, SYSDATE+1 내일 FROM DUAL; -- 어제 날짜
-- 부서번호가 10번인 사원을 대상으로 입사한 날로부터 오늘까지 며칠이 흘렀는지 
-- 근무 일수를 구하시오.
SELECT EMPNO, ENAME, HIREDATE, TRUNC(SYSDATE-HIREDATE) 근무일수 FROM EMP WHERE DEPTNO='10';

--오늘의 기준으로 몇개월이 흘렀나
SELECT SYSDATE, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) FROM EMP WHERE DEPTNO = 10;
-- 모든 개월 수를 더하는 ADD_MONTHS함수
-- 입사일에서 3개월이 지난 날짜를 구하여 출력하시오.
SELECT HIREDATE, ENAME, ADD_MONTHS(HIREDATE, 3) FROM EMP WHERE DEPTNO = 10;

-- 해당 요일의 가장 가까운 날짜를 반환하는 함수 (NEXT_DAY)
-- 오늘의 기준으로 최초로 다가오는 일요일은 언제인가?
ALTER SESSION SET NLS_LANGUAGE=KOREAN; -- 한국어로 변경!
SELECT SYSDATE, NEXT_DAY(SYSDATE, '일요일' ) FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, '일' ) FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, 1 ) FROM DUAL;

-- 요일을 영어로 사용할 경우엔 언어를 AMERICAN로 지정하면 된다
ALTER SESSION SET NLS_LANGUAGE=AMERICAN; -- 영어로 변경 하면 된다
SELECT SYSDATE, NEXT_DAY(SYSDATE, 'SUNDAY' ) FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, 'SUN' ) FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, 1 ) FROM DUAL;