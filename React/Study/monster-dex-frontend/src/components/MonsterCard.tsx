// Props 타입 정의
// 해당 컴포넌트가 어떤 종류의 Props를 받을지 정의합니다. (*타입 정의)
import { useContext } from 'react';
import { ThemeContext } from '../contexts/ThemeContext';
import { useState } from 'react';

type MonsterCardProps = {
    id: number; // id prop 추가
    name: string;
    level: number;
    element: string;
    type: string;
    onDelete: (id: number) => void; // "(펑션) => 리턴문" 삭제 핸들러 prop 추가
    onUpdate: (id: number, updatedData: {
        name: string;
        level: number;
        element: string;
        type: string;
    }) => void; // 업데이트 핸들러 prop 추가
};

function MonsterCard(props: MonsterCardProps) {

    // 수정 모드를 관리할 state 호출
    const [isEditing, setIsEditing] = useState(false);
    // 수정한 폼의 입력값을 관리할 state 호출
    const [editData, setEditData] = useState({
        name: props.name,
        level: props.level,
        element: props.element,
        type: props.type,
    });

    // 입력값 변경 핸들러
    const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const {name, value} = e.target;
        setEditData({...editData, [name]: value});
    };
    // 업데이트를 반영할 핸들러
    const handleUpdate = () => {
        props.onUpdate(props.id, {
            ...editData,
            level: parseInt(editData.level)||0, //문자열을 숫자로 반환시킴
        });
        setIsEditing(false); // 수정 모드 종료
    };

    // isEditing 상태에 따른 다른 JSX를 return 시킴
    if (isEditing) {
        return (
            <div className="monster-card">
                <input
                    type="text"
                    name="name"
                    value={editData.name}
                    onChange={handleInputChange}
                />
                <input
                    type="number"
                    name="level"
                    value={editData.level}
                    onChange={handleInputChange}
                />
                <input
                    type="text"
                    name="element"
                    value={editData.element}
                    onChange={handleInputChange}
                />
                <input
                    type="text"
                    name="type"
                    value={editData.type}
                    onChange={handleInputChange}
                />
                <button onClick={handleUpdate}>저장</button>
                <button onClick={() => setIsEditing(false)}>취소</button>
            </div>
        )
    }

    return (
        <div className="monster-card">
            <h2>{props.name}</h2>
            <p>Level: {props.level}</p>
            {/*<p>Type: {props.type}</p>  type prop 표시 추가 */}
            <p>Element: {props.element}</p>
            <button onClick={() => setIsEditing(true)}>수정</button>
            <button onClick={() => props.onDelete(props.id)}>삭제</button> {/* 삭제 버튼 추가 */}
        </div>
    );
}
export default MonsterCard;