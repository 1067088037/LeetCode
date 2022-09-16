package completed.code34;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.searchRange(new int[]{2, 2}, 2);
        System.out.println(ints[0] + "\t" + ints[1]);
    }

    private final int[] nullTarget = new int[]{-1, -1};

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return nullTarget;
        if (nums.length == 1) return nums[0] == target ? new int[]{0, 0} : nullTarget;

        int left = findIndex(nums, target, true);
        int right = findIndex(nums, target, false);

        if (left >= 0 && right < nums.length && left <= right) {
            return new int[]{left, right};
        } else {
            return nullTarget;
        }
    }

    private int findIndex(int[] nums, int target, boolean first) {
        int left = 0, right = nums.length - 1;
        int res = -1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                res = mid;
                if (first) right = mid;
                else left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (first && nums[left] != target) return -1;
        if (!first && nums[left] != target) return left - 1;
        return left;
    }
}