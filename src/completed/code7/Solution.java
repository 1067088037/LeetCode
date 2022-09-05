package completed.code7;

class Solution {
    public int reverse(int x) {
        boolean positive = x >= 0;
        String s = String.valueOf(Math.abs((long) x));
        String s1 = new StringBuffer(s).reverse().toString();
        long ret = Long.parseLong(s1);
        long res = positive ? ret : -ret;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
        else return (int) res;
    }
}