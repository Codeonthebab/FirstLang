import MonsterCard from './components/MonsterCard';
import './App.css'

function App() {

  return (
  <div>
    <h1>📖몬스터 도감📖</h1>
    <MonsterCard name="슬라임" level={1} type="물" ability="재생" />
    <MonsterCard name="파이어 드래곤" level={15} type="불" ability="화염 방사" />
    <MonsterCard name="아이스 퀸" level={7} type="얼음" ability="빙결" />
    <MonsterCard name="전기 쥐" level={3} type="전기" ability="감전" />
  </div>
  );
}

export default App
