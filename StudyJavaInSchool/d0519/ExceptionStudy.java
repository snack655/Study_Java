package kr.hs.dgsw.java.dept23.d0519;

public class ExceptionStudy {
    public void method1() throws MyException {
        System.out.println("method1 호출됨");

        // 예외를 발생시켜 봅시다.
        MyException exception = new MyException();
        throw exception;
    }

    public void method2() {
        try {
            method1();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}
