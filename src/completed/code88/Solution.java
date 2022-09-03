package completed.code88;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] clone1 = nums1.clone();
        int i, j = 0, k = 0;
        for (i = 0; i < m + n - 1; i++) {
            if (j == m || k == n) break;
            if (clone1[j] < nums2[k]) {
                nums1[i] = clone1[j];
                j++;
            } else {
                nums1[i] = nums2[k];
                k++;
            }
        }
        for (; j < m; j++) {
            nums1[i] = clone1[j];
            i++;
        }
        for (; k < n; k++) {
            nums1[i] = nums2[k];
            i++;
        }
    }
}
