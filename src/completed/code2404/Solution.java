package completed.code2404;

import java.util.HashMap;

class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxNum = -1;
        int maxCnt = 0;
        for (int num : nums) {
            if (num % 2 == 1) continue;
            if (map.containsKey(num)) {
                Integer integer = map.get(num);
                map.put(num, integer + 1);
            } else {
                map.put(num, 1);
            }
            Integer integer = map.get(num);
            if (maxCnt < integer) {
                maxCnt = integer;
                maxNum = num;
            } else if (maxCnt == integer) {
                maxNum = Math.min(maxNum, num);
            }
        }
        return maxNum;
    }
}