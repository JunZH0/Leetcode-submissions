class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return -1;
        }

        int res = 0;
        int l = 0, r = height.length - 1;
        int lMax = height[l], rMax = height[r];

        while (l < r) {
            if (lMax <= rMax) {
                l++;
                lMax = Math.max(lMax, height[l]);
                res += lMax - height[l];
            } else {
                r--;
                rMax = Math.max(rMax, height[r]);
                res += rMax - height[r];
            }
        }
        return res;
    }
}
