#error_handling

scores = {"민수" : 90, "영희" : 85}

# 이름을 입력받아 해당 학생의 점수를 출력하는 코드
student_name = input("학생 이름을 입력하세요: ")
if scores.get(student_name) in scores.values():
     print("해당 학생의 점수가 존재합니다.")

try :
    # 시도할 코드들
    target_student = student_name
    print(f"{target_student}의 점수 : {scores[target_student]}")
except KeyError : 
    # KeyError 발생시 실행될 코드들
    print(f"{target_student}의 점수는 존재하지 않습니다.")
except Exception as e :
    # 예상치 못한 다른 모든 오류를 처리(*Exception 사용)
    print("알 수 없는 오류가 발생했습니다.")
    print(f"내용 : {e}")
else :
    # 위에 예외에 해당되지 않는 경우 실행될 코드
    print("점수 조회가 성공적으로 완료되었습니다.")
finally :
    # 위에 예외 발생과 관련없이 항상 마지막에 실행될 코드
        print("점수 조회 시스템이 종료됩니다.")
        