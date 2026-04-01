class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int res = 0;

        while (l < r) {
            int height = Math.min(heights[l], heights[r]);
            int area = height * (r - l);

            res = Math.max(res, area);

            if (heights[l] <= heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
