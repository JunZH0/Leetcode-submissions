class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;

        int[] res = new int[len1 + len2];

        System.arraycopy(nums1, 0, res, 0, len1);
        System.arraycopy(nums2, 0, res, len1, len2);

        Arrays.sort(res);

        int rLen = res.length;

        if (rLen % 2 == 0) {
            return ((res[rLen / 2 - 1] + res[rLen / 2]) / 2.0);
        }

        return res[rLen / 2];
    }
}
