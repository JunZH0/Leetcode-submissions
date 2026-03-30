class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;

        for (int num : nums) {
            set.add(num);
        }

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int length = 1;
                while (!set.isEmpty() && set.contains(nums[i] + length)) {
                    length++;
                }

                res = Math.max(res, length);
            } 
        }
        return res;
    }
}
