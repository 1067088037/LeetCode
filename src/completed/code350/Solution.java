package completed.code350;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i : nums2) {
            if (map.containsKey(i)) {
                int val = map.get(i);
                if (val > 0) {
                    map.put(i, val - 1);
                    ret.add(i);
                }
            }
        }
        return ret.stream().mapToInt(Integer::intValue).toArray();
    }
}