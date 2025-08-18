# 표준 라이브러리 (모듈) 사용해보기
import random #난수(랜덤 숫자)관련 라이브러리
import math #수학 관련 라이브러리 (*함수들이 포함되어 있엉)
import datetime #날짜와 시간 관련 라이브러리

#Random 모듈 생성
print("==== Random 모듈 ====")
# 특수의 난수를 생성(*정수로)
random_damage = random.randint(40, 60)
print(f"몬스터가 {random_damage}의 피해를 입혔습니다.")

#리스트 안에서 랜덤한 요소 하나를 선택
critical_hits = random.choice([True, False])
if critical_hits:
    print("Critical Hit!")

# Math 모듈 사용
print("\n==== Math 모듈 ====")
# 제곱근 계산
print(f"16의 제곱근: {math.sqrt(16)}")
# 올림
print(f"3.14의 올림 : {math.ceil(3.14)}")
# 내림
print(f"3.14의 내림 : {math.floor(3.14)}")

# Datetime 모듈 사용
print("\n==== DateTime 모듈 ====")
now = datetime.datetime.now() #현재 시간 저장
print(f"현재 시간: {now}")
print(f"현재 년도: {now.year}년")
print(f"현재 월: {now.month}월")
print(f"현재 일: {now.day}일")
print(f"현재 시: {now.hour}시")
print(f"현재 분: {now.minute}분")
print(f"현재 초: {now.second}초")
