class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> seen = new HashMap<>();
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char currCh = s.charAt(end);
            seen.put(currCh, seen.getOrDefault(currCh, 0) + 1);

            while (seen.get(currCh) > 1) {
                char startCh = s.charAt(start);
                seen.put(startCh, seen.get(startCh) - 1);
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
