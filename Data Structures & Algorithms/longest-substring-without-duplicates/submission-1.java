class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        int l = 0;
        int res = 0;

        for (int r = 0; r < s.length(); r++) {
            if (charMap.containsKey(s.charAt(r))) {
                l = Math.max(charMap.get(s.charAt(r)) + 1, l);
            }

            charMap.put(s.charAt(r), r);
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
