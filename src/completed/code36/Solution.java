package completed.code36;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][] grids = new boolean[9][10];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char num = board[i][j];
                if (num == '.') continue;
                int number = num - '0';
                if (rows[i][number]) return false;
                if (cols[j][number]) return false;
                int gridId = i / 3 * 3 + j / 3;
                if (grids[gridId][number]) return false;
                rows[i][number] = true;
                cols[j][number] = true;
                grids[gridId][number] = true;
            }
        }

        return true;
    }
}