package book.chapter.second.sort.my;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num1377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int i;
        boolean isSwap;
        for (i = 0; i < n - 1; i++) {
            isSwap = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    isSwap = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!isSwap)
                break;
        }

        System.out.println(i + 1);
    }
}
