-------------------------- VIEW START -------------------------
/*
    [VIEW]
     - ���ٶ� �ǹ̸� ���� �ִ�.
        ���� ���̺�(�������̺�)�� ����� �����͸� �並 ���ؼ� �� �� �ֵ��� �Ѵ�
        ��� ���� ���̺��̰� �̴� ���� ���̺�� ���� �����ϰ� �����
        
    [VIEW�� ��� ����]
        1. �������� ���̺� ������ �����ϱ� ���� ����Ѵ�.
        2. ������ ���Ǹ� ���� ����� ���ؼ� ����Ѵ�.
        
    [VIEW�� Ư¡]
        1. ��� ���̺� ���� ������ ������ ���̺��� ������ �κи� ���� �� �ִ�
            ������ ���̺��̴�.
        2. ��� ���� �ڷḦ ������ ������, �並 ���ؼ� ���̺��� ������ �� �ִ�.
        3. �ϳ��� ���̺� ���� ������ ������ ����.
        
    [�⺻ ���̺�] 
        1. �信 ���ؼ� ���������� �����ؼ� ����ϴ� ���������� �����͸� �����ϰ�
            �������� ���̺��� ���Ѵ�
        
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

/*  [VIEW ����]
        - ��� ���̺�ó�� �ϳ��� ��ü�μ� ���̺��� ������ ���� 
             �����ϰ� create view ������� �����Ѵ�. 
       ** CREATE [OR REPLACE] [FORCE] [NOFORCE] VIEW VIEW_NAME
            AS SUBQUERY
            WITH CHECK OPTION
            WITH READ ONLY; -- �б⸸ �����ϴ�. 
            (*��ȸ(SELECT)�� �����ϴ� ��, insert/update/delete ��� ���ȵ�)
       
       ** [OR REPLACE]
        - ���ο� �並 ���� �� ���� �Ӹ� �ƴ϶�, ������ �䰡 �����ϴ��� 
            �������� �ʰ� ���ο� ������ ��� ������ �� �ִ�.
       
       ** [FORCE],[NOFORCE]
        - �⺻ ���̺��� ���� ���ο� ������� �並 �����Ѵ�.
       
       ** [WITH CHECK OPTION]
        - �ش� �並 �� �� �ִ� 
*/

create view view_emp10
as select empno, ename, sal, deptno from emp01
where deptno=10;

select * from view_emp10;

-- �並 �ۼ��� �� ����� ���� �������� ��� �ۼ��Ǿ� �ִ����� Ȯ����
/* [USER_VIEWS -> ������ ��ųʸ�]
        - ����ڰ� ������ ��� �信 ���� ���� ����Ǿ� ����
            ���� �̸��� ���� VIEW_NAME, ���������� Ȯ���� �� �ִ�.
*/

select VIEW_NAME, TEXT FROM USER_VIEWS;

/* [VIEW�� ���� ����]
    - ����ڰ� �信 ���ؼ� ���Ǹ� �ϸ� user_views���� �信 ���� ���Ǹ� ��ȸ�Ѵ�.
    - �⺻ ���̺� ���� ���� ���� ���� ���ɴ�.
    - �信 ���� ���Ǹ� �⺻ ���̺� ���� ���Ǹ� ��ȯ�Ѵ�.
    - �⺻ ���̺� ���� ���Ǹ� ���� �����͸� �˻��Ѵ�.
    - �˻� ����� ����Ѵ�.
    
    [VIEW�� ����]
    - �ܼ��� (�⺻���̺��� 1��)�� ���պ� (�⺻���̺��� 1���̻� : �ּ� 2��)
    ------------------------------------------------------------------------
            ** �ܼ� VIEW **                     ** ���� VIEW **
          �ϳ��� ���̺�� ����                    �������� ���̺�� ����
        �׷� �Լ��� ����� �Ұ�����               �׷��Լ��� ����� ������
        distinct ����� �Ұ��� ��               distinct ����� ������
DML(insert/update/delete)�� ��� ����     DML(insert/update/delete)�� ��� �Ұ�����
    ------------------------------------------------------------------------            
*/
-- �ܼ��� DML (insert/update/delete)�� ��밡��
insert into view_emp10 values(8000, 'angel', 7000, 10); 
-- VIEW�� �����ϸ� �⺻ ���̺� ������ ��ģ��.
DELETE FROM VIEW_EMP10 where EMPNO=8000;
select * from view_emp10; 
select * from emp01;

-- �並 ������� ������ DML ����� �⺻ ���̺� ������ ��ģ��.
-- �ܼ� �信 �÷��� �ѱ۷� ������ �� �ִ�.
CREATE OR REPLACE VIEW VIEW_EMP10(�����ȣ, �����, �޿�, �μ���ȣ)
AS SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP01;    -- �ѱ۷� �б��� �ֱ� �� ����

-- �÷��� ��Ī�� ����ؼ� �並 �����ϴ��� �⺻���̺��� �÷����� ������ ���� ���Ѵ�.
select * from emp01;

-- ���� ��
-- �μ��� �޿� �Ѿװ� ����� ���ϴ� �۾��� ��� ������ ����.
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
-- �����
-- �並 �����ϴ� ���� ���� ���̺��̱� ������ USER_VIEWS�� ����� ���� ���Ǹ� �����ϴ� ����
DROP VIEW VIEW_SAL;
SELECT VIEW_NAME, TEXT FROM USER_VIEWS;

/* �� ���� : or REPLACE
        �⺻���̺��� ���� �並 �����ϱ� ���� force �ɼ�
            - �⺻ ���̺��� ������ �並 ������ �� �ִ�.
*/
select * from tab;
CREATE OR REPLACE FORCE VIEW VIEW_NOTBLE
as select empno, ename, deptno from emp20 where deptno=10;
select * from view_notable;

/*  [WITH CHECK OPTION]
        - �� ���� �� �������� ������ �÷� ���� �������� ���ϵ��� �ϴ� ����
*/
CREATE OR REPLACE VIEW VIEW_CHK20
as SELECT empno, ename, sal, comm, deptno from emp01 where deptno=20 with check option;

UPDATE VIEW_CHK20 SET DEPTNO=10 WHERE SAL >= 5000;
-- �޿��� 5000�̻��� ����� 10�� �μ��� �̵��϶�
select * fROM view_chk20;
-- with read only : �⺻ ���̺��� � �÷��� ���ؼ��� ������ ���� ������ �� ����.
CREATE OR REPLACE VIEW VIEW_READ30
AS SELECT EMPNO, ENAME, SAL, COMM, DEPTNO FROM EMP01 
WHERE DEPTno=30 WITH READ ONLY;
UPDATE VIEW_READ30 SET COMM=1000;

------------------------------- END VIEW ----------------------------

--------------------SEQUENCE----------------------
/* �������� ������ ���� �������ִ� ����Ŭ ��ü��.
    �������� �����ϸ� �⺻Ű�� ���� ���������� �����ϴ� �÷��� �ڵ������� ������ �� �ְ� �Ѵ�.
    
    [������ ���� ����]
    CREATE SEQUENCE ��������
    START WITH N
    INCREMENT BY N
    MAXVLAUE N / NOMAXVALUE
    MINVALUE N / NOMINVALUE
    CYCLE / NOCYCLE
    CACHE N / NOCACHE;
    
    START WITH N
      - �������� ���� ���� ����
    INCREMENT BY N
      - �������� ���� ���� ����
    MAXVLAUE N / NOMAXVALUE
      - �ִ� ���� ���� / ���Ѵ��
    MINVALUE N / NOMINVALUE
      - �ּ� ���� ���� / ���� ��
    CYCLE / NOCYCLE
      - �ִ� ������ �����ϸ� �ٽ� �ּ� ������ ����
        �⺻ ����Ʈ ���� NOCYCLE (* �������� ���� ��� �ڵ����� ��)
    CACHE N / NOCACHE;
      - �޸� ���� ������ ���� ����
        �⺻ ���� 20��
        ��Ģ������ �� ����Ŭ�̶� �������� ����(NOCACHE).
*/
-- ���� 1�̰�, 1�� ����, �ִ� ���� 100��(1,000,000)���� �Ǵ� �������� �����϶�.
CREATE SEQUENCE EMP_SEQ
START WITH 1
INCREMENT BY 1
MAXVALUE 1000000;

DROP TABLE EMP01;
CREATE TABLE EMP01
as SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE 1=0;
SELECT * FROM EMP01;
insert into emp01 values (emp_SEQ.NEXTVAL, 'JULIA', SYSDATE);
-- CURRVAL : �������� ���簪�� ��ȯ
select emp_seq.currval from dual;

-- NEXTVAL : ���� ������ ���� �������� ��ȯ

/*
    [CURRVAL, NEXTVAL�� ����� �� �ִ� ���]
        - SUBQUERY�� �ƴ� SELECT��
        - INSERT ���� SELECT ��
        - INSERT ���� VALUES ��
        - UPDATE ���� SET ��
    [CURRVAL, NEXTVAL�� ����� �� ���� ���]
        - VIEW�� SELECT ��
        - DISTINCT Ű���尡 �ִ� SELECT ��
        - GROUP BY, HAVING, ORDER BY ���� �ִ� SELECT ��
        - SELECT, DELETE, UPDATE�� ���� ����
        - CREATE TABLE, ALTER TABLE ����� �⺻ ��
    
    [�������� ���� & ����] 
        ** ������ ���� ���� **
        ALTER SEQUENCE ������ ��
        START WITH N
        INCREMENT BY N
        MAXVALUE N / NOMAXVALUE
        MINVALUE N / NOMINVALUE
        CYCLE / NOCYCLE
        CACHE N / NOCACHE
        
    [�������� ����]
        DROP SEQUENCE ��������;
*/
