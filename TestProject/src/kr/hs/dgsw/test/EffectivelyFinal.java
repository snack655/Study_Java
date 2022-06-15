package kr.hs.dgsw.test;

public class EffectivelyFinal {
    int a = 0;  // 인스턴스 변수
    static int b = 0;   // 클래스 변수

    public void method() {
        int value = 0; // 지역 변수
        Calc calc = () -> System.out.println(a--);
        Calc calc2 = () -> System.out.println(b--);
    }
}

@FunctionalInterface
interface Calc {
    void minus();
}
