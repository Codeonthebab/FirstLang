#include <stdio.h>

int main() {
    // 변수 선언부, 메모리 사이즈를 알기 위함
    char a; // 1 byte 문자형
    int b;  // 4 bytes 정수형
    float c; // 4 bytes 실수형
    double d; // 8 bytes 실수형
    long long e; // 8 bytes
    
    // 각 변수의 메모리 사이즈 출력
    printf("Size of char: %zu byte(s)\n", sizeof(a));
    printf("Size of int: %zu byte(s)\n", sizeof(b));
    printf("Size of float: %zu byte(s)\n", sizeof(c));
    printf("Size of double: %zu byte(s)\n", sizeof(d));
    printf("Size of long long: %zu byte(s)\n", sizeof(e));
    return 0;
}