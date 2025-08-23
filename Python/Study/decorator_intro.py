# 함수는 '일급 객체'다!
# - 변수에 할당할 수 있다
# - 다른 함수의 인자(argument)로 전달할 수 있다
# - 다른 함수 안에서 생성하고 반환(return)할 수 있다.

def say_hello():
    return "Hello!"

#함수를 변수에 할당
greet = say_hello
print(greet()) # Hello!

# 함수를 다른 함수의 인자로 전달
def process_greeting(func):
    print(f"함수 실행 결과 : {func()}")

#say_hello 함수 자체를 전달시킴
process_greeting(say_hello) 