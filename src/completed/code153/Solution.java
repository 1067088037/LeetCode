package completed.code153;

class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.min(nums[0], nums[1]);

        int min = Integer.MAX_VALUE;
        int left = 0, right = nums.length; // [l, r)

        while (left < right) {
            int mid = left + (right - left) / 2;
            int val = nums[mid];
            if (nums[left] < val) {
                // 左边有序
                min = Math.min(nums[left], min);
                left = mid + 1;
            } else {
                // 右边有序
                min = Math.min(val, min);
                right = mid;
            }
        }

        return min;
    }
}