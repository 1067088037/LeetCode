package completed.code387;

import java.util.Arrays;

class Solution {

    public final int NotFound = Integer.MAX_VALUE;
    public final int Repeat = Integer.MAX_VALUE - 1;

    public int firstUniqChar(String s) {
        int[] rec = new int[26];
        Arrays.fill(rec, NotFound);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            switch (rec[index]) {
                case NotFound:
                    rec[index] = i;
                    break;
                case Repeat:
                    break;
                default:
                    rec[index] = Repeat;
                    break;
            }
        }

        Arrays.sort(rec);
        int value = rec[0];
        if (value >= Repeat) return -1;
        else return value;
    }
}