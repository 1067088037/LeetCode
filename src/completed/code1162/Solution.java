package completed.code1162;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};

    public int maxDistance(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];

        boolean has0 = false;
        boolean has1 = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j, 0});
                    has1 = true;
                } else has0 = true;
            }
        }

        int max = -1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1], dis = poll[2];
            if (x < 0 || y < 0 || x >= m || y >= n) continue;
            if (vis[x][y]) continue;
            vis[x][y] = true;
            grid[x][y] = dis;
            max = Math.max(max, dis);
            for (int i = 0; i < 4; i++) {
                int x1 = x + dx[i];
                int y1 = y + dy[i];
                queue.offer(new int[]{x1, y1, dis + 1});
            }
        }

        return has0 && has1 ? max : -1;
    }
}