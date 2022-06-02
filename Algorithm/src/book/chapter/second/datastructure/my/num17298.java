package book.chapter.second.datastructure.my;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class num17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            Boolean isHaveNGE = false;
            for (int j = i+1; j < N; j++) {
                if (A[i] < A[j]) {
                    System.out.print(A[j] + " ");
                    isHaveNGE = true;
                    break;
                }
            }
            if (!isHaveNGE)
                System.out.print("-1 ");
        }
    }
}
