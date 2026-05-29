class Solution {
    public int climbStairs(int n) {
        int s1 = 1, s2 = 1;

        for (int i = 0; i < n - 1; i++) {
            int tmp = s1;
            s1 = s1 + s2;
            s2 = tmp;
        }

        return s1; 
    }
}
