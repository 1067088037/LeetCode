package completed.code934;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.shortestBridge(new int[][]{{0, 1, 0}, {0, 0, 0}, {0, 0, 1}});
    }

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n && queue.isEmpty(); j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    break;
                }
            }
        }
        Queue<int[]> edge = new LinkedList<>();

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int i = poll[0], j = poll[1];
            if (i < 0 || j < 0 || i >= n || j >= n) continue;
            if (grid[i][j] == 0) {
                edge.offer(new int[]{i, j});
                continue;
            }
            if (vis[i][j]) continue;
            vis[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int i1 = i + dx[k], j1 = j + dy[k];
                queue.offer(new int[]{i1, j1});
            }
        }

        int count = 0;
        while (!edge.isEmpty()) {
            queue = edge;
            edge = new LinkedList<>();
            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                int i = poll[0], j = poll[1];
                if (i < 0 || j < 0 || i >= n || j >= n) continue;
                if (vis[i][j]) continue;
                vis[i][j] = true;
                if (grid[i][j] == 1) {
                    return count;
                }
                for (int k = 0; k < 4; k++) {
                    int i1 = i + dx[k], j1 = j + dy[k];
                    edge.offer(new int[]{i1, j1});
                }
            }
            count++;
        }

        return -1;
    }
}