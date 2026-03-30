class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> compl = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (!compl.containsKey(diff)) {
                compl.put(nums[i], i);
            } else {
                return new int[]{compl.get(diff), i};
            }
        }
        return new int[0];
    }
}
