package operator.arithmeticOperator;

public class OperatorEx16 {
    public static void main(String[] args) {
        float pi = 3.141592f;
        float shortPi = (int) (pi * 1000) / 1000f;
        System.out.println(shortPi);
    }
}

/*
순서

(int) (pi * 1000) / 1000f
(int) (3141.592f) / 1000f
3141 / 1000f
3141.0f / 1000f -> 3.141f
 */