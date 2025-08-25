import MonsterCard from './components/MonsterCard';
//import Counter from './components/Counter';
//import NameForm from './components/NameForm';
import { useState, useEffect } from 'react';
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
  const [monsters, setMonsters] = useState<Monster[]>([]);
  // useEffect를 사용, 컴포넌트가 처음 마운트될 때 데이터 가져옴
  useEffect(() => {
    const fetchMonsters = async () => {
      try {
        // Flask API 서버에 요청
        const response = await fetch('http://127.0.0.1:5000/monsters');
        const data = await response.json();

        // 상태 업데이트 시킴
        // Object.values()는 딕셔너리 값들만 배열로 만듦
        setMonsters(Object.values(data));
      } catch (error) {
        console.error('몬스터 데이터 가져오는데 실패하였습니다 : ', error);
      }
    };
    fetchMonsters(); // 함수 실행
  }, []); // 의존성 배열을 빈 배열([])로 설정, 1호만 실행

  // 삭제 함수 정의
  const handleDelete = (idToDelete: number) => {
    // filter 함수 사용, 삭제할 id와 다른 몬스터들만 남겨 배열 만듦
    const updatedMonsters = monsters.filter((monster) => monster.id !== idToDelete);
    setMonsters(updatedMonsters); // 상태 업데이트
  };
  
  // Monster 검색 기능
  const [searchMonster, setSearchMonster] = useState<string>('');

  return (
  <div>
    <h1>📖몬스터 도감📖</h1>
   
    <input
      type="text"
      placeholder='몬스터 이름 검색'
      value={searchMonster}
      onChange={(e) => setSearchMonster(e.target.value)}
    />

    <div className="monster-grid">
    {/* monsters 배열을 .map()으로 순회, MonsterCard 컴포넌트 생성*/}
      {monsters
      // 화면에 그리기 전에 필터링 로직 추가
      .filter((monster) =>
        monster.name.toLowerCase().includes(searchMonster.toLowerCase())
      )
      // 필터링된 결과를 보여주는 .map() 실행
      .map((monster) => (
        <MonsterCard
          key={monster.id} // 고유 key prop 설정
          id={monster.id} // 삭제를 위해 id를 prop으로 전달
          name={monster.name}
          level={monster.level}
          element={monster.element}
          type={monster.type}
          onDelete={() => {}} // 삭제 핸들러를 prop으로 전달, 지금은 임시로 비움 {/*handleDelete*/}
        />
      ))}
      </div>
    {/* <Counter /> */}
    {/* <NameForm /> */}
  </div>
  );
}

export default App;
