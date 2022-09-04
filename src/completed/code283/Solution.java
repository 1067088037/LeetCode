package completed.code283;

class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
    }
}

class SolutionA {
    public void moveZeroes(int[] nums) {
        int right = nums.length - 1;
        for (int left = nums.length - 1; left >= 0; left--) {
            if (nums[left] == 0) {
                for (int i = left; i < right; i++) {
                    nums[i] = nums[i + 1];
                }
                nums[right] = 0;
                right--;
            }
        }
    }
}
