# 1부터 사용자가 입력한 수까지의 합계를 구하는 프로그램을 구현

i, sum = 0, 0

n = int(input("수 입력 :"))

"""
for i in range(시작되는 값, 끝나는 값, 증가하는 값) : 반복 수행할 때 쓰는 문법 함수
"""

for i in range(1, n+1, 1) :
    sum += i
    
print ("1부터 %d까지의 합 : %d" %(n, sum))