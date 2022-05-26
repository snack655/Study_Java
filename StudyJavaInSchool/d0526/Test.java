package kr.hs.dgsw.java.dept23.d0526;

public class Test {
    void calc(Adder adder) {
        adder.add(3, 4);
    }


    public static void main(String[] args) {
        Test test = new Test();
        Adder adder = (a, b) -> a + b;
        test.calc(adder);

        test.calc(
                (a, b) ->  a + b
        );
    }
}
