package variable;

import java.util.Scanner;

public class StudyType {
    public static void main(String[] args) {
        // 기본형과 참조형
        // 기본형 변수는 실제 값(data)를 저장하는 반면,
        // 참조형 변수는 어떤 값이 저장되어 있는 주소(memory address)를 값으로 갖는다.

        // 참조변수를 선언하는 방법
        // 클래스이름 변수이름; 변수의 타입이 기본형이 아닌 것들은 모두 참조변수이다.
        // StudyType date = new Date(); // Date객체를 생성해서, 그 주소를 date에 저장

        // 기본형
        // 논리형 : boolean
        // 문자형 : char
        // 정수형 : byte, short, int, long
        // 실수형 : float, double

        // 상수와 리터럴(constant & literal)
        // '상수(constant)'는 변수와 마찬가지로 '값을 저장할 수 있는 공간'이지만,
        // 변수와 달리 한번 값을 저장하면 다른 값으로 변경할 수 없다.
        // 상수는 앞에 final 을 붙여 선언한다.
        final int MAX_SPEED = 10; // 상수 MAX_SPEED를 선언 & 초기화


        // 리터럴(literal)
        // 러터럴 = 상수
        // 변수(variable) : 하나의 값을 저장하기 위한 공간
        // 상수(constant) : 값을 한번만 저장할 수 있는 공간
        // 리터럴(literal) : 그 자체로 값을 의미하는 것

        // 상수가 필요한 이유
        int triangleArea = (20 * 20) / 2;   // 삼각형의 면적을 구하는 공식
        int rectangleArea = 20 * 20;        // 사각형의 면적을 구하는 공식

        // 20이 아닌 다른 값을 넣고 싶다면.. 불편.. 몇번이나 수정을 하는 거야

        final int WIDTH = 20;   // 폭
        final int HEIGHT = 10;  // 높이
        triangleArea = (WIDTH * HEIGHT) / 2;    // 삼각형의 면적을 구하는 공식
        rectangleArea = WIDTH * HEIGHT;         // 사각형의 면적을 구하는 공식


        // 문자 리터럴과 문자열 리터럴
        char ch = 'J';          // char ch = 'Java'; 이렇게 할 수 없다.
        String name = "Java";   // 변수 name에 문자열 리터럴 "Java"를 저장

        String str = ""; // 가능
        // char ch = ''; // 불가능
        ch = ' '; // 가능

        // 원래 String 은 클래스로 아래와 같이 객체를 생성하는 연산자
        // new 를 사용해야 하지만 특별히 위와 같은 표현도 허용
        String name2 = new String("Java"); // String 객체를 생성

        // tmi. 덧셈 연산자를 이용하여 문자열을 결합할 수 있다.
        name = "Ja" + "va"; // name 은 "Java"
        str = name + 8.0;   // str 은 "Java8.0"
        // 덧셈 연산자(+)는 피연산자가 모두 숫자일 때는 두 수를 더하지만,
        // 피연산자 중 어느 한 쪽이 String 이면 나머지 한 쪽을 먼저
        // String 으로 변환한 다음 두 String 을 결합한다.

        // 형식화된 출력 - printf()
        // printf()는 '지시자(specifier)'를 통해 변수의 값을 여러 가지 형식으로
        // 변환하여 출력하는 기능을 가지고 있다. '지시자'는 값을 어떻게 출력할 것인지를 지정해주는 역할을 한다.
        System.out.printf("age : %d", 17);
        // C 언어랑 다른게 없..

        // %b : 불리언(boolean) 형식으로 출력
        // %d : 10진
        // %o : 8진
        // %x, %X : 16진
        // %f : 부동 소수점
        // %e, %E : 지수(exponent) 표현식의 형식
        // %c : 문자(character)
        // %s : 문자열(string)

        // 화면에서 입력받기 - Scanner
        Scanner scanner = new Scanner(System.in);   // Scanner 클래스의 객체를 생성
        String input = scanner.nextLine(); // 입력받은 내용을 input 에 저장
        int num = Integer.parseInt(input); // 입력받은 내용을 int 타입의 값으로 변환
        // nextLine()이라는 메서드를 호출하면,
        // 입력대기 상태에 있다가 입력을 마치고 '엔터키(Enter)'를 누르면 입력한 내용이 문자열로 반환된다.
        // Integer.parseInt()라는 메서드는 문자열을 int 타입의 정수로 변환한다.

        // 이러한 형변환 수고를 덜기위한 것들이 있다.
        num = scanner.nextInt();
    }
}
