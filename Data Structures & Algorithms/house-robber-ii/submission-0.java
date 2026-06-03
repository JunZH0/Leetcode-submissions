class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        // Rob from house 0 to n - 2 (Excludes last house);
        int robFirstRange = robHelper(nums, 0, nums.length - 2);

        // Rob from house 1 to n - 1 (Excludes first house)
        int robSecondRange = robHelper(nums, 1, nums.length - 1);
        
        return Math.max(robFirstRange, robSecondRange);
    }

    private int robHelper(int[] nums, int start, int end) {
        int prev1 = 0;
        int prev2 = 0;

        for (int i = start; i <= end; i++) {
            int current = Math.max(prev2 + nums[i], prev1);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}
