package programmers.dbfs;

public class TargetNum {
    public static void main(String[] args) {
        TargetNum tn = new TargetNum();
        int[] ns = {4, 1, 2, 1};
        System.out.println(tn.solution(ns, 4));
    }

    static int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    public void dfs(int[] numbers, int target, int idx, int sum) {
        if (idx == numbers.length) {
            if (sum == target) answer++;
        } else {
            dfs(numbers, target, idx + 1, sum + numbers[idx]);
            dfs(numbers, target, idx + 1, sum - numbers[idx]);
        }
    }
}
