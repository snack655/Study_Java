package book.chapter.first.my;

import java.util.Scanner;

public class num1546 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int best = 0;
        double sum = 0;
        int[] arr = new int[n];
        int[] reArr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
            if (best <= arr[i]) {
                best = arr[i];
            }
        }
        for (int i = 0; i < n; i++) {
            sum += arr[i] / (double)best * 100.0;
        }
        System.out.println(sum / n);
    }
}
