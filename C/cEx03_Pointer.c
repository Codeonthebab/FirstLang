#include <stdio.h>

int main() {
    int speed = 100; // 속도 변수 선언, 초기화 값

    // & : 변수의 주소를 알아내는 연산자
    // %p : 포인터(주소)를 16진수로 출력하는 서식 
    printf("speed 값 : %d\n", speed);
    printf("speed가 담겨있는 포인터(주소) : %p\n", &speed);

    // 포인터 변수 선언
    // * : 포인터 변수를 선언할 때 사용하는 기호
    // int형 변수의 주소를 담는 변수
    int* ptr_speed = &speed;

    // speed의 주소를 출력하기 위함
    printf("주소 가져오는 'ptr_speed' : %p\n", ptr_speed);

    // * : 포인터 변수가 가르키는 변수의 값을 가져올 때 사용하는 역참조 연산자
    // "해당 주소에 있는 내용물을 가져오게끔 함"
    printf("해당 포인터(주소)가 가르키는 값 : %d\n", *ptr_speed);

    return 0;
}