package variable;

public class StudyVariable {
    public static void main(String[] args) {
        // 변수란?
        // 값을 저장할 있는 메모리상의 공간을 의미한다.
        // "단 하나의 값만 저장할 수 있는 메모리 공간."

        // 선언 방법
        int age; // age라는 이름의 변수를 선언
        // int : 변수타입, age : 변수이름

        // 변수의 초기화
        int age2 = 25; // 변수 age2를 선언하고 25로 초기화 한다.
        // 변수의 초기화란, 변수를 사용하기 전에 처음으로 값을 저장하는 것.

        int year = 0;
        System.out.println(year);
        System.out.println(age2);
        year = age2 + 2000;     // 변수 age의 값에 2000을 더해서 변수 year에 저장
        age2 = age2 + 1;          // 변수 age에 저장된 값을 1증가시킨다.
        System.out.println(year);
        System.out.println(age2);

        // 두 변수 값 교환하기
        int x = 10;
        int y = 20;
        int tmp;    // x값을 임시로 저장할 변수 선언
        System.out.println("x : "+x+" y : "+y);
        tmp = x;
        x = y;
        y = tmp;
        System.out.println("x : "+x+" y : "+y);

        // 변수의 명명규칙
        // '변수의 이름'처럼 프로그래밍에서 사용하는 모든 이름을 '식별자(identifier)'라고 하며,
        // 식별자는 같은 영역 내에서 서로 구분(식별)될 수 있어야한다.
        // 그 규칙은
        // 1. 대소문자가 구분되며 길이에 제한이 없다.
        // 2. 예약어를 사용해서는 안 된다.
        // 3. 숫자로 시작해서 안 된다.
        // 4. 특수문자는 '_'와 '$'만을 허용한다.

        // 권장하는 규칙들은 다음과 같다.
        // 1. 클래스 이름의 첫 글자는 항상 대문자로 한다.
        // - 변수와 메서드의 이름의 첫 글자는 항상 소문자로 한다.
        // 2. 여러 단어로 이루어진 이름은 단어의 첫 글자를 대문자로 한다.
        // - lastIndexOf, StringBuffer
        // 3. 상수의 이름은 모두 대문자로 한다. 여러 단어로 이루어진 경우 '_'로 구분한다.
        // - PI, MAX_NUMBER
    }
}
