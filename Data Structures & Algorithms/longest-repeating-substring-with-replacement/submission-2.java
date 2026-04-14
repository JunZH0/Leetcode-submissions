class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0, l = 0;
        Map<Character, Integer> count = new HashMap<>();
        int maxFreq = 0;
        for (int r = 0; r < s.length(); r++) {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            maxFreq = Math.max(maxFreq, count.get(s.charAt(r)));

            while (r - l + 1 - maxFreq > k) {
                count.put(s.charAt(l), count.getOrDefault(s.charAt(l), 0) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
