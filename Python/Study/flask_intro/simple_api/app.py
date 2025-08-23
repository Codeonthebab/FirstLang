from flask import Flask, jsonify, request
from flask_sqlalchemy import SQLAlchemy

# Flask app 생성
app = Flask(__name__)

# SQLAlchemy 설정 : 어떤 데이터 베이스에 연결할지 설정
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///monsters.db'
# 불필요한 기능 비활성화
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False

# SQLAlchemy 객체 생성
db = SQLAlchemy(app)

# 몬스터 정보를 저장할 데이터베이스 모델(테이블 설계도) 정의
# Monster 이라는 파이썬 클래스가 데이터베이스의 'monster'테이블과 연결
class Monster(db.Model):
    id = db.Column(db.Integer, primary_key=True) # 고유의 ID, 기본 키가 됨
    name = db.Column(db.String(100), nullable=False) # 몬스터 이름, Null 불허
    level = db.Column(db.Integer, nullable=False) # 몬스터 레벨, Null 불허
    element = db.Column(db.String(50), nullable=False) # 몬스터 속성, Null 불허
    
    # 객체들을 딕셔너리로 변환하는 함수 만들어 둠
    def to_dict(self) :
        return {
            "id": self.id,
            "name": self.name,
            "level": self.level,
            "element": self.element
        }

"""
# Key: 몬스터 ID, Value: 몬스터 정보 (딕셔너리)
기존에 만들어둔 몬스터 데이터
monsters = {
    1: {"name": "슬라임", "level": 1, "element": "물"},
    2: {"name": "고블린", "level": 2, "element": "땅"},
    3: {"name": "드래곤", "level": 5, "element": "불"},
    4: {"name": "유니콘", "level": 3, "element": "빛"},
    5: {"name": "피닉스", "level": 4, "element": "불"}
}"""

# 1. API 엔드포인트(EndPoint) 정의
# HTTP GET 요청으로 '/monsters' 주소에 접속했을 때 함수 실행
@app.route('/monsters', methods=['GET'])
def get_all_monsters():
    # DB에서 몬스터 정보 조회하기 (*쿼리문 : SELECT * FROM monster)
    all_monsters = Monster.query.all()
    # 각 몬스터 객체를 to_dict() 함수를 사용, 딕셔너리로 변환 후, 리스트로 만듦
    result = [monster.to_dict() for monster in all_monsters]
    return jsonify(result)

@app.route('/monsters/<int:monster_id>', methods=['GET'])
def get_monster(monster_id):
    # ID로 특정 몬스터 하나를 조회함 (*쿼리문 : SELECT * FROM monster WHERE id= ?)
    monster = Monster.query.get(monster_id)

    # monster가 없으면
    if not monster:
        return jsonify({"error": "Monster not found"}), 404
    return jsonify(monster.to_dict())

# 몬스터 추가하는 엔드포인트 (Create : Post)
@app.route('/monsters', methods=['POST'])
def add_monster():
    # 클라이언트가 보낸 JSON 데이터를 파이썬 딕셔너리로 받음
    data = request.json

    new_monster = Monster(
        name=data['name'],
        level=data['level'],
        element=data['element']
    )
    #DB 세션에 새로운 객체를 넣는다
    db.session.add(new_monster)
    # 변경사항을 DB에 최종 커밋
    db.session.commit()

    #생성된 몬스터의 정보와 함께 '201 Created 상태 코드'를 반환받음
    return jsonify(new_monster.to_dict()), 201

# 몬스터 정보 수정하는 엔드포인트 (Update : Put)
@app.route('/monsters/<int:monster_id>', methods=['PUT'])
def update_monster(monster_id):
    # 몬스터 조회
    monster = Monster.query.get(monster_id)
    # 몬스터가 없으면 아래를 404 반영
    if not monster:
        return jsonify({"error": "Monster not found"}), 404

    # 몬스터 정보 수정
    data = request.json
    monster.name = data['name']
    monster.level = data['level']
    monster.element = data['element']
    # 변경사항을 DB에 최종 커밋
    db.session.commit()
    return jsonify(monster.to_dict())

# 특정 몬스터 삭제하는 엔드포인트 (Delete : Delete)
@app.route('/monsters/<int:monster_id>', methods=['DELETE'])
def delete_monster(monster_id):
    # 몬스터 조회
    monster = Monster.query.get(monster_id)
    # 몬스터가 없으면 아래를 404 반영
    if not monster:
        return jsonify({"error": "Monster not found"}), 404

    # 몬스터 삭제
    db.session.delete(monster)
    db.session.commit()
    return '', 204

"""
# 2. API 엔드포인트(EndPoint) 정의
# HTTP GET 요청으로 '/monsters/<id>' 주소에 접속했을 때 함수 실행
@app.route('/monsters/<int:monster_id>', methods=['GET'])
def get_monster(monster_id):
    # URL에서 받은 monster_id를 Key로 사용하여 몬스터를 찾음
    monster = monsters.get(monster_id)
    
    # 몬스터의 ID가 없을 경우
    if not monster:
        # 몬스터가 없을 경우 JSON 404 Not Found 응답
        return jsonify({"error": "Monster not found"}), 404

    # 몬스터 정보를 찾았을 경우 해당 정보 JSON으로 반환
    return jsonify(monster)
"""

# 메인 페이지 확인해보기
@app.route('/')
def index():
    return "<h1>Welcome to the Monster API!</h1>"

""" DB를 만들고 READ까지
위는 Monster 클래스까지 설계함
실제 DB에 테이블을 만들기 위해선 터미널이 필요, (.venv) 활성후 
1. flask shell 명령어 실행
2. 테이블 생성 명령어 입력
   >>> from app import db   
   >>> db.create_all()      정의한 모델을 찾아서 그에 맞는 테이블에 DB에 생성
   >>> exit()               여기까지 하면 실제로 DB에 테이블이 생성됨
   """

""" POST를 이용해서 데이터 넣기
'get' 요청과는 달리, 'post' 요청은 웹 브라우저 주소창에 
URL을 입력하는 것만으로는 테스트할 수 없다.
- 데이터를 담아서 보내야 하기 때문이다

* API 테스트 도구 사용
- VS 코드는 'REST Client' 확장 프로그램을 설치
- Postman과 같은 독립형 API 클라이언트를 사용할 수도 있다.
[Postman](https://www.postman.com/)은 RESTful API를 테스트하고 문서화하는 데 유용한 도구이다.   

* 테스트 방법 (REST Client) 기준
1. 프로젝트 폴더에 '요청할 내용이 담긴.http' 파일 생성
2. HTTP 요청을 작성
3. POST 요청 부분 위에 나타나는 SEND REQUEST 글자 클릭
4. 201 응답을 받으면 성공
5. GET 요청의 SEND REQUEST 글자 클릭 -> 목록을 확인

"""
