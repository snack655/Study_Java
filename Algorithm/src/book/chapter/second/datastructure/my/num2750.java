package book.chapter.second.datastructure.my;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class num2750 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        ArrayList numList = new ArrayList();
        for (int i = 0; i < num; i++) {
            numList.add(scan.nextInt());
        }
        Collections.sort(numList);
        for (int i = 0; i < num; i++) {
            System.out.println(numList.get(i));
        }
    }
}
