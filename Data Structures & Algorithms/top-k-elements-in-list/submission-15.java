class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        List<Integer>[] count = new List[nums.length + 1];

        for (int i = 0; i < count.length; i++) {
            count[i] = new ArrayList<>();
        } 

        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            count[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int i = 0;
        for (int j = count.length - 1; j >= 0 && i < k; j--) {
            for (int val : count[j]) {
                res[i++] = val;

                if (i == k) {
                    return res;
                }
            }
        }

        return res;

    }
}
