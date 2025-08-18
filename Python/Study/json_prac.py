"""
JSON(JavaScript Object Notation)
- 웹 API를 통해 데이터를 주고 받을 때 많이 사용되는 데이터 포맷
- 파이썬에서는 json 모듈을 통해 JSON 데이터를 쉽게 다룰 수 있다.

## json 이라는 표준 라이브러리를 기본으로 제공
- json.dump(): 파이썬 딕셔너리 -> json파일로 저장 (인코딩)
- json.load(): json파일 -> 파이썬 딕셔너리로 변환 (디코딩)
"""

import json

# 몬스터 데이터 준비하기
monster_data = {
    "name": "Red Dragon",
    "level": 30,
    "health": 300,
    "attack": 50,
    "element": "🔥fire🔥",
    "skills" : ["화염 브레스🔥", "꼬치치기", "포효"]
}

# 파이썬 딕셔너리를 JSON 파일로 저장
with open ('monster.json', 'w', encoding='utf-8') as f:
    # indent=4 옵션은 JSON 파일을 예쁘게 들여쓰기 해주는거임
    json.dump(monster_data, f, indent=4, ensure_ascii=False)

print("'monster.json' 파일이 성공적으로 저장되었습니다.")

# JSON 파일을 파이썬 딕셔너리로 불러오기
print("\n==== 'monster.json' 파일에서 데이터 불러오기 ====")
with open ('monster.json', 'r', encoding='utf-8') as f:
    loaded_data = json.load(f)

# 불러온 데이터를 일반적인 파이썬 딕셔너리처럼 사용
print(f"몬스터 이름: {loaded_data['name']}")
print(f"몬스터 레벨: {loaded_data['level']}")
print(f"몬스터 체력: {loaded_data['health']}")
print(f"몬스터 공격력: {loaded_data['attack']}")
print(f"몬스터 속성: {loaded_data['element']}")
print(f"몬스터 스킬: {', '.join(loaded_data['skills'])}")
