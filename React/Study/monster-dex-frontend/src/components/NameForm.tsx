/* 사용자 입력 다루기 : Input, onChange 이벤트 
    - input 태그에 입력된 값을 관리 위해 useState 사용
1. useState로 입력값 (value)을 저장할 상태 변수 만듦
2. input 태그의 value 속성을 이 상태 변수와 연결
3. 사용자가 키보드 칠 때마다 발생하는 onChange 이벤트가 발생하면,
    상태 변경 함수를 호출하여 상태 변수를 업데이트
*/

import {useState} from 'react';

function NameForm() {
    // 입력 값을 저장할 state를 생성, 초기값은 빈 문자열로 설정
    const [name, setName] = useState('');
    // input의 내용이 변경될 때마다 실행될 함수
    const handleNameChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        // event.target.value는 input에 입력된 현재 값을 의미
        // 이 값으로 name state 업데이트
        setName(event.target.value);
    };

    return (
        <div>
            <h3> 이름을 입력하세요. </h3>
            {/* input의 value를 name state와 연결, onChange 이벤트 설정 */}
            <input
            type="text"
            value={name}
            onChange={handleNameChange}
            placeholder="이름을 입력하세요."
            />
            <p> 반가워요, {name}! </p>
        </div>
    );
}

export default NameForm;
