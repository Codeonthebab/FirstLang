import MonsterCard from './components/MonsterCard';
//import Counter from './components/Counter';
//import NameForm from './components/NameForm';
import { useState } from 'react';
import './App.css'

type Monster = {
  id : number;
  name : string;
  level : number;
  element : string;
  type : string;
}

function App() {

  // 몬스터 배열 정의
  const [monsters, setMonsters] = useState<Monster[]>([
    {id:1, name:"슬라임", level:1, element:"물", type:"동물형"},
    {id:2, name:"파이어 드래곤", level:15, element:"불", type:"용족"},
    {id:3, name:"아이스 퀸", level:7, element:"얼음", type: "인간형"},
    {id:4, name:"전기 쥐", level:3, element:"전기", type: "동물형"}
  ]);

  // 삭제 함수 정의
  const handleDelete = (idToDelete: number) => {
    // filter 함수 사용, 삭제할 id와 다른 몬스터들만 남겨 배열 만듦
    const updatedMonsters = monsters.filter((monster) => monster.id !== idToDelete);
    setMonsters(updatedMonsters); // 상태 업데이트
  };

  return (
  <div>
    <h1>📖몬스터 도감📖</h1>
    <div className="monster-grid">
    {/* monsters 배열을 .map()으로 순회, MonsterCard 컴포넌트 생성*/}
      {monsters.map((monster) => (
        <MonsterCard
          key={monster.id} // 고유 key prop 설정
          id={monster.id} // 삭제를 위해 id를 prop으로 전달
          name={monster.name}
          level={monster.level}
          element={monster.element}
          type={monster.type}
          onDelete={handleDelete} // 삭제 핸들러를 prop으로 전달
        />
      ))}
      </div>
    {/* <Counter /> */}
    {/* <NameForm /> */}
  </div>
  );
}

export default App;
