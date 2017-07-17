public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1 == null ? 0 : nums1.length;
        int l2 = nums2 == null ? 0 : nums2.length;
        if (l1 + l2 == 0) {
            return 0;
        } else if ((l1 + l2) % 2 == 1) {
            return findKthNumber(nums1, 0, l1, nums2, 0, l2, (l1 + l2) / 2 + 1);
        } else {
            return (findKthNumber(nums1, 0, l1, nums2, 0, l2, (l1 + l2) / 2) + findKthNumber(nums1, 0, l1, nums2, 0, l2, (l1 + l2) / 2 + 1) ) / 2.0;
        }
    }

    private int findKthNumber(int[] nums1, int b1, int e1, int[] nums2, int b2, int e2, int k) {
        if (e2 - b2 < e1 - b1) {
            return findKthNumber(nums2, b2, e2, nums1, b1, e1, k);
        }
        if (b1 == e1) {
            return nums2[b2 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[b1], nums2[b2]);
        }
        int n1 = Math.min(k / 2, e1 - b1);
        int n2 = k - n1;
        if (nums1[b1 + n1 - 1] < nums2[b2 + n2 - 1]) {
            return findKthNumber(nums1, b1 + n1, e1, nums2, b2, b2 + n2, k - n1);
        } else if (nums2[b2 + n2 - 1] < nums1[b1 + n1 - 1]) {
            return findKthNumber(nums1, b1, b1 + n1, nums2, b2 + n2, e2, k - n2);
        } else {
            return nums1[b1 + n1 - 1];
        }
    }
}
