package kr.hs.dgsw.java.dept23.d0526;

public class Developer implements Job {
    @Override
    public void work() {
        System.out.println("프로그램 개발자가 프로그램을 개발합니다.");
    }

    @Override
    public int getPrice() {
        return 20000;
    }

    public static void main(String[] args) {
        Job developer = new Developer();
    }
}
