package completed.code9;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n >> 1; i++) {
            if (chars[i] != chars[n - i - 1]) return false;
        }
        return true;
    }
}