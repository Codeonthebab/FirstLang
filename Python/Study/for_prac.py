from mid_bar import mid_bar

# for문 평범버전
number = [1, 2, 3, 4, 5]
bin_number = []

for num in number:
    bin_number.append(num*num)

print(bin_number) #[1, 4, 9, 16, 25]

mid_bar().print_bar()

# for문 리스트 컴프리헨션 방식
numbers = [1, 2, 3, 4, 5]
#[새 리스트에 담을 표현식 for 변수 in 기존 리스트]
squared_numbers = [num * num for num in numbers]
print(squared_numbers) #[1, 4, 9, 16, 25]

mid_bar().print_bar()

# if 문을 쓴 for문
numbers = [1, 2, 3, 4, 5]
even_squared_numbers = []

for num in numbers :
    if num % 2 ==0 : #num의 값이 짝수라면
        even_squared_numbers.append(num * num)
    
print(even_squared_numbers) #[4, 16]

mid_bar().print_bar()

# if 문을 쓴 리스트 컴프리헨션
numbers = [1, 2, 3, 4, 5]
even_squared_numbers = [num * num for num in numbers if num % 2 == 0]
print(even_squared_numbers) #[4, 16]

mid_bar().print_bar()
