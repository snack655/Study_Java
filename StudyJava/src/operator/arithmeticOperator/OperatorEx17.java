package operator.arithmeticOperator;

public class OperatorEx17 {
    public static void main(String[] args) {
        double pi = 3.141592;
        double shortPi = (int) (pi * 1000 + 0.5) / 1000.0;
        System.out.println(shortPi);
    }
}
/*
반올림하는 방법

(int)(pi * 1000 + 0.5) / 1000.0
(int)(3141.592 + 0.5) / 1000.0
-> (int)(3142.092) / 1000.0
3142 / 1000.0
3142.0 / 1000.0 -> 3.142
 */