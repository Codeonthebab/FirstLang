import {useState} from 'react'; // useState를 import

/* useState 사용 예시
1. useState를 React에서 import
2. const [상태변수, 상태변경함수] = useState(초기값); 형태로 선언
    - 상태변수 : 현재 상태값을 저장하는 변수
    - 상태변경함수 : 함수를 호출해야만 상태변수를 업데이트하고 화면을 다시 그림
    - 초기 값 : 상태변수가 처음에 가질 값
*/

function Counter() {
    // setCount는 count 값을 변경할 때 사용할 함수
    const [count, setCount] = useState(0); // useState에 값을 변경 시켜서 저장시킴

    // 버튼을 클릭될 때 실행 함수
    const handleIncrease = () => {
        setCount(count + 1); // count 값을 1 증가
    };

    const handleDecrease = () => {
        setCount(count - 1); // count 값을 1 감소
    };

    return (
        <div>
            <h3> 카운터 </h3>
            <p> 현재 카운터 값 : {count} </p>
            {/* 버튼 클릭하면 handleIncrease 함수 실행시키기 */}
            <button onClick={handleIncrease}>+1 증가 </button>
            <button onClick={handleDecrease}>-1 감소 </button>
        </div>
    );
}

export default Counter;