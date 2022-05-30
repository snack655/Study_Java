package book.chapter.second.datastructure.my;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] items = new int[N];
        int result = 0;
        int startIdx = 0;
        int endIdx = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(items);
        for (int i = 0; i < N - 1; i++) {
            startIdx = i;
            endIdx = startIdx + 1;
            for (int j = 0; j < N - i - 1; j++) {
                int sum = items[startIdx] + items[endIdx];
                if (sum == M) {
                    result++;
                    startIdx++;
                    endIdx = startIdx + 1;
                } else if (sum < M) {
                    endIdx++;
                } else {
                    startIdx++;
                    endIdx = startIdx + 1;
                }
            }
        }

        System.out.println(result);
    }
}
