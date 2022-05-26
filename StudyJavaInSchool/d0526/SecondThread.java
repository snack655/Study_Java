package kr.hs.dgsw.java.dept23.d0526;

import java.util.Random;

public class SecondThread implements Runnable {
    private final String name;

    public SecondThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s : %d\n", name, i);
            try {
                Thread.sleep(new Random().nextInt(500) + 1000);
            } catch(InterruptedException e) { }
        }
    }

    public static void main(String[] args) {
        SecondThread nadal = new SecondThread("나달");
        SecondThread son = new SecondThread("손흥민");

        Thread nadalThread = new Thread(nadal);
        nadalThread.start();


    }
}
