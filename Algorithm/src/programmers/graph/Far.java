package programmers.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Far {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] visited = new int[n + 1];
        for (int i = 0; i < n + 1; i++)
            visited[i] = -1;
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        for(int[] e : edge) {
            int x = e[0];
            int y = e[1];
            adj[x].add(y);
            adj[y].add(x);
        }
        bfs(1, visited, adj);

        for (int value : visited)
            if (value == Arrays.stream(visited).max().getAsInt())
                answer += 1;

        return answer;
    }

    void bfs(int v, int[] visited, ArrayList<Integer>[] adj) {
        int count = 0;
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{v, count});

        while (q.size() != 0) {
            int[] value = q.poll();
            v = value[0];
            count = value[1];

            if (visited[v] == -1) {
                visited[v] = count;
                count += 1;
                for (Integer e : adj[v])
                    q.add(new int[]{e, count});
            }
        }
    }

    public static void main(String[] args) {
        Far far = new Far();
        System.out.println(far.solution(6, new int[][] {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }
}
