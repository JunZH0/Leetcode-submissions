class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String currS = strs[i];

            int[] count = new int[26];
            for (char c : currS.toCharArray()) {
                count[c - 'a']++;
            }

            String key = Arrays.toString(count);

            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(currS);
        }
        return new ArrayList<>(res.values());
    }
}
