package operator.arithmeticOperator.fourOperator;

public class OperatorEx11 {
    public static void main(String[] args) {
        char a = 'a';
        char d = 'd';
        char zero = '0';
        char two = '2';

        System.out.printf("'%c' - '%c' = %d%n", d, a, d - a);
        System.out.printf("'%c' - '%c' = %d%n", two, zero, two - zero);
        System.out.printf("'%c'= %d%n", a, (int)a);
        System.out.printf("'%c'= %d%n", d, (int)d);
        System.out.printf("'%c'= %d%n", zero, (int)zero);
        System.out.printf("'%c'= %d%n", two, (int)two);
    }
}

/*
문자는 실제로 해당 문자의 유니코드(부호없는 정수)로 바뀌어 저장되므로 문자간의 사칙연산은 정수간의 연산과 동일하다.
유니코드에서 '0' ~ '9'까지의 문자가 연속적으로 배치되어 있다.
그렇게 때무에 해당 문자에서 '0'을 빼주면 숫자로 변환되는 것이다.
 */
