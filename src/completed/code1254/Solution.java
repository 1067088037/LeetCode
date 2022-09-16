package completed.code1254;

class Solution {
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};
    int m, n;
    int count = 0;

    class Point {
        int i;
        int j;

        public Point(int x, int y) {
            this.i = x;
            this.j = y;
        }

        public boolean isValid() {
            return i >= 0 && j >= 0 && i < m && j < n;
        }
    }

    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && dfs(grid, new Point(i, j))) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean dfs(int[][] grid, Point p) {
        if (!p.isValid()) return false;
        if (grid[p.i][p.j] == 1) return true;
        grid[p.i][p.j] = 1;

        boolean ans = true;
        for (int i = 0; i < 4; i++) {
            Point point = new Point(p.i + dx[i], p.j + dy[i]);
            ans = dfs(grid, point) && ans;
        }

        return ans;
    }
}