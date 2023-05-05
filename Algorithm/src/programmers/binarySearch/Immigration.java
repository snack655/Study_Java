package programmers.binarySearch;

import java.util.Arrays;

public class Immigration {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long min = 1;
        long max = (long) times[times.length - 1] * n;
        long mid = 0;
        long sum;
        long answer = max;

        while (min <= max) {
            sum = 0;
            mid = (min + max) / 2;

            for (int time: times) {
                sum += mid / time;
            }

            if (sum >= n) {
                answer = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Immigration immigration = new Immigration();
        System.out.println(immigration.solution(6, new int[]{7, 10}));
    }
}
