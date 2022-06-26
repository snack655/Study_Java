package kr.hs.dgsw.third.test;

import java.util.Random;

public class Computer {
    Random random;
    int myAnswer;
    int[] result = new int[3];

    Computer() {
        random = new Random();
    }

    public String judgeResult(String answer) {
        myAnswer = random.nextInt(3);
        int numAnswer = castToNumber(answer);

        System.out.println(answer + " vs " + castToString(myAnswer));
        if (numAnswer == myAnswer) {
            result[0] += 1;
            return "무승부 입니다.";
        } else if (
                (numAnswer == 0 && myAnswer == 2)
                || (numAnswer == 1 && myAnswer == 0)
                || (numAnswer == 2 && myAnswer == 1)
        ) {
            result[1] += 1;
            return "당신이 이겼습니다.";
        } else {
            result[2] += 1;
            return "당신이 졌습니다.";
        }
    }

    public void printResult() {
        System.out.println("전적 : " + result[1] + "승 " + result[0] + "무 " + result[2] + "패\n");
    }

    private int castToNumber(String answer) {
        if ("가위".equals(answer)) {
            return 0;
        } else if ("바위".equals(answer)) {
            return 1;
        } else if ("보".equals(answer)) {
            return 2;
        }
        return -1;
    }

    private String castToString(int answer) {
        if (answer == 0) {
            return "가위";
        } else if (answer == 1) {
            return "바위";
        } else if (answer == 2) {
            return "보";
        }
        return "";
    }
}
