package completed.code6180;

class Solution {
    public int smallestEvenMultiple(int n) {
        if (n % 2 == 0) return n;
        else return n << 1;
    }
}