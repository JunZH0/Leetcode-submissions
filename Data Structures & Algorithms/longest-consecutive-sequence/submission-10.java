class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;

        for (int n : nums) {
            set.add(n);
        }

        for (int num : nums) {
            int length = 1;

            if (!set.contains(num - 1)) {
                while (set.contains(num + length)) {
                    length++;
                }
            } 
            res = Math.max(res, length);
        }
        return res;
    }
}
