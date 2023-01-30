package book.chapter.second.datastructure.my;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i - (j + 1)] > arr[i]) {
                    int select = arr[i];
                    for (int x = i - (j + 1); x < i; x++) {
                        arr[i - x] = arr[i];
                    }
                    arr[i - (j + 1)] = select;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}
