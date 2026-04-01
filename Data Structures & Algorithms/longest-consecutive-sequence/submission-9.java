class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;

        for (int n : nums) {
            set.add(n);
        }

        for (int i = 0; i < nums.length; i++) {
            int maxLength = 1;
            if (!set.contains(nums[i] - 1)) {
                while (set.contains(nums[i] + maxLength)) {
                    maxLength++;
                }
            }
            res = Math.max(res, maxLength);
        }
        return res;
    }
}
