package completed.code242;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] letter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letter[s.charAt(i) - 'a']++;
            letter[t.charAt(i) - 'a']--;
        }
        for (int i : letter) {
            if (i != 0) return false;
        }
        return true;
    }
}