package book.chapter.second.datastructure.answer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class num11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> myQueue = new PriorityQueue<>((o1, o2) -> {
            int firstAbs = Math.abs(o1);
            int secondAbs = Math.abs(o2);
            if (firstAbs == secondAbs)
                return o1 > o2 ? 1 : -1; // 절댓값이 값으면 음수 정렬하기
            else
                return firstAbs - secondAbs; // 절댓값을 기준으로 정렬하기
        });

        for (int i = 0; i < n; i++) {
            int request = Integer.parseInt(br.readLine());
            if (request == 0) {
                if (myQueue.isEmpty())
                    System.out.println("0");
                else
                    System.out.println(myQueue.poll());
            } else {
                myQueue.add(request);
            }
        }
    }
}
