package completed.code190;

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int m = n >>> i;
            if ((m & 0x1) == 1) res |= 0x1;
            if (i != 31) res <<= 1;
        }
        return res;
    }
}