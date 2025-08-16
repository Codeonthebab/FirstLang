students = ["민수", "철수", "영희", "정수", "하나"]
scores = [85, 90, 78, 88, 92]

#zip(students, scores)를 하면 ('민수', 85), ('철수', 90) ... 형태로 묶임
score_map = {name: score for name, score in zip(students, scores)}
print(score_map) #{'민수': 85, '철수': 90, '영희': 78, '정수': 88, '하나': 92}

# if 조건문을 추가하여 80점 이상인 학생만 딕셔너리 포함 가능
high_scorers = {name: score for name, score in zip(students, scores) if score >= 80}
print(high_scorers) #{'민수': 85, '철수': 90, '정수': 88, '하나': 92}
