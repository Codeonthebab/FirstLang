import turtle
import math
import random

# 변수 선언부
t1, t2, t3 = [None] * 3
t1X, t1Y, t2X, t2Y, t3X, t3Y = [0.0] * 6
swidth, sheight = 300, 300

# 화면 설정
turtle.title("만나기")
turtle.setup(width=swidth + 50, height=sheight + 50)
turtle.screensize(swidth, sheight)

# 거북이 생성
# 'tutle' -> 'turtle' 오타 수정
t1 = turtle.Turtle('turtle'); t1.color('red'); t1.penup()
t2 = turtle.Turtle('turtle'); t2.color('green'); t2.penup()
t3 = turtle.Turtle('turtle'); t3.color('blue'); t3.penup()

# 거북이 초기 위치 및 속성 설정
t1.goto(-100, -100); t2.goto(0, 0); t3.goto(100, 100)
t1.speed(10); t2.speed(10); t3.speed(10)
t1.turtlesize(2); t2.turtlesize(2); t3.turtlesize(2)

# 메인 루프
while True:
    # 각 거북이 랜덤 이동
    angle = random.randrange(0, 360)
    dist = random.randrange(1, 50)
    t1.left(angle); t1.forward(dist)
    
    angle = random.randrange(0, 360)
    dist = random.randrange(1, 50)
    t2.left(angle); t2.forward(dist)

    angle = random.randrange(0, 360)
    dist = random.randrange(1, 50)
    t3.left(angle); t3.forward(dist)

    # 거북이 현재 좌표 저장
    t1X = t1.xcor(); t1Y = t1.ycor()
    t2X = t2.xcor(); t2Y = t2.ycor()
    t3X = t3.xcor(); t3Y = t3.ycor()

    # 화면 경계 체크 로직 수정
    if not ((-swidth / 2 < t1X < swidth / 2) and (-sheight / 2 < t1Y < sheight / 2)):
        t1.goto(0, 0)
    if not ((-swidth / 2 < t2X < swidth / 2) and (-sheight / 2 < t2Y < sheight / 2)):
        t2.goto(0, 0)
    # t1X -> t3X 로 변수 수정
    if not ((-swidth / 2 < t3X < swidth / 2) and (-sheight / 2 < t3Y < sheight / 2)):
        t3.goto(0, 0)

    # 충돌 감지 로직 수정 (거리 비교 조건 추가)
    if math.sqrt(((t1X - t2X) * (t1X - t2X)) + ((t1Y - t2Y) * (t1Y - t2Y))) <= 30:
        t1.turtlesize(random.randrange(1, 10))
        t2.turtlesize(random.randrange(1, 10))
        
    if math.sqrt(((t1X - t3X) * (t1X - t3X)) + ((t1Y - t3Y) * (t1Y - t3Y))) <= 30:
        t1.turtlesize(random.randrange(1, 10))
        t3.turtlesize(random.randrange(1, 10))

    if math.sqrt(((t2X - t3X) * (t2X - t3X)) + ((t2Y - t3Y) * (t2Y - t3Y))) <= 30:
        t2.turtlesize(random.randrange(1, 10))
        t3.turtlesize(random.randrange(1, 10))

turtle.done()