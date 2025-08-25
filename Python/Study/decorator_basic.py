#decorator는 '함수를 인자로 받는 함수'의 원리
"""
1. 기능을 추가할 함수 func를 인자로 받음
2. 해당 함수를 감싸는 새로운 함수(wrapper)를 내부에서 정의
3. wrapper 함수에서 'func()'를 호출 -> 원본 함수 실행 -> 기능 추가 순으로 코드 작성
4. wrapper 함수를 반환 시킴
"""
def my_decorator(func):
    def wrapper():
        print("-----아직 함수 실행 전-----") #기능 추가
        func() #원본 함수 실행
        print("-----함수 실행 후-----") #기능 추가
    return wrapper #wrapper 함수 반환

def say_hello():
    print("Hello!")

#decorator을 적용 시킴 (수동)
decorated_hello = my_decorator(say_hello)
decorated_hello() #wrapper 함수를 실행시킴