class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;

        for (int n : nums) {
            set.add(n);
        }

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int totalLength = 1;

                while (set.contains(num + totalLength)) {
                    totalLength++;
                }

                res = Math.max(res, totalLength);
            }
        }
        return res;
    }
}
