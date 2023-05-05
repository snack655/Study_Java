package programmers.dp;

import java.util.HashSet;
import java.util.Set;

public class ExpressN2 {
    public static void main(String[] args) {
        ExpressN2 en2 = new ExpressN2();
        System.out.println(en2.solution(2, 11));
    }

    public int solution(int N, int number) {
        int answer = -1;

        Set<Integer>[] setArr = new Set[9];
        int t = N;
        for(int i = 1; i < 9; i++) {
            setArr[i] = new HashSet<>();
            setArr[i].add(t);
            t = t * 10 + N;
        }

        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < i; j++) {
                for(Integer a : setArr[j]) {
                    for (Integer b : setArr[i - j]) {
                        setArr[i].add(a + b);
                        setArr[i].add(a - b);
                        setArr[i].add(b - a);
                        setArr[i].add(a * b);
                        if (b != 0) {
                            setArr[i].add(a / b);
                        }
                        if (a != 0) {
                            setArr[i].add(b / a);
                        }
                    }
                }
            }
        }

        for (int i = 1; i < 9; i++) {
            if (setArr[i].contains(number)) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
