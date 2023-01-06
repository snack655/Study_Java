package book.chapter.second.datastructure.my;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class num2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> myQueue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            myQueue.add(i);
        }

        int flag = 0;
        while (true) {
            if (flag == 0) {
                myQueue.remove();
                flag = 1;
            } else {
                int removedNum = myQueue.remove();
                myQueue.add(removedNum);
                flag = 0;
            }

            if (myQueue.size() == 1) {
                System.out.println(myQueue.remove());
                break;
            }
        }

    }
}
