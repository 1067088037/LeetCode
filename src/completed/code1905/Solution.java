package completed.code1905;

class Solution {

    int rc;
    int cc;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        rc = grid1.length;
        cc = grid1[0].length;

        for (int i = 0; i < rc; i++) {
            for (int j = 0; j < cc; j++) {
                if (grid2[i][j] == 1) {
                    grid2[i][j] += grid1[i][j];
                }
            }
        }
        int res = 0;
        for (int i = 0; i < rc; i++) {
            for (int j = 0; j < cc; j++) {
                // DFS BFS任选一个
                if (grid2[i][j] == 2 && fill(grid2, i, j)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean fill(int[][] grid, int i, int j) {
        if (i < 0 || i >= rc || j < 0 || j >= cc) {
            return true;
        }
        if (grid[i][j] != 2) {
            return grid[i][j] == 0;
        }
        grid[i][j] = 0;
        boolean down = fill(grid, i - 1, j);
        boolean up = fill(grid, i + 1, j);
        boolean right = fill(grid, i, j - 1);
        boolean left = fill(grid, i, j + 1);
        return down && up && right && left;
    }
}