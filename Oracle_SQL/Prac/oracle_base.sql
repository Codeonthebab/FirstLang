/*
������ �Լ�
    ���� �Լ�
     - LOWER(char) : ��� ���ڸ� �ҹ��ڷ� ��ȯ
     - UPPER(char) : ��� ���ڸ� �빮�ڷ� ��ȯ
     - INITCAP(char) : ù ���ڸ� �빮�ڷ�, �������� �ҹ��ڷ� ��ȯ
     - CONCAT(char1, char2) : �� ���ڿ��� ���� (|| �����ڿ� ����)
     - SUBSTR(char, position, [length]) : ���ڿ��� Ư�� �κ�(sub-string)�� ����
     - LENGTH(char) : ���ڿ��� ���̸� ��ȯ
     - INSTR(char, substring, [position], [occurrence]) : Ư�� ���ڰ� ó�� ��Ÿ���� ��ġ�� ��ȯ
     - LPAD(char, n, [pad_str]) / RPAD(char, n, [pad_str]) : ����/�����ʿ� Ư�� ���ڸ� ä�� �� n�ڸ��� ���� (Left/Right Padding)
     - CONVERT(char, dest_char_set, [source_char_set]) : ���ڿ��� ������ ���� �������� ��ȯ
     - CHR(n) : �ƽ�Ű �ڵ� ��(n)�� �ش��ϴ� ���ڸ� ��ȯ
     - ASCII(char) : ������ �ƽ�Ű �ڵ� ���� ��ȯ (������ �ݴ�� �Ǿ� �־ �����߾��!)
     - REPLACE(char, search_str, [replace_str]) : ���ڿ����� Ư�� ����(search_str)�� �ٸ� ����(replace_str)�� ����
        
    �����Լ�
     - ABS(n) : ������ ������ ��ȯ
     - COS(n) : ������ �ڻ��� ���� ��ȯ (���� ��)
     - EXP(n) : e�� n ���� ���� ��ȯ
     - FLOOR(n) : ���ں��� �۰ų� ���� �ִ� ������ ��ȯ (����)
     - LOG(base, n) : n�� base �α� ���� ��ȯ
     - POWER(n1, n2) : n1�� n2 ���� ���� ��ȯ
     - SIGN(n) : ������ ��ȣ�� ��ȯ (���: 1, ����: -1, 0: 0)
     - SIN(n) : ������ ���� ���� ��ȯ (���� ��)
     - TAN(n) : ������ ź��Ʈ ���� ��ȯ (���� ��)
     - ROUND(n, [integer]) : ���ڸ� ������ �ڸ������� �ݿø�
     - TRUNC(n, [integer]) : ���ڸ� ������ �ڸ������� ���� (Truncate)
     - MOD(n1, n2) : n1�� n2�� ���� �������� ��ȯ
        
    ��¥�Լ�
     - SYSDATE : ���� �ý����� ��¥�� �ð��� ��ȯ (���� ��¥)
     - MONTHS_BETWEEN(date1, date2) : �� ��¥ ������ ���� ���� ��ȯ
     - ADD_MONTHS(date, n) : Ư�� ��¥�� n������ ���� ��¥�� ��ȯ
     - NEXT_DAY(date, char) : Ư�� ��¥�� �������� ������ Ư�� ������ ��¥�� ��ȯ
     - LAST_DAY(date) : Ư�� ��¥�� ���� ���� ������ ��¥�� ��ȯ
     - ROUND(date, [format]) : Ư�� ��¥�� ������ ����(��, ��, �� ��)�� ���� �ݿø�
     - TRUNC(date, [format]) : Ư�� ��¥�� ������ ���Ŀ� ���� ���� 
        
    ��ȯ�Լ�
     - TO_CHAR(date|number, [format]) : ��¥�� ���� �����͸� ������ ������ ���ڿ��� ��ȯ
     - TO_DATE(char, [format]) : ���ڿ� �����͸� ������ ������ ��¥ �����ͷ� ��ȯ
     - TO_NUMBER(char) : ���ڿ� �����͸� ���� �����ͷ� ��ȯ
        
    �Ϲ��Լ�
     - NVL(expr1, expr2) : expr1�� NULL�̸� expr2��, �ƴϸ� expr1�� ��ȯ
     - DECODE(expr, search1, result1, [search2, result2...], [default])
       : IF-THEN-ELSE ���� ����. expr�� search�� ������ result�� ��ȯ
     - CASE ... WHEN ... THEN ... ELSE ... END : DECODE���� �� ������ ǥ�� SQL�� ���ǹ�

    �׷��Լ�
        - sum, avg, count, max, min, 
          stdev(ǥ������), STDDEV(ǥ������), VARIANCE(�л�)
*/

select 'DataBase', LOWER ('DATABASE') FROM DUAL;
select LOWER(ename) FROM EMP; -- �ҹ��� LOWER
select UPPER(ename) FROM EMP;
-- ������ MANAGER�� ����� �˻��Ͻÿ�.
select empno, ename, job from emp where job=upper('MANAGER');

select initcap ('DataBase Progaramming') from dual;
-- ������̺��� 10�� �μ� �Ҽ��� �̸��� ù ���ڸ� �빮�ڷ� ����Ͻÿ�.
select ename, initcap(ename) from emp where deptno = 10;
-- 'Smith'�� �̸��� ���� ����� ��, �̸�, �޿�, Ŀ�̼��� ����ϵ�, 
-- initcap��  upper �޼ҵ带 ����϶�
select initcap(ename), empno, sal, comm from emp where ename = upper('Smith');
select concat('Data', 'Base') from Dual;
select length('DataBase'), length ('�����ͺ��̽�'), lengthB('�����ͺ��̽�') from dual;

-- ���� �� �̸��� 4���� ������ �̸��� �ҹ��ڷ� ����Ͻÿ�.
select LOWER(ename), SAL, EMPNO from EMP where length (ename) = 4;
-- �̸��� 6���� �̻��� ����� �����ȣ, �̸�, �޿��� ����Ͻÿ�.
select empno, ename, SAL from emp where length (ename) >= 6;
select substr ('database', -4, 3) from dual ; -- -�� ���� �ڿ������� 3��

--20�� �μ� ����� �� �Ի�⵵�� �����Ͽ� ����Ͻÿ�.
select ename, empno, hiredate, substr(hiredate, 1, 2) from emp where deptno=20 and substr (hiredate, 1, 2) = 87;
-- �̸��� K�� ������ ������ �˻��Ͻÿ�.
select ename, hiredate from emp where substr(ename,-1, 1)='K';
select ename from emp where ename like '%K';

select instr('DataBase' , 'a', 5, 1) from dual;
select instr('DataBase' , 'B') from dual;
select instrb('��Ÿ��ƽ' , '��', 4, 1) from dual;

-- �̸��� �� ��° �ڸ��� A�� �ִ� ����� ���, �̸�, ������ ����϶�.
SELECT ename, empno, job FROM emp WHERE SUBSTR(ename, 2, 1) = 'A';
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '_A%';

SELECT RPAD('DATABASE', 20, '#') FROM DUAL;
SELECT LPAD('DATABASE', 20, '#') FROM DUAL;
SELECT TRIM(LEADING FROM '               DATABASE                 ') FROM DUAL;
SELECT TRIM(TRAILING FROM '               DATABASE                 ') FROM DUAL;
-- SMITH => mit
SELECT ENAME, TRIM('S' FROM ENAME) FROM EMP WHERE ENAME = 'SMITH';
SELECT ENAME, TRIM('H' FROM ENAME) FROM EMP WHERE ENAME = 'SMITH';

-- ���� �Լ�
SELECT ABS(-41) FROM DUAL;
SELECT FLOOR(34.45678) FROM DUAL;
SELECT ROUND (35.123,2) FROM DUAL;
SELECT ROUND (47.51, 0) FROM DUAL;
SELECT ROUND (834.11, -1) FROM DUAL; -- 1�� �ڸ� ���ϸ� ���� ������

--���� �ڸ����� �ݿø�
SELECT ROUND (834.12, -1) FROM DUAL;
--���� �ڸ����� �ݿø�
SELECT ROUND (834.12, -2) FROM DUAL;
-- ����
SELECT TRUNC (12.345,2) FROM DUAL;
-- ������ ���ϱ�
SELECT MOD (34, 5) FROM DUAL;
-- ����� ¦���� ������� 4���� �̸��� ������ ����ض�.
SELECT EMPNO, ENAME, JOB FROM EMP WHERE MOD(EMPNO, 2)=0;

--��¥�Լ�
--���糯¥
SELECT SYSDATE-1 ����, SYSDATE ����, SYSDATE+1 ���� FROM DUAL; -- ���� ��¥
-- �μ���ȣ�� 10���� ����� ������� �Ի��� ���κ��� ���ñ��� ��ĥ�� �귶���� 
-- �ٹ� �ϼ��� ���Ͻÿ�.
SELECT EMPNO, ENAME, HIREDATE, TRUNC(SYSDATE-HIREDATE) �ٹ��ϼ� FROM EMP WHERE DEPTNO='10';

--������ �������� ����� �귶��
SELECT SYSDATE, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) FROM EMP WHERE DEPTNO = 10;
-- ��� ���� ���� ���ϴ� ADD_MONTHS�Լ�
-- �Ի��Ͽ��� 3������ ���� ��¥�� ���Ͽ� ����Ͻÿ�.
SELECT HIREDATE, ENAME, ADD_MONTHS(HIREDATE, 3) FROM EMP WHERE DEPTNO = 10;

-- �ش� ������ ���� ����� ��¥�� ��ȯ�ϴ� �Լ� (NEXT_DAY)
-- ������ �������� ���ʷ� �ٰ����� �Ͽ����� �����ΰ�?
ALTER SESSION SET NLS_LANGUAGE=KOREAN; -- �ѱ���� ����!
SELECT SYSDATE, NEXT_DAY(SYSDATE, '�Ͽ���' ) FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, '��' ) FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, 1 ) FROM DUAL;

-- ������ ����� ����� ��쿣 �� AMERICAN�� �����ϸ� �ȴ�
ALTER SESSION SET NLS_LANGUAGE=AMERICAN; -- ����� ���� �ϸ� �ȴ�
SELECT SYSDATE, NEXT_DAY(SYSDATE, 'SUNDAY' ) FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, 'SUN' ) FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, 1 ) FROM DUAL;