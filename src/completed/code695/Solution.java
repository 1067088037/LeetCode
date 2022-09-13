package completed.code695;

class Solution {

    boolean[][] vis;

    int[] offsetX = {0, 0, 1, -1};
    int[] offsetY = {1, -1, 0, 0};

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        vis = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!vis[i][j]) {
                    max = Math.max(dfs(grid, i, j), max);
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return 0;
        if (vis[i][j]) return 0;
        vis[i][j] = true;
        int ret;
        if (grid[i][j] == 1) {
            ret = 1;
        } else {
            return 0;
        }
        for (int a = 0; a < 4; a++) {
            ret += dfs(grid, i + offsetX[a], j + offsetY[a]);
        }
        return ret;
    }
}