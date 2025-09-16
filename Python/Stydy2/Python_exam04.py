# if 문을 활용해 무지개 색상의 원을 그리는 프로그램을 구현하시오

import turtle

swidth, sheight = 800, 800
turtle.title('무지개 색상의 원 그리기')
turtle.shape('turtle')
turtle.setup(width = swidth + 50, height = sheight + 50)

turtle.screensize(swidth, sheight)
turtle.penup()
turtle.goto(0, -sheight / 2)
turtle.pendown()
turtle.speed(500)



for i in range(1, 500):
    if i % 6 == 0:
        turtle.pencolor('red')
    elif i % 5 == 0 :
        turtle.pencolor('orange')
    elif i % 4 == 0:
        turtle.pencolor('yellow')
    elif i % 3 == 0:
        turtle.pencolor('green')
    elif i % 2 == 0:
        turtle.pencolor('blue')
    elif i % 1 == 0:
        turtle.pencolor('indigo')
    elif i == 0 :
        turtle.pencolor('violet')

    turtle.circle(i)
    
turtle.done()