package completed.code33;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int search = solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        System.out.println(search);
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;

        int n = nums.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = nums[mid];
            if (target == val) return mid;
            if (nums[left] <= val) {
                // 前一半有序
                if (target >= nums[left] && target < val) {
                    // 前一半中找
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 后一半有序
                if (target > val && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

}