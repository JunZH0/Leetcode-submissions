class Solution {
    public int trap(int[] height) {
        if (height == null) {
            return -1;
        }

        int l = 0, r = height.length - 1;
        int lMax = height[l], rMax = height[r];
        int result = 0;

        while (l < r) {
            if (lMax <= rMax) {
                l++;
                lMax = Math.max(lMax, height[l]);
                result += lMax - height[l];
            } else {
                r--;
                rMax = Math.max(rMax, height[r]);
                result += rMax - height[r];
            }
        }
        return result;
    }
}
