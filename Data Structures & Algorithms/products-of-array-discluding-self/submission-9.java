class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        res[0] = 1;
        for (int i = 1; i < res.length; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }

        int pos = 1;
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] *= pos;
            pos *= nums[i];
        }

        return res;
    }
}  
