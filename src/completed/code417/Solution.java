package completed.code417;

import java.util.*;

class Solution {

    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};
    boolean[][] vis1;
    boolean[][] vis2;


    Set<List<Integer>> res = new HashSet<>();

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Queue<int[]> queue = new LinkedList<>();
        int m = heights.length, n = heights[0].length;
        vis1 = new boolean[m][n];
        vis2 = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            queue.offer(new int[]{i, 0});
        }
        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{0, i});
        }
        bfs(queue, heights, m, n, false);

        for (int i = 0; i < m; i++) {
            queue.offer(new int[]{i, n - 1});
        }
        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{m - 1, i});
        }
        bfs(queue, heights, m, n, true);

        return res.stream().toList();
    }

    private void bfs(Queue<int[]> queue, int[][] heights, int m, int n, boolean add) {
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1];
            if (!add) {
                // vis1
                if (vis1[x][y]) continue;
                vis1[x][y] = true;
            } else {
                // vis2
                if (vis2[x][y]) continue;
                vis2[x][y] = true;
                if (vis1[x][y]) {
                    res.add(List.of(x, y));
                }
            }
            for (int i = 0; i < 4; i++) {
                int x1 = x + dx[i];
                int y1 = y + dy[i];
                if (x1 < 0 || y1 < 0 || x1 >= m || y1 >= n) continue;
                if (heights[x1][y1] >= heights[x][y])
                    queue.offer(new int[]{x1, y1});
            }
        }
    }
}
