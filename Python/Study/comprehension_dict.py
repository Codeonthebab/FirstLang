from mid_bar import mid_bar

# for문으로 먼저 컴프리헨션할거 
students = ["민수", "철수", "영희", "정수", "하나"]
name_length = {} #빈 딕셔내리

for student in students:
    name_length[student] = len(student) #key와 value 값을 할당

print(name_length) #for문으로 만든 딕셔내리 출력

mid_bar().print_bar()

# 딕셔너리 컴프리헨션으로 만들기
students = ["민수", "철수", "영희", "정수", "하나"]
#{key 표현식 : Value 표현식 for 변수 in 기존 리스트}
name_length = {student: len(student) for student in students}
print(name_length) #딕셔너리를 컴프리헨션으로 만든 결과 출력
# 결과물은 {'민수': 2, '철수': 2, '영희': 2, '정수': 2, '하나': 2}
