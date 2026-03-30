class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1, max = Arrays.stream(piles).max().getAsInt();
        int res = max;

        while (min <= max) {
            int k = min + (max - min) / 2;

            int total = 0;
            for (int pile : piles) {
                total += Math.ceil((double)pile / k);
            }
            
            if (total <= h) {
                res = k;
                max = k - 1;
            } else {
                min = k + 1;
            }            
        }
        return res;
    }
}
