class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        
        int n = nums.length;
        int firstSeg = robHelper(0, n - 1, nums);
        int secondSeg = robHelper(1, n, nums);

        return Math.max(firstSeg, secondSeg);
    }

    private int robHelper(int start, int end, int[] nums) {
        int prev1 = 0;
        int prev2 = 0;

        for (int i = start; i < end; i++) {
            int current = Math.max(prev2 + nums[i], prev1);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
