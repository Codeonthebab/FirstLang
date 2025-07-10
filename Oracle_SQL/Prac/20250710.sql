select * from tab;
/*
    [DML]
    - ���̺� ������ �߰�, ����, ����
    
    [���̺� ���ο� ���� �߰��ϴ� insert ��]
        1. Ư�� �÷����� �����͸� �Է��ϴ� ���
            ���� : insert into ���̺�� (�÷���1, �÷���2, ..�÷���n) 
                   values (��1, ��2, .., ��n );  <<<�� �÷��� �����ϴ� ���� �������
        
        2. ��� �÷��� �����͸� �Է��ϴ� ���
            ���� : insert into ���̺�� values (��1, ��2, .. ��n);

*/

-- dept01 ���̺� ����
desc dept;
create table dept01 (  -- ���̺� ����
deptno number (2),
dname varchar2 (14),
loc varchar2 (13));
select * from dept01; -- ���̺� �����Ѱ� Ȯ��
drop table dept01; -- ���̺� ����
-- �μ���ȣ 10, �μ��̸� ACCOUNTING ���� NEW YORK (���̺� ������ �� �Է�)
insert into dept01 values (20, 'RESEARCH', 'DALLAS'); 
insert into dept01(deptno, dname, loc) values (10, 'ACCOUNTING', 'NEW YORK');
show user;
insert into dept01 select * from dept;
delete from dept01;
insert into dept01 (deptno, dname) values (10, 'ACCOUNTING'); -- �Ͻ��� null �� ����
insert into dept01 (deptno, dname, loc) values (20, 'RESEARCH', null); -- ����� null �� ����
insert into dept01 (deptno, dname, loc) values (30, 'SALES', ''); -- ����� null�� ����

/*
    [���̺� ������ �����ϱ� ���� update]
    ** ���� **
        - update ���̺�� set �÷��� = ��, where ����
*/

select * from emp01;
create table emp01 as select * from emp; -- ���� ������ �̿��� emp���̺��� emp01�� ���ܿ�

-- ��� ����� �μ���ȣ�� 30������ �����Ͻÿ�.
update emp01 set deptno = 30; -- ��� �����͸� �ϰ� ������ ��� ������ ���� ����
rollback;

-- ��� ����� �޿��� 10% �ø� ������ �����Ͻÿ�
update emp01 set sal = sal*1.1;

-- ��� ����� �Ի����� ���÷� �����Ͻÿ�.
update emp01 set hiredate = sysdate;

-- Ư�� �ุ ���� : update ���� where ���� �߰��ϸ� �ȴ�
-- �μ� ��ȣ�� 10���� ����� �μ� ��ȣ�� 30������ �����Ͻÿ�.
update emp01 set deptno = 30 where deptno = 10;

-- �޿��� 3000�̻��� ����� �޿� �λ� 10���� �λ��Ͻÿ�.
update emp01 set sal= sal*1.1 where sal >= 3000;

-- 1987�⿡ �Ի��� ����� �Ի����� ���÷� �����Ͻÿ�.
update emp01 set hiredate = sysdate where substr (hiredate, 1 , 2) = 87;

-- ���̺��� �ΰ� �̻� ������ ������ �޸��� �����ؼ� �����Ѵ�
/*
    [���̺��� 2�� �̻��� �÷� �� ����]
        - ���̺��� �ϳ��� �÷��� �ƴ� �������� �÷����� �����Ϸ���
          ���� set ���� �޸�(,)�� �߰��ϰ�, [�÷� = ��]�� �߰� ����ϸ� �ȴ�
*/
-- scott ����� �μ���ȣ�� 10��, ������ manage�� ����
update emp01 set deptno = 10, job = 'MANAGE' where ename = 'SCOTT';
select * from emp01;

-- scott�� �Ի����� ���÷�, �޿��� 50, Ŀ�̼� 4000 �� ����
update emp01 set hiredate = sysdate, sal = 50, comm = 4000 where ename = 'SCOTT';

/* 
    [���̺� ���ʿ��� ���� �����ϱ� ���� delete]
     **����** 
        - Ư�� �������� ����
         delete from ���̺�� where ����
        - ��� �����͸� ����
         delete from ���̺��
*/
select * from tab; -- ��ü ���̺� Ȯ��
select * from dept01;
delete from dept01; -- ��� ������ ����
rollback;
delete from dept01 where deptno = 30; -- Ư�������� '�μ���ȣ 30��'�� ����
/*   -- delete �� truncate ����� ������
    [delete]
          1. delete ��ɾ ����Ͽ� ���� ������ ��� ���� ������ 
             ���� ������ ������ ���� �ڿ��� �Ҹ�ȴ�.
          2. delete ����� ���� ���� ���·� ���� ������ �� �ִ� ��츦 �����ؼ�
             rollback ������ �����ϰ� �ֱ� ������
            
    [truncate]
          1. DDL ��ɹ����� rollback �� �� ����
          2. rollback ������ ������ �ʰ� ��� commit �ϱ⿡ ������
             ȿ������ ����̴�
*/
/*  ** Ʈ�����
    - ������ ���̽����� �����͸� ó���ϴ� �ϳ��� ������ �۾������� �ǹ�
    - Ʈ������� insert, update, delete ����� �޸𸮻󿡸� ����Ǵٰ�
      Ư�������� �ϵ��ũ�� ���� ������ �����ͺ��̽��� ����Ǵ� ������ �ǹ���
        
    [commit�� rollback]
    - commit : ��� �۾����� ���������� ó���ϰڴٰ� Ȯ���ϴ� ��ɾ�� 
                Ʈ������� ó�� ������ �����ͺ��̽��� ��� �ݿ��ϱ� ���ؼ�
                ����� ������ ��� ���� �����Ѵ�
            ** commit ��ɾ �����ϰ� �Ǹ� �ϳ��� Ʈ����� ������ ����� **
        
    - rollback : �۾� �� ������ �߻��Ǿ Ʈ����� ó�� �������� ����� ������ ����ϴ� ��ɾ�
            ** rollback ��ɾ� ���� Ʈ����ǰ� ������ �����ϰ� �ȴ� **
            ** rollback�� Ʈ��������� ���� �ϳ��� ���� ó���� ���۵Ǳ� ���� ���·� �ǵ��� **
                    ���� DNL ��ɾ���� �ϳ��� ������ �۾������� Ʈ��������� ���� �� ����
                    ���������� ������ Ŀ�� ��� ���ĺ��� ���ο� Ŀ�� ����� �����ϴ� ��������
                    ����� ��� DML ��ɾ �ǹ��Ѵ�
                    
    ����
    1. �������� ���Ἲ�� �����Ѵ�.
    2. ���������� ���� ���� �������� ��������� Ȯ�� �� �� �ִ�
    3. �������� ������ �۾��� ���ȭ�� �� �ִ�
    
    ** rollback ��ɾ�� ���� commit�� �������� �����ȴ� **
    
    - �ډ� commit ��ɰ� �ڵ� rollback ����� �Ǵ� ���
        SQL PLUS�� ���������� ����Ǹ� �ڵ����� commit�ǰ�
        ������������ ����Ǹ� �ڵ����� rollback ��    
*/

drop table dept01; -- dept01 ���̺� ����
create table dept01 -- dept ���ο� ���̺� ����
as select * from dept;
select * from dept01;
delete from dept01;
select * from dept01;
rollback;
select * from dept01;

-- �μ���ȣ 20�� ����� ���� ������ ����
delete from dept01 where deptno=20;
select * from dept01;
commit;
rollback;

-- Ŀ�� ���Ŀ��� rollback ��ɾ�� �ƹ� �ҿ��� ����.
/*
    [���Ἲ ���� ������ ����� ����]
        - ���Ἲ ��� ������ �����͸� �߰�, ����, �����ϴ� �������� 
            ���Ἲ�� ������ �� �ֵ��� ������ �ִ� ���� ���Ѵ�
        - ���Ἲ�̶� �����ͺ��̽� ���� �������� Ȯ�强�� �����ϴ� ���� �ǹ��ϰ�
            ���������̶� �ٶ������� ���� �����Ͱ� ����Ǵ� ���� ���� �ϴ� ���� ����
    
    [���Ἲ ����]
        ** not null : null�� ������� �ʴ´�
        ** unique : �ߺ��� ���� ������� �ʴ´�, �׻� ������ ���� ������ �Ѵ�
        ** primary key : not null �� unique�� ������ �� ����
                            ��, null�� ���X, �ߺ��� ��x
        ** foreign key : �����Ǵ� ���̺��� �÷��� ���� �����ϸ� ���
        ** check : ���� ������ �������� ���� ������ ������ �����Ͽ� ������ ������ ���        
*/
-- not null ��������
drop table emp01;
-- �����, �����ȣ, ����, �μ���ȣ�� ������ ���������� ���� emp01 ���̺��� ����
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
insert into emp02 values (null, null, 'SALESMAN', 30); --���� ���̺� ���ǿ� not null�� ���ԵǾ��� ������ ����(insert) �ȉ�
insert into emp02 values (7399, 'RINOUE', 'SALESMAN', 30);
select * from emp02;

create table emp03 (
empno number (4) unique, -- �ߺ� ������� �ʁٴٴ� ��
ename varchar2 (10) not null,
job varchar2 (9) ,
deptno number (2)
);
insert into emp03 values (7399, 'RINOUE', 'SALESMAN', 30);

create table emp04 (
empno number (4) unique not null, -- �ߺ� ������� ����, null ���� ������� ����
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

/* [�������� Ȯ��]
    �������� (constraints)�� ���� �޼����� ���� ��Ȯ�� ������ �˱� ���ؼ�
    ����Ŭ���� �������ִ� user_constraints ������ ��ųʸ��� �ִ�
    ���� ���Ǹ�, ������������, ���������� ���� ���̺��
*/
-- ���� ���� Ȯ��
select constraint_name, constraint_type, table_name from user_constraints where table_name = 'EMP05';
/*
    [constraint_type�� P, R, U, C 4������ ����
    P : primary key
    R : foreign key
    U : Unique
    C : check not null
*/
-- ���� ������ ������ �÷������� Ȯ��
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

drop table emp05; -- ���̺� ����
-- Emp01 ���� ã��
SELECT deptno, COUNT(*)  -- dept01 ���̺��� �߰��� ī��Ʈ �� Ȯ��
FROM dept01
GROUP BY deptno
HAVING COUNT(*) > 1;

DELETE FROM dept01 a  -- dept01 ���̺��� ��� �� ����
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
-- �θ� ���̺� 50���� �μ���ȣ�� �������� �ʱ� ������ �ȉ�
insert into emp05 values(7499, 'ALLEN', 'SALESMAN', 30);
select * from emp05;
select constraint_name, constraint_type, table_name, r_constraint_name from user_constraints where table_name = 'EMP05';

/* check ���� ����
    - �ԷµǴ� ���� üũ�Ͽ� ������ �� �̿��� ���� ������ �����޼����� �Բ� ������ ���Ѵ�.
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
    [���� ���Ǹ� ����]
      **���� ���Ǹ� ����Ģ**
       [���̺�]_[�÷���]_[������������]
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