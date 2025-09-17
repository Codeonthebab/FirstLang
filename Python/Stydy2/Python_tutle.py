'''
거북이가 화면에 별을 계속 그리도록 프로그램을 구현하시오.
 - 별의 한 변은 10 ~ 200 사이
 - 위치, 색은 랜덤으로 구현
'''

import turtle
import random

swidth, sheight, pSize = 500, 500, 2
r, g, b, dist = [0.0] * 4

turtle.title('별 그리기')
turtle.shape('turtle')
turtle.pensize(pSize)

turtle.setup(width=swidth+30, height=sheight+30)
turtle.screensize(swidth, sheight)

while True :
    r = random.random()
    g = random.random()
    b = random.random()
    
    turtle.pencolor((r, g, b))
    starLen = random.randrange(10, 200)
    x = random.randrange(-250, 250)
    y = random.randrange(-250, 250)
    turtle.penup()
    turtle.goto(x, y)
    turtle.pendown()
    for i in range(5):
        turtle.forward(starLen)
        turtle.left(144)

turtle.done()