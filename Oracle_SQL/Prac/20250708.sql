-- LAST_DAY : �ش� ���� ������ ��¥
SELECT SYSDATE, LAST_DAY(SYSDATE) FROM DUAL;

-- round : �Ѵ��� ������ �� 16���� �������� �ݿø�
--         �� ���� �� �� �ְ� ���۵Ǵ� ��¥
-- �Ի� ���� �� �������� �� �ø��Ѵ�
select hiredate, round (hiredate, 'MONTH') FROM EMP;

-- TRUNC �Լ� : ��¥�� �߶� �� �ִ�
--       ���� : TRUNK (DATE, 'MONTH')
--             �Ի����� �� �������� �߶󳽴�.
SELECT HIREDATE, TRUNK (HIREDATE, 'MONTH') FROM EMP;

-------��ȯ �Լ�
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY-MM-DD') FROM DUAL;
-- ������� �Ի����� ����ϵ�, ���ϱ��� ǥ���Ͻÿ�.
SELECT TO_CHAR(HIREDATE, 'YYYY/MM/DD DAY') FROM EMP;
SELECT TO_CHAR(HIREDATE, 'YYYY/MM/DD DY') FROM EMP;
-- ���� -> ���̷� ��ȯ
SELECT ENAME, HIREDATE FROM EMP WHERE HIREDATE = to_DATE(19810220, 'YYYYMMDD');

--  ���� ��ĥ�� ���������� ����ϴ� �������� �ۼ��Ͻÿ�
SELECT TRUNC( SYSDATE-TO_DATE('2025/01/01', 'YYYY/MM/DD')) FROM DUAL;

-- TO_NUMBER : ���������� ��ȯ�Ѵ�
SELECT '1000'+'2000' FROM DUAL;
SELECT TO_NUMBER ('10,000', '999,999' ) + TO_NUMBER ('20,000', '999,999') FROM DUAL;

-- �Ϲ� �Լ�
-- NVL, DECODE, CASE

SELECT NVL (NULL, 3) + 0 FROM DUAL;
SELECT ENAME, SAL, COMM, NVL(COMM, 0), JOB FROM EMP;

-- ������ ����ϱ� ���ؼ� �޿��� 12�� ���ϰ�, Ŀ�̼��� ����
SELECT ENAME, SAL, COMM, SAL*12, SAL*12+NVL(COMM, 0) FROM EMP;

-- ��� ����� �ڽ��� ����� �ִ�, �׷��� ������̺� �����ϰ� ����� ����
-- ���� ���� �Ѵ�. �� ����� MGR �÷����� NULL�̴�, ����� ���� �����
-- ����ϵ�, MGR �÷����� NULL ��ſ� CEO�� ����Ͻÿ�.
SELECT ENAME, SAL, NVL((TO_CHAR(MGR, '9999')), 'CEO') FROM EMP WHERE ENAME = 'KING';

-- DECODE : ���ǹ� (���ǿ� ���� ��쿡 ó���ϴ� �Լ�)
/* ����
    DECODE (ǥ����, ����1, ���1,
                   ����2, ���2,
                   ����3, ���3,
                   �⺻ ��� N)
*/
SELECT * FROM DEPT;
SELECT * FROM EMP;

SELECT DEPTNO, 
    DECODE (DEPTNO, 10, 'ACCOUNTING',
                    20, 'RESEARCH',
                    30, 'SALES',
                    40, 'OPERATIONS') AS DNAME FROM EMP;

/*
    ���ǿ� ���� ���� �ٸ� ó���� ������ case �Լ�
    
    case ǥ���� when ����1 then ���1
               when ����2 then ���2
               when ����3 then ���3
               when ����4 then ���4
               else ��� n
               end
*/
select ename, deptno,
        case when deptno = 10 then 'ACCOUNTING'
            when deptno = 20 then 'RESEARCH'
            when deptno = 30 then 'SALES'
            when deptno = 40 then 'OPERATIONS'
        end DNAME
from emp;

/* ���޿� ���� �޿��� �λ��Ѵ�
    �����, �����ȣ, ����, �޿��� ����Ѵ�
    ������ 'ANAIYST' => 5%
          'SALESMAN' => 10%
          'MANAGER' => 15%
          'CLERK' => 20% �λ�
          decode �Լ��� �̿��ؼ� �ϼ��϶�
           SAL*12, SAL*12+NVL(COMM, 0) FROM EMP;
*/
SELECT ENAME, deptno, job,
    decode (job, 'clerk', sal *1.20,
                'MANAGER', SAL * 1.15,
                'SALESMAN', SAL * 1.10,
                'ANALYST', SAL * 1.05,
                SAL) AS "�޿��λ�" from emp;
                
SELECT ENAME, JOB,
    CASE WHEN JOB = 'CLERK' THEN SAL * 1.20
        WHEN JOB = 'MANAGER' THEN SAL * 1.15
        WHEN JOB = 'SALESMAN' THEN SAL * 1.10
        WHEN JOB = 'ANALYST' THEN SAL * 1.05
        ELSE SAL END AS "�޿��λ�" FROM EMP;
        

-- �׷� �Լ�
SELECT SUM (SAL) FROM EMP;
SELECT AVG (SAL) FROM EMP;
SELECT MAX (SAL) FROM EMP;
SELECT MIN (SAL) FROM EMP;
SELECT COUNT (COMM) FROM EMP;
SELECT COUNT (*), COUNT(COMM) FROM EMP;
SELECT COUNT(*), (COUNT (DISTINCT JOB)) FROM EMP;

-- ������� �����ȣ�� �������� �׷������
SELECT DEPTNO FROM EMP GROUP BY DEPTNO;
SELECT DEPTNO, SUM(SAL), AVG(SAL) FROM EMP GROUP BY DEPTNO;
SELECT DEPTNO, MAX(SAL), MIN(SAL) FROM EMP GROUP BY DEPTNO;

-- �μ����� ������� Ŀ�̼��� �޴� ��� ���� ���Ͻÿ�.
SELECT COUNT(*), COUNT(COMM) FROM EMP GROUP BY DEPTNO;

SELECT DEPTNO, AVG(SAL) FROM EMP GROUP BY DEPTNO HAVING AVG(SAL) >= 2000;
SELECT DEPTNO, MAX(SAL),MIN(SAL) FROM EMP GROUP BY DEPTNO HAVING MAX(SAL) > 2900;

/*
    [���� (JOIN)]
        �� �� �̻��� ���̺��� ���ϴ� ����� ��� ���� ���
        
    [���� ����]
        EQUI JOIN    : ������ �÷��� �������� ����
        NONEQUI JOIN : ������ �÷��� ���� ��� ����
        OUTER JOIN   : ���� ���ǿ� �������� �ʴ� �൵ ��� ��Ŵ
        SELF JOIN    : �� ���̺� ������ ���� 
        
    [������ �⺻ ��Ģ]
        1. �⺻ Ű�� �ܷ� Ű�� ���� �ٸ� ���̺��� ��� ����
        2. ���� Ű ������� ���̺�� ���̺��� ����
        3. where ������ ���� ������ �����
        4. ��Ȯ���� ���� �÷� �̸� �տ� ���̺� �� �Ǵ� ���̺� ��Ī�� �����
*/
select * from emp, dept; -- ũ�ν� ���� : 2�� �̻��� ���̺��� ���ε� �� ����� �÷��� ���� ����
select e.ename, d.dname 
from emp e, dept d 
where e.deptno = d.deptno 
and e.ename = 'SCOTT';

select * from salgrade;

select e.ename, e.sal, s.grade from emp e, salgrade s where e.sal between s.losal and s.hisal; 

-- outer join
--  ���� ���� ���ǿ� �������� ���� ��� �� ���� ����� ��Ÿ���� �ʰ� �Ǵµ�
--  �̶� ���� ���ǿ� �������� �ʴ� ��鵵 ����ϰ� �ϴ� ������ outer �����̶�� ��
select distinct (deptno) from emp;
select deptno from dept;
-- Outer Join�� �ϱ� ���ؼ� ����ϴ� ��ȣ�� (+) �̸� 
-- ���� ���ǿ��� ������ ������ �÷� �� �ڿ� ��ġ�ϰ� �ȴ�
select e.ename, d.deptno, d.dname from emp e, dept d where e.deptno(+)=d.deptno;
select e.ename from emp e;

-- self ���� : �ڱ� �ڽŰ� ������ �δ� ���� ����
select work.ename, manager.ename from emp work, emp manager where work.mgr = manager.empno;

-- ����� �̸��� ���� �Ŵ��� �̸��� ����ϴ� �������� �ۼ��Ͻÿ�.
select work.ename ||'�� �Ŵ�����', manager.ename || ' �̴�' as "���� �Ŵ���" from emp work, emp manager where work.mgr = manager.empno;
/*
    [�Ʒ��� ��� ������ ������ Ȱ���Ͽ� �������� �ۼ��Ͻÿ�.]
        1. ������� �̸�, �μ���ȣ, �μ��̸��� ����Ͻÿ�.
        2. �μ���ȣ�� 30���� ������� �̸�, ����, �μ���ȣ, ��ġ�� ����Ͻÿ�.
        3. Ŀ�̼��� �޴� ����� �̸�, Ŀ�̼�, �μ��̸� �� �μ� ��ġ�� ����Ͻÿ�.
        4. DALLAS�� �ٹ��ϴ� ����� �̸�, ����, �μ���ȣ, �μ��̸��� ����Ͻÿ�. (*join���� �� ��)
        5. �̸��� A�� ���� ������� �̸��� �μ� �̸��� ����Ͻÿ�.
        6. ��� �̸��� ����, �޿�, �޿� ���(salegrades)�� ����Ͻÿ�.
        7. ��� �̸�, �μ� ��ȣ�� �ش� ����� ���� �μ��� �ٹ��ϴ� ����� ����Ͻÿ�. (* self join���� �� ��)
*/
-- 1. ������� �̸�, �μ���ȣ, �μ��̸��� ����Ͻÿ�.
select e.ename, e.deptno, d.dname from emp e, dept d where e.deptno = d.deptno;

-- 2. �μ���ȣ�� 30���� ������� �̸�, ����, �μ���ȣ, ��ġ�� ����Ͻÿ�.
select e.ename, e.deptno, e.job, d.deptno, d.loc
from emp e, dept d
where e.deptno = d.deptno
and d.deptno = 30;

-- 3. Ŀ�̼��� �޴� ����� �̸�, Ŀ�̼�, �μ��̸� �� �μ� ��ġ�� ����Ͻÿ�.
select e.ename, d.deptno, e.comm, d.dname, d.loc 
from emp e, dept d where e.comm > 0;

-- 4. DALLAS�� �ٹ��ϴ� ����� �̸�, ����, �μ���ȣ, �μ��̸��� ����Ͻÿ�. (*join���� �� ��) -- �ٽ�
select e.ename, e.mgr, e.job, d.deptno, d.loc from emp e, dept d 
where e.deptno = d.deptno and d.loc = 'DALLAS';

-- 5. �̸��� A�� ���� ������� �̸��� �μ� �̸��� ����Ͻÿ�.
select e.ename, d.dname from emp e, dept d 
where e.deptno = d.deptno
and e.ename like '%A%';

-- 6. ��� �̸��� ����, �޿�, �޿� ���(salgrade)�� ����Ͻÿ�.
select e.ename, e.mgr, e.sal, s.grade from emp e, dept d, salgrade s;

-- 7. ��� �̸�, �μ� ��ȣ�� �ش� ����� '���� �μ��� �ٹ��ϴ� ���'�� ����Ͻÿ�. (* self join���� �� ��)
select e.ename, dname, e1.ename, e.deptno from emp e, emp e1, dept
where e.deptno = e1.deptno and e.deptno = dept.deptno;

select a.ename, dname, a.deptno, b.ename 
from emp a, emp b, dept where a.deptno = dept.deptno 
and a.deptno = b.deptno;