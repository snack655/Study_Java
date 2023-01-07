package book.chapter.second.datastructure.my;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class num11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> myQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (myQueue.size() == 0) {
                    System.out.println("0");
                } else {
                    System.out.println(myQueue.poll());
                }
            } else {
                myQueue.add(input);
                Stream<Integer> newQueue = myQueue.stream().sorted((o1, o2) -> {
                    int abs1 = Math.abs(o1);
                    int abs2 = Math.abs(o2);
                    if (abs1 > abs2) {
                        return -1;
                    } else if (abs1 < abs2) {
                        return 1;
                    } else {
                        return o1 < 0 ? 1 : -1;
                    }
                });
                for (int j = 0; j < myQueue.size(); j++) {
                    myQueue.remove();
                }
                newQueue.forEach(myQueue::add);
            }

        }
    }
}
