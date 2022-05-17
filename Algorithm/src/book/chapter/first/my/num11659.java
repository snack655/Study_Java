package book.chapter.first.my;

import java.util.Scanner;

public class num11659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] sumArr = new int[N + 1];
        int[] finalArr = new int[M];

        sumArr[0] = 0;
        for (int i = 1; i <= N; i++) {
            sumArr[i] = sumArr[i - 1] + sc.nextInt();
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            finalArr[i] = sumArr[b] - sumArr[a - 1];
        }

        for (int i = 0; i < M; i++) {
            System.out.println(finalArr[i]);
        }
    }
}
