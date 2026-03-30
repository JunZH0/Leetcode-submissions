class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            if (!set.contains(n)) {
                set.add(n);
            } else {
                return true;
            }
        }
        return false;
    }
}