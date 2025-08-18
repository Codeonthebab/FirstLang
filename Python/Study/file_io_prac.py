#파일 입, 출력 관련.
# open(), read(), write() 메서드를 활용해 내용을 읽거나 쓸 수 있게끔 하기
# with open(...) 관련 구문 쓰기

#1. 파일 쓰기 (W 모드)
with open ('my_note.txt', 'w', encoding='utf-8') as f:
    f.write("파이썬 파일 입출력 연습 \n")
    f.write("그 다음 줄에 내용 작성 중!\n")

#2. 파일에 내용 추가해보기 (A 모드)
with open ('my_note.txt', 'a', encoding='utf-8') as f:
    f.write("파일에 내용 추가해보는 중!")

#3. 파일 읽기 (R 모드)
print("---- my_note.txt 내용 ----")
with open ('my_note.txt', 'r', encoding='utf-8') as f:
    content = f.read() #파일 전체의 내용을 하나의 문자열로 받아와서 읽어옴
    print(content)
    print("--------------------------")
