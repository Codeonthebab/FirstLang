#conditions_prac 
#if-elif-else 연습

# 기본 산술 연산자
x = 10
y = 3

print(f"{x}+{y} = {x+y}") #+
print(f"{x}-{y} = {x-y}") #-
print(f"{x}*{y} = {x*y}") #*
print(f"{x}/{y} = {x/y}") #/ 나누기임
print(f"{x}//{y} = {x//y}") #// 몫 (나눈 후에 소수점을 버린다)
print(f"{x}%{y} = {x%y}") #% 나누고 난 후 나머지 값
print(f"{x}**{y} = {x**y}") #** 거듭제곱 x를 y번 (Ex : 10*10*10)

print("-"*50) #구분석 출력해봄

# 비교 연산자
score = 85
passing_score = 90

print (f"점수가 합격 기준과 같은가? {score == passing_score}") #같음을 표기 ===
print (f"점수가 합격 기준과 다른가? {score != passing_score}") #안 같음을 표기 !=
print (f"점수가 합격 기준보다 높은가? {score > passing_score}") #패싱스코어보다 스코어가 더 크단 뜻
print (f"점수가 합격 기준과 이상인가? {score >= passing_score}") #기준 이상 표기

print("-"*50) #구분석 출력해봄

# 연산자를 활용해서 조건문 써보기
my_score = 80
grade = '' #등급을 잠시 넣어서 사용한 변수

if my_score >= 90 :  #자바와 다르게 중괄호 { } ; 등으로 만드는 것이 아닌 :(콜론)으로 로컬을 결정
    grade = 'A'
elif my_score >= 80 :
    grade = 'B'
elif my_score >= 70 :
    grade = 'C'
else :
    grade = 'F'

print(f"당신의 점수는 {my_score}점이고, 등급은 '{grade}'입니다.")

print("-"*50) #구분석 출력해봄

#연산자 코드로 특정 학생의 학점 점수, 출석율, 등급 표시해보기

name = "정수"
age = 30
course_name = "개발"
score = 60
attendance_rate = 0.98 #98퍼센트

if score >= 60 :
    print(f"정보처리기사 필기 부문 {score}점으로, {name}님(*{age}살)은 합격입니다. (*교육과정 출석율 {attendance_rate})")