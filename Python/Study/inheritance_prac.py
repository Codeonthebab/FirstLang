#inheritance_prac

# class 자식 클래스 (부모클래스) 상속 정의 해보기
class Monster :
    def __init__(self, name, health):
        self.name = name
        self.health = health

    def attack(self) :
        print(f"{self.name}이(가) 공격을 합니다.")
    
    def show_health(self) :
        print(f"{self.name}의 현재 체력은 {self.health}입니다.")

# Monster 클래스를 상속받아서 몬스터 만들어보기
class Dragon (Monster) :
    # 부모클래스에 이미있는 메서드지만 자식 속성으로 재정의가 가능함 (오버라이딩!)
    def attack(self):
        print(f"{self.name}이(가) 🔥거대한 화염🔥을 내뿜습니다.")

class IceDragon (Monster) :
    def __init__(self, name, health, element):
        #super()를 쓰면 부모 클래스(Monster)의 init 호출
        #이렇게하면 부모에게 이름과 체력 설정을 맡길 수 있음
        super().__init__(name, health)

        self.element = element
        print(f"-> 속성: {self.element}")

# 객체(몬스터)들 생성
imperial_soldiers = Monster("제국 병사", 200)
red_dragon = Dragon("레드 드래곤", 500)
ice_dragon = IceDragon("아이스 드래곤", 470, "얼음")

red_dragon.show_health() #자식 클래스에서 쇼헬스는 없지만 부모클래스에 있으니까 그대로 사용 가능
imperial_soldiers.show_health()
ice_dragon.show_health()

imperial_soldiers.attack() #만든 객체가 공격
red_dragon.attack()
ice_dragon.attack()
