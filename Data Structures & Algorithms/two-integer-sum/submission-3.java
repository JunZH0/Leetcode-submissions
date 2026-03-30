class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> complementMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (complementMap.containsKey(diff)) {
               return new int[]{complementMap.get(diff), i};
            } else {
                complementMap.put(nums[i], i);
            }

        }
        return new int[0];
    }
}
