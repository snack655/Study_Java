package operator.arithmeticOperator.fourOperator;

public class OperatorEx5 {
    public static void main(String[] args) {
        int a = 10;
        int b = 4;

        System.out.printf("%d + %d = %d%n", a, b, a + b);
        System.out.printf("%d - %d = %d%n", a, b, a - b);
        System.out.printf("%d * %d = %d%n", a, b, a * b);
        System.out.printf("%d / %d = %d%n", a, b, a / b);
        System.out.printf("%d / %.1f = %.1f%n", a, (float)b, a / (float)b);
    }
}

/*
10을 4로 나눈 결과가 2.5가 아닌 2라는 것.

-> 나누기 연산자의 두 피연산자가 모두 int타입인 경우,
연산결과 역시 int 타입.
-> int타입은 소수점을 저장하지 못하므로 정수만 남고 소수점 이하는 버려지기 때문.
이 때, 반올림이 발생하지 않음.


 */