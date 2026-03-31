class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) { 
        int len1 = nums1.length;
        int len2 = nums2.length;

        int[] res = new int[len1 + len2];

        System.arraycopy(nums1, 0, res, 0, len1);
        System.arraycopy(nums2, 0, res, len1, len2);

        Arrays.sort(res);

        int len = res.length;

        if (len % 2 == 0) {
            return (res[len / 2 - 1] + res[len / 2]) / 2.0;
        }

        return res[len / 2];
    }
}
