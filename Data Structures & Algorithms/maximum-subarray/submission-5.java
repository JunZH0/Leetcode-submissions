class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0], cur = 0;

        for (int n : nums) {
            if (cur < 0) {
                cur = 0;
            }

            cur += n;
            max = Math.max(max, cur);
        }
        return max;
    }
}
