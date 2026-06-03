class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }

        List<Integer> res = new ArrayList<>();
        int size = 0, end = 0;
        int i = 0;
        for (char c : s.toCharArray()) {
            size++;
            end = Math.max(end, lastIndex.get(c));

            if (i == end) {
                res.add(size);
                size = 0;
            }
            i++;
        }

        return res;
    }
}
