"""
@(at_sign)문법 제공(*@데코레이터 이름)
- 적용하고 싶은 함수위에 붙이면 됨
"""

def my_decorator(func):
    def wrapper():
        print("-----아직 함수 실행 전-----") #기능 추가
        func() #원본 함수 실행
        print("-----함수 실행 후-----") #기능 추가
    return wrapper #wrapper 함수 반환

@my_decorator #이렇게 하면 아까의 decorated_hello = my_decorator(say_hello)와 동일
def say_hello():
    print("Re! Hello!")

say_hello()