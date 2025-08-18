#from [패키지명].[모듈명] import [가져올 클래스/함수]
from monsters.basic import Monster, Dragon, Goblin, Zombie, Skeleton

print("===== Game Start =====")

slime = Monster("슬라임", 50)
dragon = Dragon("드래곤", 100)
goblin = Goblin("고블린", 30)
zombie = Zombie("좀비", 40)
skeleton = Skeleton("스켈레톤", 60)

print(f"야생의 {slime}이(가) 나타났다!")
print(f"야생의 {dragon}이(가) 나타났다! \n 행동 : {dragon.attack()}")
print(f"야생의 {goblin}이(가) 나타났다! \n 행동 : {goblin.attack()}")
print(f"야생의 {zombie}이(가) 나타났다! \n 행동 : {zombie.attack()}")
print(f"야생의 {skeleton}이(가) 나타났다! \n 행동 : {skeleton.attack()}")