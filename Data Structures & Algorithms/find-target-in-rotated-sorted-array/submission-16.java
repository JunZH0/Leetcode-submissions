class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int m = l + (r - l) / 2;

            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        int pivot = l;
        int res = binarySearch(0, l - 1, nums, target);

        if (res != -1) {
            return res;
        }

        return binarySearch(l , nums.length - 1, nums, target);
    }

    private int binarySearch(int l, int r, int[] nums, int target) {
        while (l <= r) {
            int m = l + (r - l) / 2;

            if (nums[m] > target) {
                r = m - 1;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }
}
