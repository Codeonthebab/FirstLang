def mid_bar () :
    print("-"*50)


# 메뉴판 출력해보기
menus = ["팥빙수", 8000, "오뎅", 1000, "라면", 3000]
print(f"{menus[0]}, {menus[1]}")
print(f"{menus[2]}, {menus[3]}")
print(f"{menus[4]}, {menus[5]}")

#range()를 활용해서 해보기
mid_bar()
print("#range()를 활용해서 해보기")

score_board = ["민수", 70, "정수", 80, "영희", 95, "철수", 57]
#len(score_board) = 8이다
for i in range(0, len(score_board), 2) :
    name = score_board[i]
    score = score_board[i+1]
    print (f"{name}\t{score}")
    if score >= 80 :
        print(f"---- {name} 합격")

# list 안의 list
mid_bar()
print("list안의 list")

score_board2 = [ #[이름, 정수]를 리스트안에 리스트로 묶음
    ["민수", 60],
    ["정수", 55],
    ["영희", 90],
    ["철수", 70]
]

for student_data in score_board2 :
    name = student_data[0]
    score = student_data[1]
    print(f"{name}\t{score}")
    if score >= 60 :
        print(f"--- {name} 합격")

# 이름, 점수 형태로 key, value 딕셔너리 형태로 자료 구조 만들기 {key: value}
mid_bar()
print("'{이름:점수}'의 형태로 {key:value} 구조로 쓰기")

score_board_3 = {
    "민수" : 70,
    "정수" : 60,
    "영희" : 90,
    "철수" : 55
} # {이름 : 점수} 형태로 인덱싱
#.item() 메소드? 함수? 는 딕셔너리의 키와 값을 한쌍으로 꺼낼 수 있게해줌
for name, score in score_board_3.items():
    print(f"{name}\t{score}")
    if score >= 60 :
        print(f"--- {name} 합격")
