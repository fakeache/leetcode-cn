package Hard;

public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int len = len1 + len2;
        if (len % 2 == 1) {
            return getKthElement(nums1, nums2, len / 2 + 1);
        } else {
            return (getKthElement(nums1, nums2, len / 2) +
                    getKthElement(nums1, nums2, len / 2 + 1)) / 2.0;
        }
    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        int index1 = 0, index2 = 0;
        while (true) {
            if (index1 == len1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == len2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            int i = Math.min(index1 + k / 2, len1) - 1;
            int j = Math.min(index2 + k / 2, len2) - 1;
            if (nums1[i] >= nums2[j]) {
                k -= j + 1 - index2;
                index2 = j + 1;
            } else {
                k -= i + 1 - index1;
                index1 = i + 1;
            }
        }
    }
}
