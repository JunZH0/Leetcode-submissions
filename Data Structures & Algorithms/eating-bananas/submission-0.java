class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0;
        for (int pile : piles) {
            r = Math.max(r, pile);
        }

        while (l < r) {
            int mid = l + ((r - l) / 2);

            if (canFinish(piles, mid, h)) {
                r = mid;
            } else {
                l = mid + 1;
            } 
        }
        return l;
    }

    private boolean canFinish(int[] piles, int k, int h) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k;
            if (hours > h) return false;
        }
        return hours <= h;
    }
}
