a = int(input("정수를 입력하세요 : "))

if a % 2 == 0:
    print("'짝수'군.")
    #print("조건이 만족하지 않기에 실행 안됨요")
elif a % 1 == 0:
    print("'짝수'가 아니군.")
elif a < 100:
    print("100보다 크군.")
