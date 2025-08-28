import { useState } from "react";

// 부모에게서 받을 함수 (onAddMonster) 타입 정의
type AddMonsterFormProps = {
    onAddMonster: (monsterData: {
        name: string;
        level: number;
        element: string;
        type: string;
    }) => void;
};

function AddMonsterForm({onAddMonster} : AddMonsterFormProps) {

    // 입력창 상태 관리
    const [name, setName] = useState('');
    const [level, setLevel] = useState('');
    const [element, setElement] = useState('');
    const [type, setType] = useState('');

    const handleSubmit = (event: React.FormEvent) => {
        event.preventDefault(); // 폼 제출 시 페이지 새로고침 방치해줌
        if (!name || !level) {
            alert('이름과 레벨은 필수 입력 사항입니다.');
            return;
        }

        // 부모에게서 받은 함수 호출, 입력된 데이터 전달
        onAddMonster({
            name,
            level: parseInt(level),
            element,
            type
        });

        // 입력창 초기화
        setName('');
        setLevel('');
        setElement('');
        setType('');
    };

    return (
        <form onSubmit={handleSubmit}>
            <h3>새로운 몬스터 추가</h3>
            <input type="text" value={name} onChange={(e)=> setName(e.target.value)} placeholder="이름"/> <br/>
            <input type="text" value={level} onChange={(e)=> setLevel(e.target.value)} placeholder="레벨"/> <br/>
            <input type="text" value={element} onChange={(e)=> setElement(e.target.value)} placeholder="속성"/> <br/><br/>
            <button type="submit">추가</button>
        </form>
    );
}

export default AddMonsterForm;