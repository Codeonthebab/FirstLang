money, c500, c100, c50, c10 = 0, 0, 0, 0, 0

# 교환할 금액을 입력받는다.
money = int(input("교환할 금액을 입력하세요 : "))

c500 = money // 500 # 몫을 구함
money = money % 500 # 나머지를 구함

c100 = money // 100
money = money % 100

c50 = money // 50
money = money % 50

c10 = money // 10
money = money % 10

print ("500원 : %d개"% c500)
print ("100원 : %d개"% c100)
print ("50원 : %d개"% c50)
print ("10원 : %d개"% c10)
print ("나머지 돈 : %d원"% money)
# 거스름돈 계산 프로그램