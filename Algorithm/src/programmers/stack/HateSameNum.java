package programmers.stack;

import java.util.*;

public class HateSameNum {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for (int num : arr) {
            if (stack.isEmpty() || stack.peek() != num) {
                stack.push(num);
            }
        }
        int[] answer = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }
        return answer;
    }

    public static void main(String[] args) {
        HateSameNum hs = new HateSameNum();
        int[] arr = { 1,1,3,3,0,1,1 };
        System.out.println(Arrays.toString(hs.solution(arr)));
    }
}
