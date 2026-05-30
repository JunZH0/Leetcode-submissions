class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];

        System.arraycopy(nums1, 0, merged, 0, nums1.length);
        System.arraycopy(nums2, 0, merged, nums1.length, nums2.length);

        Arrays.sort(merged);

        var mergedLen = merged.length;

        if (mergedLen % 2 == 0) {
            return (merged[mergedLen / 2] + merged[(mergedLen - 1) / 2]) / 2.0;
        } else {
            return merged[mergedLen / 2];
        }
    }
}
