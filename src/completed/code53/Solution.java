package completed.code53;

class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] <= 0) dp[i] = nums[i];
            else dp[i] = nums[i] + dp[i - 1];
            if (dp[i] > max) max = dp[i];
        }
        return max;
    }
}
