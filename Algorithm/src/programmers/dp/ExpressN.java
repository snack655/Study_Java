package programmers.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExpressN {
    public static void main(String[] args) {
        ExpressN en = new ExpressN();
        System.out.println(en.solution(2, 11));
    }

    public int solution(int N, int number) {
        List<Set<Integer>> countList = new ArrayList<>();

        for (int i = 0; i < 9; i++)
            countList.add(new HashSet<>());

        countList.get(1).add(N); // N을 1개 쓴 값은 N 혼자이다.

        System.out.println(countList);

        for (int i = 2; i < 9; i++) {
            Set<Integer> countSet = countList.get(i);

            for (int j = 1; j <= i; j++) {
                Set<Integer> preSet = countList.get(j);
                Set<Integer> postSet = countList.get(i - j);

                System.out.println("preset  :  " + preSet);
                System.out.println("postset  :  " +postSet);

                for (int preNum : preSet) {
                    for (int postNum : postSet) {
                        countSet.add(preNum + postNum);
                        countSet.add(preNum - postNum);
                        countSet.add(preNum * postNum);

                        if (preNum != 0 && postNum != 0)
                            countSet.add(preNum / postNum);
                    }
                }
            }

            countSet.add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }

        for (Set<Integer> sub : countList) {
            if (sub.contains(number))
                return countList.indexOf(sub);
        }
        return -1;
    }
}
