package completed.code704;

public class LeetCode704 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (nums.length == 1)
            return nums[0] == target ? 0 : -1;
        while (right >= left) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
}
