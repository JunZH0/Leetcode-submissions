class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length -1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        int pivot = l;

        int res = binarySearch(0, pivot - 1, nums, target);

        if (res != -1) {
            return res;
        }

        return binarySearch(pivot, nums.length - 1, nums, target);
    }

    private int binarySearch(int l, int r, int[] nums, int target) {
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
