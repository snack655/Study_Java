package book.chapter.second.datastructure.my;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class num2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        boolean hasSwap;
        do {
            hasSwap = false;
            for (int i = 0; i < n - 1; i++) {
                if (arr.get(i) > arr.get(i + 1)) {
                    hasSwap = true;
                    int swap = arr.get(i + 1);
                    arr.set(i + 1, arr.get(i));
                    arr.set(i, swap);
                }
            }
        } while (hasSwap);

        for (int i = 0; i < n; i++) {
            System.out.println(arr.get(i));
        }
    }
}
