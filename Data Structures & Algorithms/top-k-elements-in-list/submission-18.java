class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        List<List<Integer>> count = new ArrayList<>();

        for (int i = 0; i <= nums.length; i++) {
            count.add(new ArrayList<>());
        }

        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            count.get(entry.getValue()).add(entry.getKey());
        }

        int[] res = new int[k];
        int i = 0;

        for (int j = count.size() - 1; j >= 0 && i < k; j--) {
            for (int val : count.get(j)) {
                res[i++] = val;

                if (i == k) {
                    return res;
                }
            }
        } 
        return res;
    }
}
