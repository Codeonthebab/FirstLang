import MonsterCard from './components/MonsterCard';
//import Counter from './components/Counter';
//import NameForm from './components/NameForm';
import { useState, useEffect } from 'react';
import { ThemeContext } from './contexts/ThemeContext';
import AddMonsterForm from './components/AddMonsterForm';
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

  // 몬스터 정보 서버 업데이트 함수
  const handleUpdateMonster = async (id: number, updatedData: {
    name: string;
    level: number;
    element: string;
    type: string;
  }) => {
    try {
      const response = await fetch(`http://127.0.0.1:5000/monsters/${id}`, {
        method: 'PUT',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(updatedData)
      });
      const updatedMonster = await response.json();
      // 화면에 몬스터 목록 최신 업데이트 시킴
      setMonsters(monsters.map(monster => 
        monster.id === id ? updatedMonster : monster
      ));
    } catch (error) {
      console.error('몬스터 업데이트 중 오류 발생 : ', error);
    }
  };

  // 몬스터 추가 함수
  const handleAddMonster = async (monsterData: 
    {
      name:string;
      level:number;
      element:string;
      type:string;
    })=> {
      try {
        const response = await fetch('http://127.0.0.1:5000/monsters', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          // javascript 객체를 JSON 문자열로 변환
          body: JSON.stringify(monsterData),
        });
        const newMonster = await response.json();
        
        if (!response.ok) {
          throw new Error('몬스터 추가에 실패하였습니다.');
        }

        setMonsters([...monsters, newMonster]);
      } catch (error) {
        console.error('몬스터 추가 중 오류 발생 : ', error);
      }
    };

  // 'light' 또는 'dark' 상태 관리
  const [theme, setTheme] = useState('light');

  // useEffect로 Hook 추가 해서 바디클래스 적용
  useEffect(()=> {
    // theme 상태가 변경할 때마다 document의 body 클래스 적용
    document.body.className=theme;
  }, [theme]); // [theme] : theme 상태가 변경될 때마다 실행하라는 의미

  // 테마 토글 함수
  const toggleTheme = () => {
    setTheme(theme === 'light' ? 'dark' : 'light');
  }

  
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
  const handleDelete =  async(idToDelete: number) => {

    try {
      await fetch(`http://127.0.0.1:5000/monsters/${idToDelete}`,
        { method: 'DELETE' });
        const updatedMonsters = monsters.filter((monster) => monster.id !== idToDelete);
        setMonsters(updatedMonsters);
    } catch (error) {
      console.error('몬스터 삭제 중 오류 발생 : ', error);
    }
    // filter 함수 사용, 삭제할 id와 다른 몬스터들만 남겨 배열 만듦
    const updatedMonsters = monsters.filter((monster) => monster.id !== idToDelete);
    setMonsters(updatedMonsters); // 상태 업데이트
  };
  
  // Monster 검색 기능
  const [searchMonster, setSearchMonster] = useState<string>('');

  return (

  // ThemeContext.Provider로 하위 컴포넌트를 감사도록 함
  // value prop으로 공유하고 싶은 데이터를 전달시킴
  <ThemeContext.Provider value={theme}>
  {/* 프로바이더에 감싸진 하위 컴포넌트는 전부 value{theme}를 props로 받음*/}
  <div className={`app-container ${theme}`}>
    <button onClick={toggleTheme}>
      {theme === 'light' ? '☀️라이트 모드' : '🌙다크 모드'}
    </button>
  
    <div>
      <h1>📖몬스터 도감📖</h1>

      <AddMonsterForm onAddMonster={handleAddMonster} />
      <hr/>
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
          onDelete={handleDelete} // 삭제 핸들러를 prop으로 전달, 지금은 임시로 비움 {/*handleDelete*/}
          onUpdate={handleUpdateMonster} // 업데이트 핸들러를 prop으로 전달
        />
      ))}
      </div>
      </div>

    {/* <Counter /> */}
    {/* <NameForm /> */}
  </div>
  </ThemeContext.Provider>
  );
}

export default App;