class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        
        int prev1 = 0;
        int prev2 = 0;


        for (int i = 2; i <= n; i++) {
            int tmp = prev1;
            prev1 = Math.min(prev1 + cost[i - 1], prev2 + cost[i - 2]);
            prev2 = tmp;
        }

        return prev1;
    }
}
