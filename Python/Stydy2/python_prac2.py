import turtle
import random

# 함수 선언
def screenLeftClick(x, y):
    global r, g, b
    turtle.pencolor((r, g, b))
    turtle.pendown()
    turtle.goto(x, y)

def screenRightClick(x, y):
    turtle.penup()
    turtle.goto(x, y)
    
def screenMidClick(x, y):
    global r, g, b
    tSize = random.randrange(1, 10)
    turtle.shapesize(tSize)
    r = random.random()
    g = random.random()
    b = random.random()
    

# 변수 선언 부
pSize = 10
r, g, b = 0.0, 0.0, 0.0
#t = None
screen = turtle.Screen()
screen.title("거북이로 그림 그리기")
t = turtle.Turtle()
t.shape("turtle")
t.pensize(pSize)
#screen = turtle.Screen()
t.speed(1)

#view_padding = 100

# for i in range(50):
#     t.forward(i * 2)
#     t.left(i+1)
#     t.forward(i / 2)
#     t.left(20)
    
#     x, y = t.position()
    
    # screen.setworldcoordinates(
    #     x - view_padding, y - view_padding,
    #     x + view_padding, y + view_padding
    # )
    # screen.update()

screen.onscreenclick(screenLeftClick, 1)
screen.onscreenclick(screenMidClick, 2)
screen.onscreenclick(screenRightClick, 3)

turtle.done()

