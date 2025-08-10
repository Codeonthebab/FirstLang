def mid_bar () :
    print("-"*50)

#CRUD 해보기. 
# Create (생성)
my_profile = {
    "name" : "민수",
    "age" : 30,
    "major" : "Computer Science",
    "courses" : ["Python", "Java", "Web Development"] # 키 : 값의 형태로서, 값에는 리스트도 올 수 있다.
}
print(f"초기 프로필: {my_profile}")
mid_bar()

# Read (조회) : key를 사용해 value 값 가져오기
name = my_profile["name"]
print(f"이름: {name}\n")
# .get() 메소드를 사용, key가 없을 때 오류대신 None 또는 기본 값을 반환해 안전하게 만듦
hobby = my_profile.get("hobby", "사진 찍기") #hobby의 키가 없으니, 기본 값이 출력
print(f"취미 : {hobby}\n")
mid_bar()

# Update (추가 & 수정)
my_profile["hobby"] = "코딩" # 없는 Key에 값을 할당하면 '추가'가 된다.
print(f"취미 추가: {my_profile}")
my_profile["age"] = 31 # 이미 들어있는 key에 할당시키면 값이 '수정'
print(f"나이 수정: {my_profile}")
mid_bar()

# Delete (삭제)
del my_profile["major"] # del 키워드를 사용, 특정 키-밸류 값을 삭제 시킬 수 있음
print(f"전공 삭제 후: {my_profile}")

mid_bar()
mid_bar()

#.key() 활용하기 : 모든 key 가져오기
print("----프로필 Keys ----")
for key in my_profile.keys() :
    print(key)
mid_bar()
#.values() : 모든 Value를 가져오기
print("\n----프로필 Values----")
for value in my_profile.values() :
    print(value)
mid_bar()
#.items() : Key와 Value 한 쌍으로 가져온다 (주로 사용될 메서드일듯)
print("\n----프로필 Items (key:value)----")
for key, value in my_profile.items() :
    print(f"{key}:{value}")


#사용자가 데이터를 보냈다고 가정하고 코드 작성
user_input = {
    "username" : "King Athur",
    "email" : "Athur@example.com",
    "password" : "my_secret_pass_123"
}
mid_bar()
# .items()를 사용, 검증 처리해본다면?
for field, data in user_input.items() :
    print(f"검증 항목 : '{field}', 입력 값 : '{data}'")

    if field == "email" and "@" not in data :
        print("-> Error: 이메일 형식이 올바르지 않습니다.")
    if field == "password" and len(data) < 8 :
        print("-> Error: 비밀번호는 8자리 이상이어야 합니다.")