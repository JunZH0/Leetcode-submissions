class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numsSet =  new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            if (!numsSet.contains(nums[i])) {
                numsSet.add(nums[i]);
            } else {
                return true;
            }
        }

        return false;
    }
}