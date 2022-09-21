package completed.code1091;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0) return -1;
        if (n == 1) return 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        boolean[][] vis = new boolean[n][n];

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int i = poll[0], j = poll[1], len = poll[2];
            if (i < 0 || j < 0 || i >= n || j >= n) continue;
            if (vis[i][j]) continue;
            vis[i][j] = true;
            if (grid[i][j] == 1) continue;
            if (i == n - 1 && j == n - 1) return len;
            for (int k = 0; k < 8; k++) {
                int i1 = i + dir[k][0], j1 = j + dir[k][1];
                queue.offer(new int[]{i1, j1, len + 1});
            }
        }

        return -1;
    }
}
