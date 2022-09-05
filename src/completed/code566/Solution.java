package completed.code566;

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length * mat[0].length != r * c) {
            return mat;
        }

        int[][] res = new int[r][c];
        int x = 0, y = 0;
        for (int[] ints : mat) {
            for (int anInt : ints) {
                res[x][y] = anInt;
                y++;
                if (y == c) {
                    y = 0;
                    x++;
                }
            }
        }

        return res;
    }
}