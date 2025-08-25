from flask import Flask, jsonify
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

"""
위는 Monster 클래스까지 설계함
실제 DB에 테이블을 만들기 위해선 터미널이 필요, (.venv) 활성후 
1. flask shell 명령어 실행
2. 테이블 생성 명령어 입력
   >>> from app import db   
   >>> db.create_all()      정의한 모델을 찾아서 그에 맞는 테이블에 DB에 생성
   >>> exit()               여기까지 하면 실제로 DB에 테이블이 생성됨
"""

