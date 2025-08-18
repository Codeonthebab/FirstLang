import requests

# 공개된 테스트용 API
response = requests.get('https://jsonplaceholder.typicode.com/todos/1')

# response.text는 JSON 형식의 '문자열'
# response.json()은 이를 파이썬 '딕셔너리'로 변환
data_dict = response.json() 

print(type(data_dict)) # <class 'dict'>
print(data_dict)
print(f"할 일 제목: {data_dict['title']}")