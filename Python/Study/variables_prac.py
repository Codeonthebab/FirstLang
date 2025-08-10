#variables_practice 변수 관련 파이썬 공부

age = 23
name = "민수"

print("이름" , name)
print("나이", age)

# 변수 값, 자료형 확인해보기
student_id = 2176000 #int (정수)    (*학번으로 해봤다)
gpa = 4.2           #float (실수, 소수점이 있는 숫자)     (*학점)
is_student = True    #bool (블리언boolean, 참/거짓일때 쓰는거)
course_name = "개발"    #str (*String, 문자열) 

print (student_id, type(student_id))
print (gpa, type(gpa))
print (is_student, type(is_student))
print (course_name, type(course_name))

#위 변수들을 활용해서 문장 출력해보기
intro_message = f"안녕하십니까, 제 이름은 {name}이고 {age}살입니다. 지금은 '{course_name}' 과목을 수강 중 입니다."

print(intro_message)