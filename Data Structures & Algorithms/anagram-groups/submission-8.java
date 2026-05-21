class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for (String st : strs) {
            int[] count = new int[26];

            for (int i = 0; i < st.length(); i++) {
                count[st.charAt(i) - 'a']++;
            }

            String key = Arrays.toString(count);
            res.computeIfAbsent(key, k -> new ArrayList<>()).add(st);
        }

        return new ArrayList<>(res.values());
    }
}
