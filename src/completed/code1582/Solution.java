package completed.code1582;

import java.util.HashSet;

class Solution {
    HashSet<Integer> rows = new HashSet<>();
    HashSet<Integer> cols = new HashSet<>();

    public int numSpecial(int[][] mat) {
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            if (rows.contains(i)) continue;
            for (int j = 0; j < mat[i].length; j++) {
                if (cols.contains(j)) continue;
                if (isSpecial(mat, i, j)) {
                    rows.add(i);
                    cols.add(j);
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isSpecial(int[][] mat, int row, int col) {
        if (mat[row][col] != 1) return false;
        for (int i = 0; i < mat[0].length; i++) {
            if (i == col) continue;
            if (mat[row][i] == 1) {
                rows.add(row);
                return false;
            }
        }
        for (int i = 0; i < mat.length; i++) {
            if (i == row) continue;
            if (mat[i][col] == 1) {
                cols.add(col);
                return false;
            }
        }
        return true;
    }
}