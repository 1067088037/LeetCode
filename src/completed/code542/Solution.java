package completed.code542;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    int m, n;

    int[] direX = new int[]{1, -1, 0, 0};
    int[] direY = new int[]{0, 0, 1, -1};

    Queue<int[]> queue = new LinkedList<>();

    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0], y = point[1];
            for (int i = 0; i < 4; i++) {
                int x1 = x + direX[i], y1 = y + direY[i];
                if (x1 < 0 || y1 < 0 || x1 >= m || y1 >= n) continue;
                if (mat[x1][y1] != -1) continue;
                mat[x1][y1] = mat[x][y] + 1;
                queue.offer(new int[]{x1, y1});
            }
        }

        return mat;
    }
}