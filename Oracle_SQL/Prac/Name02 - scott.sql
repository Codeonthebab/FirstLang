select * from tab;
desc emp; -- ���̺� ���� Ȯ��
select * from emp; -- emp ���̺��� ��� ����� �˻��϶�
select * from dept;
desc dept;
/*���� ���� Ư���� �˻��Ҷ�, from ������ �� �̸��� ���;���*/
select empno, ename from emp where deptno=20;
select * from emp order by empno desc; -- emp ���̺��� ��� ��� ��ȣ�� �������� �������� �˻��϶�
desc dept;
/*
    select
    - �����͸� ��ȸ�ϱ� ���� dml
    - ����
     select ���̸� or �÷��� from ���̺��;
*/ 
select * from tab; -- ���� �����ͺ��̽��� ����� ���̺��� ����϶� �� ���
show user;
-- dept ���̺��� ��� ������ ����Ͻÿ�.
select * from dept; -- ��� ���� ���
select * from emp;

-- �÷� �̸��� ��Ī �����ϱ�
-- �÷��� ����� ������ as��� Ű���带 �� �Ŀ� ��Ī�� ���
-- ��Ī�� �ο��� �� ���� ����, $._. # Ư�� ���ڸ� ǥ���ϰ� �Ͱų� ��ҹ��ڸ� �����ϰ� ���� ���
-- ���� ����(" ")�� ����Ѵ�. as�� �����ϰ� " " �� ����
select deptno as departmentNo, dname as departmentName from dept;
select deptno departmentNo, dname departmentName from dept;
select deptno "departmentNo", dname "departmentName" from dept;
select deptno "$no", dname "$name" from dept;
select deptno "�μ���ȣ", dname "�μ��̸�" from dept;

/*
�ߺ��� �����͸� �ѹ��� ����ϴ� ��ɾ�
distinct
ex) emp ���̺��� �÷� job(*��å)�� ǥ���ϵ� �ߺ��� ���� ��� �ѹ��� ����Ͻÿ�.
*/

select distinct job from emp;

/*
    where �������� �񱳿�����
    
    �񱳿�����
    =, >, <, >=, <=, [<>, !=, ^= (*���� �ʴ�. ǥ��)]
*/
select * from emp;
-- �޿��� 3000�̻� �޴� ����� ����϶�. (*������ �ۼ��ؼ� Ǯ������) 
select empno, ename, sal from emp where sal >= 3000;
-- �޿��� 3000�̸��� ����� ����϶�. (*������ �ۼ��ؼ� Ǯ������) 
select empno, ename, sal from emp where sal < 3000;

-- ������̺� �߿��� �μ���ȣ�� 10���� ����� ��� ������ ����Ͻÿ�.
select * from emp where deptno = 10;
-- ������̺��� �޿��� 2000�̸��� �Ǵ� ����� ���� �� �����ȣ, �̸�, �޿��� ����Ͻÿ�.
select empno, ename, sal from emp where sal < 2000;
/*
    [���� ������ ��ȸ]
  - ���� �����ʹ� �ݵ�� ��Ŭ ���� �ȿ� ǥ���ؾ� ��. 
  - ��ҹ��ڴ� �ݵ�� �����ؾ���
    [Ex]
  - �̸��� scott�� ����� ���Ͽ� �����ȣ, ����̸�, �޿��� ����Ͻÿ�.
*/
select empno, ename, sal from emp where ename = 'SCOTT';
-- �̸��� MILLER �� ����� ���Ͽ� �����ȣ, ����̸�, �޿��� ����Ͻÿ�.
select empno, ename, sal from emp where ename = 'MILLER';

/*
    [��¥ ������ ��ȸ]
    - �ݵ�� �̱� ���� �ȿ� ǥ���ؾ��Ѵ�. ������ '��/��/��' �������� �����
    [EX]
    - 1985�� ���Ŀ� �Ի��� ����� ����̸��� �Ի����� ����϶�.
    select ename, hiredate from emp where hiredate >= '85/01/01';
*/
select ename, hiredate from emp where hiredate >= '1985/01/01';

/*
    [�� ������]
    - and : �� ������ ��� �����ؾ���
    - or : �� ���� �� �ϳ��� �����ϸ� ��
    - not : ���ǿ� �������� ���ϴ� ��
*/
-- and �����ڴ� ���� ������ �����ؾ��ϴ� ��� ����Ѵ�
--  �μ� ��ȣ�� 10���̰�, ������ Manager�� ����� �̸�, ��ȣ, ������ ����Ͻÿ�.
select empno, ename, job from emp where deptno = 10 and job = 'MANAGER';
-- �޿��� 1000���� 3000���̿� �ִ� ��� ���
select empno, ename, job from emp where SAL >= 1000 and SAL <= 3000;
/*
    between and ������
    - Ư�� ���� ���� ���ϴ� �����͸� �˾ƺ����� �� �� ����ϴ� ������
        ���� : �÷��� between ���� and ����
*/
-- �޿��� 1000���� 3000���̿� �ִ� ��� ���
select empno, ename, SAL from emp where SAL between 1000 and 3000;

-- or ������ : �� ���� �� �Ѱ����� ������ ��쿡 �����
-- �μ���ȣ�� 10���̰ų� ������ MANAGER �� ����� �̸�, ��ȣ, ������ ����϶�.
select empno, ename,deptno,job from emp where deptno = 10 or job = 'MANAGER';
-- �����ȣ�� 7844�̰ų� 7654�̰ų� 7521�� ����� �̸�, ��ȣ, ������ ����϶�.
select empno, ename, job from emp where empno = 7844 or empno = 7654 or empno = 7521;

/*
    in ������ : ������ �÷��� ���� ���� �� ��, �ϳ������� �˾ƺ����� �� �� ����ϴ� ������.
        - ���� : �÷��� in (��1, ��2, ��3...);
*/
select empno, ename, sal from emp where empno in(7844, 7654, 7521) ; 

/*
    not : ���ǿ� �ݴ밡 �Ǵ� ������ ����
*/
 -- �μ� ��ȣ�� 10���� �ƴ� ����� �μ���ȣ, �̸�, ������ ����϶�.
 select ename, job, deptno from emp where not deptno = 10;
 -- �����ȣ�� 7844�̰ų� 7654�̰ų� 7521�� �ƴ� ����� �̸�, ��ȣ, ������ ����϶�.
 select empno, ename, job from emp where not empno in (7844,7654,7521);
 
 /*
    [LIKE ������]
    - �˻��ϰ��� �ϴ� ���� ��Ȯ�� �� ��� ���ϵ� ī��� ���� ����Ͽ�
      ���ϴ� ���� ������� ��� �����
        ���� : �÷��� LIKE ���� 
        
        [���ϵ� ī��]
        % : ���ڰ� ���ų� �ϳ� �̻��� ���ڰ� � ���� ���� ����� ����
            ** %�� �˻��ϰ��� �ϴ� ���� ��Ȯ�� �� ��� ����Ѵ�. **
            %�� ��� ���ڰ� ���� ����� ���ٴ� �ǹ�
            
        _ : �ϳ��� ���ڰ� � ���� ���� ��� ����
            �� ���ڴ�� ����ϴ� ����
 */
 -- % : -> K�� �����ϴ� ����� ������ ����Ͻÿ�.
 select ename, empno from emp where ename like 'K%';
 -- % : -> K�� ������ ����� ������ ����Ͻÿ�.
 select ename, empno from emp where ename like '%K';
 -- % : -> K�� ���� ����� ������ ����Ͻÿ�.
 select ename, empno from emp where ename like '%K%';
 
 -- _ : �̸��� �ι�° ���ڰ� A�� ����� ������ ����϶�
 select ename, empno from emp where ename like '_A%';
 -- �̸��� A�� �������� �ʴ� ����� ������ ����϶�
 select ename, empno from emp where ename not like '%A%';
 
 /*
    NULL �� ���� ������
    - ����Ŭ������ �÷��� null ���� ����Ǵ� ���� ����Ѵ�
      NULL�� ��Ȯ��, �� �� ���� ��, 0�� �ƴ� �� ������ �ƴ� � ����
      ���������� � ������ �� �� ���ٴ� �ǹ��̴�
      
    - null�� ����, �Ҵ�, �񱳰� �Ұ����ϴ�.
 */ 
 -- Ŀ�̼��� ���� ���� ����� ����Ͻÿ�.
 select ename, comm, job from emp where comm = null;
 -- null�� ����Ǿ� �ִ� ��쿡�� �� �����ڷ� ������ �� ����.
 /*
    [is null�� is not null �̶� �����ڰ� �ִ�]
    - Ư�� �÷� �������� ���� ��쿡�� �� �����ڸ� ���������
      null �� ��쿣 is null �����ڸ� ���
      null ���� �ƴ� ��쿣 is not null �����ڸ� ���
      
    is null : null �̸� ����
    is not null : null �̸� �������� ����
        - null�� ���� �ƴϹǷ� = �Ǵ� != ���� ���� �� ����.
 */
  select ename, comm, job from emp where comm is not null;
  
  -- �ڽ��� ���ӻ���� ���� ����� �̸��� ���ް� ���� ����� �����ȣ�� ����϶�.
  select empno, ename, mgr, job from emp where mgr is null;
  
  /*
    [������ ���� order by ��]
    order by ���� ���� �����ϴµ� ����ϸ�, ������ �� �ڿ� ����ϸ�, ������ ������ �Ǵ�
    �÷��� �ڿ� �Ǵ� select ������ ��õ� ��Ī�� ����� �� ����
         
            - ������ (ASC) -           - ������ (DESC)-
    ����      ���� �� ����                  ū �� ����
    ����      ���� ������                  ������ ��������
    ��¥      ���� ��¥ ��                 ���� ��¥ ��
    null  ���� �������� ���� null       ���� ���� ���� null
    
    �������� ��� �ҹ��ڸ� ���� ū ������, null ���� ��� �� �߿��� ���� ���� ������ �ν���
            
  */
  
  -- ASC : �����ȣ�� �������� �������� �����Ͻÿ�.
  select empno, ename from emp order by empno asc;
  -- DESC : �����ȣ�� �������� ������������ �����Ͻÿ�.
  select empno, ename from emp order by empno DESC;
  -- ASC : �޿��� �������� �������� �����Ͻÿ�.
  select empno, ename,SAL from emp order by SAL asc;
  -- �Ի����� ���� �ֱ��� ��� ������ ��ȣ, �̸�, �Ի����� ����϶�.
  select empno, hiredate, ename, SAL FROM EMP ORDER BY hireDATE DESC;
  
  select 24*60*60 from dual;
  DESC DUAL;
  -- �Ѱ��� ���ڸ��� ������ �� �ְ�, X��� ���� ���� �� �ϳ��� �ุ�� �����ϰ� �ִ�
  SELECT * FROM DUAL;
  
  