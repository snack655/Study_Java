package kr.hs.dgsw.java.dept23.d0526;

public class Run100mThread  extends Thread {
    private final String name;
    private final double time;
    private double distance = 0;

    Run100mThread(String name, double time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public void run() {
        while (distance < 100) {
            distance += time;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%s -> %.1f\n", name, distance);
        }
        System.out.println(name + " 완주!");
    }

    public static void main(String[] args) {
        Run100mThread ub = new Run100mThread("우사인볼트", 9.8);
        Run100mThread kukyoung = new Run100mThread("김국영", 8);
        Run100mThread jigun = new Run100mThread("박지건", 7);
        Run100mThread other = new Run100mThread("일반인", 5);


        ub.start();
        kukyoung.start();
        jigun.start();
        other.start();
    }

}
