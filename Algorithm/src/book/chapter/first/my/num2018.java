package book.chapter.first.my;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int result = 0;
        int[] arr = new int[N + 1];
        arr[0] = 0;

        for (int i = 1; i < N; i++) {
            arr[i] = arr[i - 1] + i;
            if (arr[i] % N == 0)
                result++;
        }

        System.out.println(result+1);
    }
}
