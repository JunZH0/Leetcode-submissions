class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> compl = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (compl.containsKey(diff)) {
                return new int[]{compl.get(diff), i};
            } else {
                compl.put(nums[i], i);
            }
        }
        return new int[0];
    }
}
