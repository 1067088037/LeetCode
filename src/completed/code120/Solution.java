package completed.code120;

import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) return triangle.get(0).get(0);
        if (triangle.size() == 2)
            return Math.min(triangle.get(1).get(0), triangle.get(1).get(1)) + triangle.get(0).get(0);

        int[][] dp = new int[triangle.size() + 1][triangle.get(triangle.size() - 1).size() + 1];
        dp[0][0] = triangle.get(0).get(0);
        dp[1][0] = triangle.get(1).get(0) + dp[0][0];
        dp[1][1] = triangle.get(1).get(1) + dp[0][0];
        for (int i = 2; i < triangle.size(); i++) {
            int m = triangle.get(i).size();
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < m - 1; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
            dp[i][m - 1] = dp[i - 1][m - 2] + triangle.get(i).get(m - 1);
        }
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.size(); i++) {
            max = Math.min(max, dp[triangle.size() - 1][i]);
        }
        return max;
    }
}