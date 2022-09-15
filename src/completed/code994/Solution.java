package completed.code994;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> next;

        int m = grid.length, n = grid[0].length;
        boolean hasOrange = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) queue.offer(new int[]{i, j});
                if (grid[i][j] != 0) hasOrange = true;
            }
        }

        if (!hasOrange) return 0;

        int minute = -1;
        while (!queue.isEmpty()) {
            next = new LinkedList<>();
            while (!queue.isEmpty()) {
                int[] point = queue.poll();
                int x = point[0], y = point[1];
                for (int i = 0; i < 4; i++) {
                    int x1 = x + dx[i], y1 = y + dy[i];
                    if (x1 >= 0 && y1 >= 0 && x1 < m && y1 < n && grid[x1][y1] == 1) {
                        grid[x1][y1] = 2;
                        next.offer(new int[]{x1, y1});
                    }
                }
            }
            minute++;
            queue = next;
        }

        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                if (ints[j] == 1) return -1;
            }
        }
        return minute;
    }
}