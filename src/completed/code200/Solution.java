package completed.code200;

class Solution {

    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};
    int m, n;
    boolean[][] vis;
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

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(grid, new Point(i, j)))
                    count++;
            }
        }

        return count;
    }

    private boolean dfs(char[][] grid, Point p) {
        if (!p.isValid()) return false;
        if (vis[p.i][p.j]) return false;
        if (grid[p.i][p.j] == '0') return false;
        vis[p.i][p.j] = true;

        for (int i = 0; i < 4; i++) {
            Point point = new Point(p.i + dx[i], p.j + dy[i]);
            dfs(grid, point);
        }

        return true;
    }
}