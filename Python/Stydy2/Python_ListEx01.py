aa = [0,0, 0, 0]
sum = 0
#aa [0] = int (input("첫번째 숫자:"))
#aa [1] = int (input("두번째 숫자:"))
#aa [2] = int (input("세번째 숫자:"))
#aa [3] = int (input("네번째 숫자:"))

#sum = aa[0]+aa[1]+aa[2]+aa[3]

for i in range(0, 4):
    aa[i] = int(input("4개의 숫자 입력 :"))
    sum += aa[i]

print("합계 : %d"%sum)