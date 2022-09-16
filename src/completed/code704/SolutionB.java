package completed.code704;

import java.util.Arrays;

class SolutionB {
    public int search(int[] nums, int target) {
        int value = Arrays.binarySearch(nums, target);
        return value >= 0 ? value : -1;
    }
}