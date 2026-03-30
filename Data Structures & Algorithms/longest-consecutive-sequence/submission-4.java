class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            set.add(n);
        }

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int length = 1;
                while (set.contains(nums[i] + length)) {
                    length++;
                }

                res = Math.max(res, length);
            }
        }
        return res;
    }
}
