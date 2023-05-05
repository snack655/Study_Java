package programmers.dbfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GameMap {
    public static void main(String[] args) {
        GameMap gm = new GameMap();
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(gm.solution(maps));
    }

    public int solution(int[][] maps) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{0, 0});

        while (q.size() != 0) {
            Integer[] xy = q.poll();
            int x = xy[0];
            int y = xy[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length)
                    continue;

                if (maps[nx][ny] == 0)
                    continue;

                if (maps[nx][ny] == 1) {
                    maps[nx][ny] = maps[x][y] + 1;
                    q.add(new Integer[]{nx, ny});
                }
            }
        }

        if (maps[maps.length - 1][maps[0].length - 1] == 1)
            return -1;
        else
            return maps[maps.length - 1][maps[0].length - 1];
    }
}
