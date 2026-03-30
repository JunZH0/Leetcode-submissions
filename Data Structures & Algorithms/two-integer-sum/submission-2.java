class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> complements = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int difference = target - nums[i];

            if (!complements.containsKey(difference)) {
                complements.put(nums[i],i);
            } else {
                return new int[] {complements.get(difference), i};
            }
        }
        return new int[] {};
    }
}
