package completed.code3;

import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        int left, right = -1;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        for (left = 0; left < s.length(); left++) {
            while (right + 1 < s.length() && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                right++;
            }
            max = Math.max(max, right - left + 1);
            set.remove(s.charAt(left));
        }
        return max;
    }
}