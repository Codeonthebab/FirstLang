// Props 타입 정의
// 해당 컴포넌트가 어떤 종류의 Props를 받을지 정의합니다. (*타입 정의)

type MonsterCardProps = {
    name: string;
    level: number;
    type: string;
    ability: string;
};

// 함수의 매개변수로 props를 받아서 사용, 타입 지정
function MonsterCard(props: MonsterCardProps) {
    return (
        <div className="monster-card">
            <h2>{props.name}</h2>
            <p>Level: {props.level}</p>
            <p>Type: {props.type}</p>
            <p>Ability: {props.ability}</p>
        </div>
    );
}
export default MonsterCard;