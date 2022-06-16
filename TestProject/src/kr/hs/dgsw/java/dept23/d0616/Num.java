package kr.hs.dgsw.java.dept23.d0616;

public class Num<T extends Number> {
    private T value;

    public void print() {
        System.out.println(value);
    }

    public static void main(String[] args) {
        Num<Integer> num1 = new Num<>();
        Num<Double> num2 = new Num<>();
        Num<Short> num3 = new Num<>();
        // Num<String> num4 = new Num<String>(); <- 불가능 Number로 제약 조건을 주었기 때문에
    }
}
