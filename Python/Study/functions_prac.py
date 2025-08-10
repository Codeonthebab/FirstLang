def mid_bar() :
    print("--"*50)

#'price'와 'discount_rate'를 매개변수로 받는 함수 정의
def calculate_sale_price(price, discount_rate) :
    """
    정가와 할인율을 받아 할인가를 계산하는 함수
    (파이썬에선 큰 따옴표 세개로 함수에 대한 설명 가능, 아니 직관적이고 좋은데?)
    """

    sale_price = price * (1-discount_rate)
    return sale_price # 이 함수에 대해서 계산된 결과를 반환한다.

# 함수 호출 시 실제 값을 전달함
original_price = 10000
rate = 0.2 #20프로 할인

# 함수가 return 값을 특정 변수에 저장
final_price = calculate_sale_price(original_price, rate)
print(f"정가{original_price}원, 할인율 {rate*100}% 적용")
print(f"-> 최종 가격 {final_price}원")
mid_bar()

#tax_rate 매게 변수에 0.1을 설정
def get_total_price (price, tax_rate=0.1) :
    """
    가격을 세율을 받아 세금이 포함된 최종 가격을 반환하는 함수.
    세율을 입력하지 않으면 기본값 10% 적용
    """
    total_price = price * (1+tax_rate)
    return total_price

#1 기본세율 적용시
price_a = 5000
total_a = get_total_price(price_a) 
#기존 메서드에 기본 값인 0.1을 부여된 채로 price 부분만 들어감
print(f"상품 A 가격: {price_a}원, 최종가 (세율 10% 적용): {total_a}원")

#2 특정 세율(5%) 적용시
price_b = 5000
total_b = get_total_price(price_b, tax_rate=0.05) #기본 값에 오버로딩 시킴
print(f"상품 A 가격: {price_b}원, 최종가 (세율 10% 적용): {total_b}원")
