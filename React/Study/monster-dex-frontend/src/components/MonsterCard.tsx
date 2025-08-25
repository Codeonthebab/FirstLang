// Props 타입 정의
// 해당 컴포넌트가 어떤 종류의 Props를 받을지 정의합니다. (*타입 정의)
import { useContext } from 'react';
import { ThemeContext } from '../contexts/ThemeContext';

type MonsterCardProps = {
    id: number; // id prop 추가
    name: string;
    level: number;
    type: string;
    element: string;
    onDelete: (id: number) => void; // "(펑션) => 리턴문" 삭제 핸들러 prop 추가
};

function MonsterCard(props: MonsterCardProps) {

    const theme = useContext(ThemeContext);

    return (
        <div className={`monster-card ${theme}`}>
            <h2>{props.name}</h2>
            <p>Level: {props.level}</p>
            <p>Type: {props.type}</p> {/* type prop 표시 추가 */}
            <p>Element: {props.element}</p>
            <button onClick={() => props.onDelete(props.id)}>삭제</button> {/* 삭제 버튼 추가 */}
        </div>
    );
}
export default MonsterCard;