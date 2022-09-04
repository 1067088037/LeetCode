package completed.code4;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int[] arr = new int[n];
        int index1 = 0, index2 = 0;
        boolean avg = n % 2 == 0;
        for (int i = 0; i < n / 2 + 2 && i < n; i++) {
            if (getArr(nums1, index1) < getArr(nums2, index2)) {
                arr[i] = nums1[index1];
                index1++;
            } else {
                arr[i] = nums2[index2];
                index2++;
            }
        }

        if (!avg) {
            return arr[n / 2];
        } else {
            return (0.0 + arr[n / 2] + arr[n / 2 - 1]) / 2;
        }
    }

    private int getArr(int[] arr, int index) {
        if (index >= 0 && index < arr.length) {
            return arr[index];
        } else {
            return Integer.MAX_VALUE;
        }
    }
}