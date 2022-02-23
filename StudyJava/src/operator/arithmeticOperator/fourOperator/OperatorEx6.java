package operator.arithmeticOperator.fourOperator;

public class OperatorEx6 {
    public static void main(String[] args) {
        byte a = 10;
        byte b = 20;
//        byte c = a + b
        // 위는 컴파일 에러가 발생.
        // 명시적으로 형변환이 필요하다.
        byte c = (byte) (a + b);
        System.out.println(c);
    }
}

/*
-> byte + byte -> int
위 처럼 자동으로 int로 형변환 되기 때문에
4 byte의 int형 값을 1 byte인 byte형에 저장하려고 했기 때문에
에러가 발생하는 것이다.

큰 자료형의 값을 작은 자료형의 변수에 저장하려면 명시적으로 형변환 연산자를 사용해서 변환해주어야 한다.
 */
