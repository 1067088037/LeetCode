package completed.code6181;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int abacaba = solution.longestContinuousSubstring("vehvabfogsfxuyyri");
        System.out.println(abacaba);
    }

    public int longestContinuousSubstring(String s) {
        if (s.length() == 1) return 1;
        int left = 0, len;
        char[] chars = s.toCharArray();
        int n = chars.length;

        int max = 1;
        for (; left < n; left++) {
            len = 1;
            while (true) {
                int right = left + len;
                if (right > n - 1) break;
                if (chars[right] - chars[right - 1] == 1) {
                    len++;
                } else break;
            }
            left += (len - 1);
            max = Math.max(max, len);
        }
        return max;
    }
}