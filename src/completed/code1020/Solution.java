package completed.code1020;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private final int Sea = 0;
    private final int Land = 1;
    private final int Visited = 2;

    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};

    public int numEnclaves(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            queue.add(new int[]{i, 0});
            queue.add(new int[]{i, n - 1});
        }
        for (int i = 0; i < n; i++) {
            queue.add(new int[]{0, i});
            queue.add(new int[]{m - 1, i});
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1];
            if (x < 0 || y < 0 || x >= m || y >= n) continue;
            switch (grid[x][y]) {
                case Sea, Visited -> {
                }
                case Land -> {
                    grid[x][y] = Visited;
                    for (int i = 0; i < 4; i++) {
                        int newX = x + dx[i];
                        int newY = y + dy[i];
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }

        int count = 0;
        for (int[] ints : grid) {
            for (int anInt : ints) {
                if (anInt == Land) count++;
            }
        }
        return count;
    }
}