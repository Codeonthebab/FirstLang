# 거북이를 이용해서 2진수 숫자로 표현하시오.
# 십진수 -> 682 => 이진수 : 1010101010

import turtle

# 변수 선언부
num = 0
swidth = 1000
sheight = 300

curX, curY = 0, 0

# 메인 선언부
turtle.title('거북이로 2진수 표현하기')
turtle.shape('turtle')
turtle.setup(width = swidth+50, height = sheight + 50)
turtle.screensize(swidth, sheight)
turtle.penup()
turtle.left(90)

num = int(input("숫자를 입력하세요 : "))
binary = bin(num)
curX = swidth / 2
curY = 0

for i in range(len(binary)-2):
    turtle.goto(curX, curY)
    
    if num % 2 == 1:
        turtle.color('red')
        turtle.turtlesize(3)
    else:
        turtle.color('blue')
        turtle.turtlesize(1)
    turtle.stamp()
    curX -= 50
    num >> 1
          

print("이진수 : ", binary)

turtle.done()
