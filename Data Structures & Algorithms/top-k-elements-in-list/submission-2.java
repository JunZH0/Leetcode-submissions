class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Given a nums Array, return the k most frequent values
        HashMap<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];

        // create a list(bucket) for each index(frequency)
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        // cont each values frequency in the hashMap
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        // for each entry in the count map, based in its frequency, add it 
        // to the corresponding list(bucket) inside freq.
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        // initialize new array size k to store the result
        int[] result = new int[k];
        int index = 0;
        // Iterate from last element(most frequent) 
        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            // iterate each bucket till index == k
            for (int n : freq[i]) {
                result[index++] = n;
                if (index == k) {
                    return result;
                }
            }
        }
        return result;
    }
}
