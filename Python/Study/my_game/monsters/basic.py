# 몬스터 클래스를 만드는 곳

class Monster:
    def __init__ (self, name, health):
        self.name = name
        self.health = health
    
    def __str__ (self) :
        return f"{self.name} (HP : {self.health})"
    
class Dragon (Monster):
    def attack (self) :
        return "화염을 내뿜는다! 🔥"
    
class Goblin (Monster):
    def attack (self) :
        return "칼을 휘두른다! ⚔️"

class Zombie (Monster):
    def attack (self) :
        return "물어뜯는다! 🧟"

class Skeleton (Monster):
    def attack (self) :
        return "활을 쏜다! 🏹"
    
if __name__ == "__main__" :
    print("### 모듈 테스트 코드 실행 ###")
    m = Monster("테스트 몬스터", 1)
    print(m)