package completed.code15;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.threeSum(new int[]{0, 0, 0});
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3)
            return new ArrayList<>();
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[nums.length - 1] < 0) return new ArrayList<>();

        int n = nums.length;
        List<List<Integer>> ans = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) return ans;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = n - 1;
            int curr = nums[i];
            while (left < right) {
                int temp = curr + nums[left] + nums[right];
                if (temp == 0) {
                    List<Integer> i1 = List.of(curr, nums[left], nums[right]);
                    ans.add(i1);
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    left++;
                    right--;
                } else if (temp > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return ans;
    }
}