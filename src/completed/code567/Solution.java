package completed.code567;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkInclusion("ab", "eidbaooo"));
    }

    int[] count1 = new int[26];
    int[] count2 = new int[26];

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        int n = s1.length();
        if (Arrays.equals(count1, count2)) return true;
        for (int start = 0; start < s2.length(); start++) {
            int end = start + n;
            if (end >= s2.length()) break;
            count2[s2.charAt(start) - 'a']--;
            count2[s2.charAt(end) - 'a']++;
            char c = s2.charAt(start);
            if (Arrays.equals(count1, count2)) return true;
        }

        return false;
    }
}