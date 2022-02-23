package operator.arithmeticOperator;

public class OperatorEx13 {
    public static void main(String[] args) {
        char c1 = 'a';

        // char c2 = c1 + 1;            // 컴파일 에러발생! -> int로 형변환..
        char c2 = 'a' + 1;              // 컴파일 에러 없음.

        System.out.println(c2);
    }
}

/*
왜 라인 8은 에러가 발생하지 않을까?
-> 'a'+1이 리터럴 간의 연산이기 때문이다.
상수 또는 리터럴 간의 연산은 실행 과정동안 변하는 값이 아니기 때문에,
컴파일 시에 컴파일러가 계산해서 그 결과로 대체함으로써 코드를 보다 효율적으로 만든다.
 */
