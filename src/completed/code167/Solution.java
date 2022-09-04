package completed.code167;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        for (; left < numbers.length - 1; left++) {
            for (; right > left; right--) {
                int sum = numbers[left] + numbers[right];
                if (sum == target) return new int[]{left + 1, right + 1};
                else if (sum < target) {
                    break;
                }
            }
        }
        return null;
    }
}