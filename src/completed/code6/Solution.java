package completed.code6;

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        char[] ret = new char[s.length()];
        int pos = 0;
        final int step = numRows * 2 - 2;

        for (int i = 0; i < numRows; i++) {
            int index = i;
            if (i == 0 || i == numRows - 1) {
                while (index < s.length()) {
                    if (pos >= s.length()) break;
                    ret[pos] = (s.charAt(index));
                    index += step;
                    pos++;
                }
            } else {
                while (index < s.length()) {
                    ret[pos] = (s.charAt(index));
                    pos++;
                    if (pos >= s.length()) break;
                    int next = step - 2 * i + index;
                    if (next >= s.length()) break;
                    ret[pos] = (s.charAt(next));
                    pos++;
                    if (pos >= s.length()) break;
                    index += step;
                }
            }
        }

        return new String(ret);
    }
}