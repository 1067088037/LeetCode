package completed.code74;

class Solution {

    int m, n;

    public boolean searchMatrix(int[][] matrix, int target) {
        m = matrix.length;
        n = matrix[0].length;

        int left = 0, right = m * n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int val = getValue(matrix, mid);
            if (target == val) return true;
            else if (target < val) right = mid;
            else left = mid + 1;
        }

        return false;
    }

    private int getValue(int[][] matrix, int index) {
        int i = index / n;
        int j = index % n;
        return matrix[i][j];
    }
}