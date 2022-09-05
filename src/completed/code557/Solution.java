package completed.code557;

class Solution {
    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        for (int i = 0; i < s1.length; i++) {
            s1[i] = new StringBuilder(s1[i]).reverse().toString();
        }
        StringBuilder res = new StringBuilder(s.length());
        for (String value : s1) {
            for (int j = 0; j < value.length(); j++) {
                res.append(value.charAt(j));
                if (res.length() == s.length()) return res.toString();
            }
            res.append(" ");
        }
        return res.toString();
    }
}