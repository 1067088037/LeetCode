package completed.code844;

import java.util.Objects;

class Solution {
    public boolean backspaceCompare(String s, String t) {
        s = process(s);
        t = process(t);
        return Objects.equals(s, t);
    }

    private String process(String src) {
        StringBuilder s = new StringBuilder(src);
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == '#') {
                s.deleteCharAt(i);
                s.deleteCharAt(i - 1);
                i -= 2;
            }
        }
        return s.toString().replace("#", "");
    }
}