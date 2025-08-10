#lists_and_loops
#for, list가 파이썬에서 아래와 같이 쓰임

# 리스트 생성해보기
students = ["정수", "민수", "영희", "찰스"]
print (f"학생 명단 : {students}")

#인덱싱 : 자바와 동일하게 0부터 시작
first_student = students[0]
print(f"첫 번째 학생 : {first_student}") #students 리스트 안에서 0 []"정수"]에 있는 것을 꺼내옴

#append() 메소드 : 리스트의 맨 끝에 새로운 요소를 넣을 때
students.append("토마스")
print(f"새로운 학생 추가 후 명단 : {students}")

#len() 함수 : 리스트의 길이(리스트의 요소 갯수) 확인, 자바에서 length() 친구랑 같은 함수?
num_of_students = len(students)
print(f"현재 학생 수 : {num_of_students}명")

print("-"*50) #구분선

#for 반복문
print("--- 학생 명단 출력 ---")
for student in students : #for 요소 in 위에서 선언한 list명 
    #students리스트에서 student 변수에 담음
    print(f"-{student}") #student 변수에 담은걸 출력

print("-"*50)

# for-if
scores = [ 95, 78, 95, 100, 62, 45 ]
passing_score = 70

print (f"---{passing_score}점 이상, 합격 점수 출력---")
for score in scores :
    if score >= passing_score :
        print(f"합격 점수 : {score}점")

# range() 함수 : Java for(int i = 0; i < x; i++) 코드와 동일한 함수
print("--- range() 함수 ---")
for i in range (5) :
    print(f"{i+1}번째 반복")
