package completed.code278;

class VersionControl {
    boolean isBadVersion(int version) {
        return version >= 4;
    }
}

class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while (l < r) {
            int i = l + (r - l) / 2;
            if (isBadVersion(i)) r = i;
            else l = i + 1;
        }
        return l;
    }
}