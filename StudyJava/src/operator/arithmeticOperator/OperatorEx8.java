package operator.arithmeticOperator;

public class OperatorEx8 {
    public static void main(String[] args) {
        int a = 1_000_000;  // 1,000,000 1백만
        int b = 2_000_000;  // 2,000,000 2백만

        long c = a * b;     // a * b = 2,000,000,000,000 ?

        System.out.println(c);
    }
}

/*
int 타입과 int 타입의 연산결과는 int 타입이다.
a * b 의 결과가 이미 int 타입의 값(-1454759936)이므로 long 형으로 자동
형변환되어도 값은 변하지 않는다.

올바른 결과를 얻으러면
OperatorEx9 처럼
변수 a 또는 b의 타입을 'long' 으로 형변환해야 한다.
 */