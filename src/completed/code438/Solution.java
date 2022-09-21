package completed.code438;

import java.util.LinkedList;
import java.util.List;

class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) return new LinkedList<>();
        int[] arrP = new int[26];
        for (char c : p.toCharArray()) {
            arrP[c - 'a']++;
        }
        List<Integer> ans = new LinkedList<>();
        int n = s.length();
        for (int i = 0; i < p.length(); i++) {
            arrP[s.charAt(i) - 'a']--;
        }

        for (int i = 0; i < n - p.length() + 1; i++) {
            if (i != 0) arrP[s.charAt(i + p.length() - 1) - 'a']--;
            if (check(arrP)) {
                ans.add(i);
            }
            arrP[s.charAt(i) - 'a']++;
        }

        return ans;
    }

    private boolean check(int[] arr) {
        for (int i : arr) {
            if (i != 0) return false;
        }
        return true;
    }
}
