package completed.code383;

import java.util.Arrays;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] have = new int[26];
        Arrays.fill(have, 0);

        for (int i = 0; i < magazine.length(); i++) {
            have[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';
            if (have[index] <= 0) return false;
            have[index]--;
        }

        return true;
    }
}