-------subQuery-------
/*
    [���� ����]
        - �� �� �̻��� ���̺��� ������ �ʿ��� ��� ���������� �̿��Ѵ�.
    ++ ����
        - �ϳ��� select ������ �� �ȿ� �� �ϳ��� select ������ �����ϰ� �ִ� ��
        - ������ ��������, ������ ��������
        
        **������ ��������
            - ������ ���������� ���� select �������κ��� ���� �ϳ��� �ุ�� ��ȯ�ϴ� ���� �ǹ���
            - ������ �񱳿����� (* =, >, >=, <, <=, <> )
        
        **������ ��������
            - ������������ ��ȯ�Ǵ� ����� �ϳ� �̻��� ���϶� ����ϴ� ����
            - ������ ���������� ������ �����ڸ� �̿��ؾ��Ѵ�
            - ������ ������ (*IN, ANY, SOME, ALL, EXIST)
                **IN** ���������� �������� ���������� ��� �� �ϳ��� ��ġ�ϸ� ���� ��ȯ
                **ANY, SOME** ���������� �������� ���������� �˻� ����� �ϳ� �̻��� ��ġ�ϸ� ���� ��ȯ
                **ALL** ���������� �������� ���������� �˻� ����� ��� ���� ��ġ�ϸ� ���� ��ȯ
                **EXIST** ���������� �������� ���������� ��� �߿��� �����ϴ� ���� �ϳ��� �����ϸ� ���� ��ȯ
                
*/

select deptno from emp where ename= 'SCOTT';
select dname from dept where deptno = 20;
select dname from dept where deptno = (select deptno from emp where ename = 'SCOTT');
--    ���� ����                                ���� ����
-- ���� ������ �� �������� �����ʿ� ����ؾ� �ϸ�, �ݵ�� ��ȣ �ȿ� �ѷ��ο����Ѵ�.
-- ���� ������ ���� ������ ����Ǳ� ���� �ѹ��� ����ȴ�.
-- SMITH�� ���� �μ����� �ٹ��ϴ� ����� ��� ������ ����Ͻÿ�.

select deptno from emp where ename = 'SMITH';
select * from emp;
select * from emp where deptno = (select deptno from emp where ename = 'SMITH');

-- ��� �޿����� �� ���� �޿��� �޴� ����� �˻��Ͽ� �̸�, �޿��� ����Ͻÿ�.
select TRUNC(avg(sal)) from emp;
select ename, sal from emp;
select ename, sal from emp where sal > (select TRUNC(avg(sal)) from emp);

-------------- ���� �� ��������
-- �޿��� 3000�̻� �޴� ����� �Ҽӵ� �μ��� ������ �μ����� �ٹ��ϴ� ����� ����϶�
select distinct (deptno) from emp where sal >= 3000;
select ename,sal, deptno from emp where deptno in (select distinct (deptno) from emp where sal >= 3000);

-- all : ���� ������ �� ������ ���������� �˻���� ��� ��ġ�ϸ� ��
-- 30�� �Ҽ� ����� �߿��� �޿��� ���� ���� ���� ������� 
-- �� ���� �޿��� �޴� ����� �̸�, �޿��� ����϶�.
select Sal from emp where deptno = 30;
select ename, sal from emp where sal > ALL (select max (Sal) from emp where deptno = 30);

-- any : ���������� �������� ���������� �˻������ �ϳ� �̻� ��ġ�ϸ� ��
-- �μ���ȣ�� 30���� ������� �޿� �� ���� ���� ������ ���� �޿��� �޴� ����� �̸�, �޿��� ����϶�.
select min (sal) from emp where deptno = 30;
select ename, sal from emp where sal > any (select sal from emp where deptno = 30);

/*null
    �Ʒ��� ��� ������ ���� ������ Ȱ���Ͽ� �ۼ��Ͻÿ�.
    1. SCOTT�� �޿��� �����ϰų� �� ���� �޴� ������ �޿��� ����Ͻÿ�.
    2. ����(JOB)�� ���(CLARK)�� ����� �μ��� �μ���ȣ�� �μ���� ������ ����Ͻÿ�.
    3. �̸��� T�� �����ϰ� �ִ� ������ ���� �μ����� �ٹ��ϰ� �ִ� ����� ��ȣ�� �̸��� ����Ͻÿ�.
    4. �μ��� ��ġ�� DALLAS�� ��� ����� �̸�, �μ� ��ȣ�� ����Ͻÿ�.
    5. SALES �μ��� ��� ����� �̸��� �޿��� ����Ͻÿ�.
    6. KING ���� �����ϴ� ��� ����� �̸��� �޿��� ����Ͻÿ�.
       ��, KING���� �����ϴ� ���(MGR��KING)�� ����� �ǹ��Ѵ�.
    7. �ڽ��� �޿��� ��� �޿����� ����, �̸��� S�� ���� ����� ������ �μ��� 
       �ٹ��ϴ� ����� �����ȣ, �̸�, �޿��� ����϶�.
*/

-- 1. SCOTT�� �޿��� �����ϰų� �� ���� �޴� ������ �޿��� ����Ͻÿ�.
SELECT ENAME, SAL FROM EMP 
WHERE SAL >= (SELECT SAL FROM EMP WHERE ENAME = 'SCOTT');

-- 2. ����(JOB)�� ���(CLARK)�� ����� �μ��� �μ���ȣ�� �μ���� ������ ����Ͻÿ�.
SELECT DEPTNO, DNAME, LOC
FROM DEPT
WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB = 'CLERK');

-- 3. �̸��� T�� �����ϰ� �ִ� ������ ���� �μ����� �ٹ��ϰ� �ִ� ����� ��ȣ�� �̸��� ����Ͻÿ�.
SELECT DISTINCT(DEPTNO) FROM EMP WHERE ENAME LIKE '%T%';
SELECT EMPNO, ENAME FROM EMP WHERE DEPTNO 
IN (SELECT DISTINCT(DEPTNO) FROM EMP WHERE ENAME LIKE '%T%');

-- 4. �μ��� ��ġ�� DALLAS�� ��� ����� �̸�, �μ� ��ȣ�� ����Ͻÿ�.
SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS';
SELECT ENAME, DEPTNO FROM EMP WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS');

-- 5. SALES �μ��� ��� ����� �̸��� �޿��� ����Ͻÿ�.
SELECT DEPTNO FROM DEPT WHERE DNAME = 'SALES';
SELECT ENAME, SAL FROM EMP WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = 'SALES');

-- 6. KING ���� �����ϴ� ��� ����� �̸��� �޿��� ����Ͻÿ�.
SELECT EMPNO FROM EMP WHERE ENAME = 'KING';
SELECT ENAME, SAL, MGR FROM EMP WHERE MGR IN (SELECT EMPNO FROM EMP WHERE ENAME = 'KING');

-- 7. �ڽ��� �޿��� ��� �޿����� ����, �̸��� S�� ���� ����� ������ �μ��� 
--       �ٹ��ϴ� ����� �����ȣ, �̸�, �޿��� ����϶�.
SELECT TRUNC(AVG(SAL)) FROM EMP;
SELECT DISTINCT (DEPTNO) FROM EMP WHERE SAL>2073;
SELECT ENAME FROM EMP WHERE ENAME LIKE '%S%';

SELECT EMPNO, ENAME, SAL FROM EMP WHERE DEPTNO IN
(SELECT DISTINCT (DEPTNO) FROM EMP WHERE SAL> (SELECT TRUNC(AVG(SAL))
FROM EMP) AND ENAME LIKE '%S%');

---------------------END SUBQUERY--------------------
/*
    [���ο� ���̺��� ����]
    = ���� =
    CREATE TABLE ���̺�� (
    �÷���  �ڷ��� (ũ��) ��������,
    �÷���  �ڷ��� (ũ��),
    �÷���  �ڷ��� (ũ��),
    �÷���  �ڷ��� (ũ��),
    );
    
    ���̺� ���� : CREATE
    ���̺� ���� : ALTER
    ���̺� ���� : DROP
    ���̺� �̸� ���� : RENAME
    
    [���̺� �ڷ���]
    CHAR => 2000BYTE ����
    VARCHAR2 => 4000BYTE ����
    NUMBER => �ּҰ� 4BYTE
    NUMBER(ũ��), NUMBER (W, D)  7, 2(*7��° ������ 2��° �࿡ �ִ´�)
    DATA, BLOB(���̳ʸ� ������ ����), CLOB(�ؽ�Ʈ ������ ����)
        (**TIMESTAMP (DATE) ��** �Ϲ� DATE���� ���� ��)
    ROWID : ���̺��� ���� ��ġ�� ������ �� �ּ� ��
    
    [���̺� ��� �÷� ���� �ο��ϱ� ���� ��Ģ]
    1. �ݵ�� ���ڷ� �����ؾ��Ѵ�.
    2. 1~30�ڱ��� �����ϴ�
    3. A~Z ������ ��ҹ���, 0 ~ 9�� ����, Ư������ (_,#, $)�� �����ϴ�
    4. ������ ��� �Ұ��ϴ�.
    5. ������ ���Ұ�
*/

-- �����ȣ, �����, �޿� 3���� �÷����� ������ EMP01 ���̺��� �����϶�.
CREATE TABLE EMP01 (
    EMPNO NUMBER(4),
    ENAME VARCHAR2 (20),
    SAL NUMBER (7,2)    
    );
-- DROP TABLE EMP01; ���̺� ���� ����
SELECT * FROM TAB;
DESC EMP01; --���� ���� �ڵ�
DESC EMP; --
SELECT * FROM EMP01;
CREATE TABLE EMP02 AS SELECT * FROM EMP;

DESC EMP;
DESC EMP01;

/* 
    ALTER TABLE �� ���̺� ���� ����
    ALTER TABLE ��ɾ�� ���̺��� �÷��� �߰�, ����, �÷��� Ÿ���̳� ���̸� ������ �� �����
    ADD COLUMN : ���ο� �÷� �߰�
    MODIFY COLUMN : ���� �÷��� ����
        [���ǻ���] 
            1. �ش� �÷��� �ڷᰡ ���� ���
              - �÷��� ������ Ÿ���� ������ �� �ִ�.
              - �÷��� ũ�⸦ ������ �� �ִ�.
            2. �ش� �÷��� �ڷᰡ �ִ� ���
              - �÷��� ������ Ÿ���� ������ �� ����.
              - �÷��� ũ��� �ø� ���� ������ ���� ������ �ִ� ũ�⺸�� �۰� ������ �� ����
    DROP COLUMN : ���� �÷��� ����
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

-- ������ ����
SELECT * FROM RECYCLEBIN;
DESC RECYCLEBIN;

-- ������ ����
PURGE RECYCLEBIN;

CREATE TABLE EMP01 AS SELECT * FROM EMP;

-- �����뿡 ���� �ʰ� �ٷ� ����
DROP TABLE EMP01 PURGE;

RENAME EMP01 TO EMP02;
SELECT * FROM EMP02;
DELETE FROM EMP02;
ROLLBACK;
TRUNCATE TABLE EMP02;
ROLLBACK;