class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;

        for (int n : nums) {
            set.add(n);
        }

        for (int i = 0; i < nums.length; i++) {
            int curMax = 1;
            int length = 1;
            if (!set.contains(nums[i] - 1)) {
                while (set.contains(nums[i] + length)) {
                    length++;
                    curMax++;
                }
            }
            res = Math.max(res, curMax);
        }
        return res;
    }
}
