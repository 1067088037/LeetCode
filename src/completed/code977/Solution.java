package completed.code977;

class Solution {
    public int[] sortedSquares(int[] nums) {
        if (nums.length == 0) return nums;
        else if (nums.length == 1) return new int[]{pow2(nums[0])};
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }

        int index = nums.length - 1;
        for (int left = 0, right = nums.length - 1; left <= right; ) {
            if (nums[left] <= nums[right]) {
                res[index] = pow2(nums[right]);
                right--;
            } else {
                res[index] = pow2(nums[left]);
                left++;
            }
            index--;
        }

        return res;
    }

    private int pow2(int num) {
        return num * num;
    }
}