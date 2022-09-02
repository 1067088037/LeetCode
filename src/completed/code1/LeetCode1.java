package completed.code1;

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3, 2, 4};
        int[] ints = solution.twoSum(nums, 6);
        System.out.println(Arrays.toString(ints));
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (map.get(nums[i]) == i) continue;
                return new int[]{map.get(nums[i]), i};
            } else map.put(target - nums[i], i);
        }
        return null;
    }
}