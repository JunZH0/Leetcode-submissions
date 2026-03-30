class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();    
        int res = 0;

        int start = 0, maxFreq = 0;

        for (int end = 0; end < s.length(); end++) {
            count.put(s.charAt(end), count.getOrDefault(s.charAt(end), 0) + 1);
            maxFreq = Math.max(maxFreq, count.get(s.charAt(end)));

            while ((end - start + 1) - maxFreq > k) {
                count.put(s.charAt(start), count.getOrDefault(s.charAt(start), 0) - 1);
                start++;
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }
}
