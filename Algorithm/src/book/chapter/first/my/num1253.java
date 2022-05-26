package book.chapter.first.my;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num1253 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int startIdx = 0;
        int endIdx = 1;
        int count = 0;

        for (int i = 0; i < N - 1; i++) {
            int sum = A[startIdx] + A[endIdx];

            if (sum == A[endIdx + 1]) {
                count++;
                startIdx++;
                endIdx++;
            } else if (sum > A[endIdx + 1]) {
                endIdx++;
            } else if (sum < A[endIdx +1]) {
                startIdx++;
                endIdx++;
            }
        }

        System.out.println(count);


    }
}
