package book.chapter.first.my;

import java.util.Scanner;

public class num11720 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int sum = 0;
        int n = scan.nextInt();
        String num = scan.next();

        for (int i = 0; i < n; i++) {
            int value = num.charAt(i);
            sum += (value - 48);
        }
        System.out.println(sum);
    }
}
