package book.chapter.second.datastructure.my;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int length = str.length();
        Integer[] arr = new Integer[length];

        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(str.substring(i, i+1));
        }

        for (int j = 0; j < length; j++) {
            int max = arr[j];
            for (int i = j + 1; i < length; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                }
            }

            int idx = 0;
            for (int i = j; i < length; i++) {
                if (max == arr[i]) {
                    idx = i;
                }
            }

            int swap = arr[j];
            arr[j] = arr[idx];
            arr[idx] = swap;
        }
        for(int i = 0; i < length; i++) {
            System.out.print(arr[i]);
        }
    }
}
