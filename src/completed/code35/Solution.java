package completed.code35;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int i = (l + r) / 2;
            if (nums[i] == target) return i;
            else if (target > nums[i]) l = i + 1;
            else r = i - 1;
        }
        return l;
    }
}