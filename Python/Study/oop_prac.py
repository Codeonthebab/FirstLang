def mid_bar () :
     print("--"*50)

#Java처럼 객체 지향 언어 형으로 객체를 만들어낼 수 있다
class Monster :
    #__init__메서드 java의 생성자
    # 객체가 생성될 때 이름과 체력을 받아서 속성을 정의시켜놓는식으로
        def __init__(self, name, health):
            self.name = name #self.name은 '이름' 속성
            self.health = health #self.health는 '체력' 속성
            print(f"-> {self.name}(체력: {self.health}) 몬스터 생성!")
        
        #위에서 만든 몬스터 객체의 행동을 정의하는 메서드들
        def attack(self) :
            print(f"{self.name}이(가) 공격합니다!")
        
        def show_health(self) :
            print(f"{self.name}의 현재 체력은 {self.health}입니다.")
        
        #예를 들어 유저에게 데미지를 받았을 경우
        def take_damage (self, amount) :
             self.health -= amount #위쪽에서 선언된 health의 값을 받은 데미지 값만큼 감소시킴
             if self.health < 0 :
                  self.health = 0 #체력이 음수가 되지 않도록 0으로 선언 해놓음
             print(f"{self.name}이(가) {amount}의 데미지를 입었습니다.")

#클래스 안에서 몬스터 객체(인스턴스) 생성
# 자바의 개념으로 하면 Monster slime = new Monster("슬라임", 10);
slime = Monster("슬라임", 10)
orc = Monster("오크", 50)
goblin = Monster("고블린", 30)
devilknight = Monster("데빌나이트", 100)

mid_bar()

# 클래스를 이용해 생성한 몬스터들 행동시켜보기
slime.attack()
orc.attack()
goblin.attack()
devilknight.attack()

slime.show_health()
orc.show_health()
goblin.show_health()
devilknight.show_health()

mid_bar()
# 객체'몬스터'에 데미지 입혀보기
orc.take_damage(20)
orc.show_health()

slime.take_damage(20)
slime.show_health()

goblin.take_damage(20)
goblin.show_health()

devilknight.take_damage(20)
devilknight.show_health()
