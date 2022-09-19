package completed.code1636;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else map.put(num, 1);
        }
        ArrayList<int[]> list = new ArrayList<>();
        for (Integer integer : map.keySet()) {
            list.add(new int[]{integer, map.get(integer)});
        }
        list.sort((o1, o2) -> o1[1] != o2[1] ? (o1[1] - o2[1]) : (o2[0] - o1[0]));
        int[] ans = new int[nums.length];
        int idx = 0;
        for (int[] info : list) {
            while (info[1]-- > 0)
                ans[idx++] = info[0];
        }
        return ans;
    }
}