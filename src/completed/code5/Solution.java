package completed.code5;

class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;

        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
        }

        int max = 1;
        String maxStr = "" + s.charAt(0);

        for (int len = 2; len <= s.length(); len++) {
            for (int left = 0; left < s.length(); left++) {
                int right = left + len - 1;
                if (right >= s.length()) continue;

                if (s.charAt(left) != s.charAt(right)) {
                    dp[left][right] = false;
                } else {
                    if (len == 2) dp[left][right] = true;
                    else dp[left][right] = dp[left + 1][right - 1];
                }

                if (dp[left][right] && len > max) {
                    max = len;
                    maxStr = s.substring(left, right + 1);
                }
            }
        }

        return maxStr;
    }
}