class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int[] mergedArr = new int[len1 + len2];
        System.arraycopy(nums1, 0, mergedArr, 0, len1);
        System.arraycopy(nums2, 0, mergedArr, len1, len2);
        Arrays.sort(mergedArr);

        int totalLen = mergedArr.length;
        if (totalLen % 2 == 0) {
            return (mergedArr[totalLen / 2 - 1] + mergedArr[totalLen /
            2]) / 2.0;
        } else {
            return mergedArr[totalLen / 2];
        }
    }
}
