package operator.singleOperator.upperOperator;

public class OperatorEx3 {
    public static void main(String[] args) {
        int i = 5, j = 5;
        System.out.println(i++);
        System.out.println(++j);
        System.out.println("i = " + i + ", j = " +j);

        int x = 5;
        System.out.println(x++ - ++x);

        // 식에 두 번 이상 포함된 변수에 증감연산자를 사용하는 것은 피해야 한다.

    }
}
