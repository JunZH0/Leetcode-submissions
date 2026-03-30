class Solution {
    public int findMin(int[] nums) {
        int res = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
           if (nums[i] > nums[i + 1]) {
            res = nums[i + 1];
           }
        }

        return res;
    }
}
