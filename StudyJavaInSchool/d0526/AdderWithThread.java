package kr.hs.dgsw.java.dept23.d0526;

import java.util.Scanner;

public class AdderWithThread {
    private final Scanner scanner;

    public AdderWithThread() {
        this.scanner = new Scanner(System.in);
    }

    public void execute() {
        while (true) {
            System.out.println("두 정수를 입력하세요.");
            int value1 = scanner.nextInt();
            int value2 = scanner.nextInt();

            if (value1 == 0 && value2 == 0) {
                break;
            }

            calculateAndPrint(value1, value2);
        }
        System.out.println("프로그램을 종료합니다.");
    }

    private void calculateAndPrint(int value1, int value2) {
        Calculator calculator = new Calculator(value1, value2);
        new Thread(calculator).start();
    }


    public static class Calculator implements Runnable {
        private int value1;
        private int value2;

        public Calculator(int value1, int value2) {
            this.value1 = value1;
            this.value2 = value2;
        }

        @Override
        public void run() {

        }
    }

    public static void main(String[] args) {
        AdderWithThread adder = new AdderWithThread();
        adder.execute();
    }
}
