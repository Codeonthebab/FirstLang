#requests 라이브러리 써보기
import requests # pip으로 설치한 requests 라이브러를 임포트시킴

# 접속할 웹사이트 주소
url = "https://www.google.com"

try:
    #requests.get() 함수로 해당 URL에 접속해 응답받기
    response = requests.get(url)

    #200 코드(응답 성공)의 경우, 출력할 내용
    if response.status_code == 200:
        print(f"'{url}'에 성공적으로 접속했습니다.")
        print(f"HTML 일부 내용 표기 : {response.text[:100]}...") #길어지면 100자까지 출력하게끔
    else :
        print(f"접속 실패 : 상태 코드 {response.status_code}")

except Exception as e:
    print(f"접속 중 오류 발생: {e}")
    print("접속에 실패했습니다.")