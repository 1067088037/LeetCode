package completed.code121;

class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        // 在第i天卖出的最大利润
        int[] dp = new int[prices.length];
        dp[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
        }
        return dp[dp.length - 1];
    }
}