package completed.code209;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int sum = 0;
        int start = 0, end = 0;
        int min = Integer.MAX_VALUE;

        while (end < n) {
            sum += nums[end];
            while (sum >= target) {
                min = Math.min(min, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}