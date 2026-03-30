class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int maxP = 0;

        for (int r = 1; r < prices.length; r++) {
            if (prices[l] < prices[r]) {
                maxP = Math.max(maxP, prices[r] - prices[l]);
            } else {
                l = r;
            } 
        }
        return maxP;
    }
}
