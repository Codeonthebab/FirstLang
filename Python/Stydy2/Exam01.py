"""
물건을 수송하는 기차 여러 대의 수송량을 구하여 순위를 구하는 프로그램을 구현하시오

[수송량 목록]
- 토마스 5톤, 헨리 8톤, 에드워드 9톤, 에밀리 5톤, 
    토마스 4톤, 헨리 7톤, 토마스 3톤, 에밀리 8톤, 퍼시 5톤, 고든 13톤

## 순위를 출력하는 프로그램 (1등, 2등, etc)
튜플을 딕셔너리로 변환, 다시 딕셔너리를 튜플로 정렬하는 방식을 사용한다
"""

import operator

# 전역 변수 선언
trainTupleList = [('토마스', 5), ('헨리', 8), ('에드워드', 9), ('에밀리', 5),
                  ('토마스', 4), ('헨리', 7), ('토마스', 3), ('에밀리', 8),
                  ('퍼시', 5), ('고든', 13)]

trainDic, trainList={}, []

tepTup = None
totalRank, currentRank= 1,1

for tepTup in trainTupleList:
    tName = tepTup[0]
    tWeight = tepTup[1]
    
    if tName in trainDic:
        trainDic[tName]+=tWeight
        
    else :
        trainDic[tName]=tWeight
    
    print("기차 수송량 목록 =>", trainTupleList)
    print("=========================================")
    
    trainList = sorted(trainDic.items(), key=operator.itemgetter(1), reverse=True)
    print("기차\t총 수송량\t순위")
    print(trainList[0][0],'\t',trainList[0][1],'\t',currentRank)
    print("=========================================")
    for i in range(1, len(trainList)):
        totalRank += 1
        if trainList[i][1] == trainList[-1][1]:
            pass
        else :
            currentRank = totalRank
        print(trainList[i][0],'\t',trainList[i][1],'\t',currentRank)