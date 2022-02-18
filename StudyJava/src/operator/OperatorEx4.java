package operator;

/**
 * 부호 연산자 '-'는 피연산자의 부호를 반대로 변경한 결과를 반환한다.
 * 부호 연산자 '+'는 하는 일이 없으며,
 * 쓰이는 경우도 거의 없다.
 * '-'가 있으니 형식적으로 '+'도 추가해 놓은 것뿐이다.
 * 부호 연산자는 boolean형과 char형을 제외한 기본형에만 사용할 수 있다.
 */

public class OperatorEx4 {
    public static void main(String[] args) {
        int i = -10;
        i = +i;
        System.out.println(i);

        i = -10;
        i = -i;
        System.out.println(i);
    }
}
