class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        int l = 0, res = 0;
        int maxFreq = 0;

        for (int r = 0; r < s.length(); r++) {
            char curr = s.charAt(r);
            count.put(curr, count.getOrDefault(curr, 0) + 1);

            maxFreq = Math.max(maxFreq, count.get(curr));

            while (r - l + 1 - maxFreq > k) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
            } 

            res = Math.max(res, r - l + 1);
            
        }
        return res;
    }
}
