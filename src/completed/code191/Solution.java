package completed.code191;

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int m = n >>> i;
            if ((m & 0x1) == 1) count++;
        }
        return count;
    }
}