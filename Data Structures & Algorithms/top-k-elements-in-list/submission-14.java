class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        List<Integer>[] count = new ArrayList[nums.length + 1];

        for (int i = 0; i < count.length; i++) {
            count[i] = new ArrayList<>();
        }

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            count[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;

        for (int i = count.length - 1; i >= 0 && index < k; i--) {
            for (int c : count[i]) {
                res[index++] = c;

                if (index == k) {
                    return res;
                }
            }
        }
        return res;
    }
}
