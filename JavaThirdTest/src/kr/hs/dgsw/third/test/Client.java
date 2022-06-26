package kr.hs.dgsw.third.test;

import java.util.Scanner;

public class Client {
    Scanner scanner;

    Client() {
        scanner = new Scanner(System.in);
    }

    public String throwOut() {
        while(true) {
            String answer = scanner.nextLine();
            if ("가위".equals(answer) || "바위".equals(answer) || "보".equals(answer) || "quit".equals(answer)) {
                return answer;
            }
            System.out.println("다시 입력해주세요.");
        }
    }
}
