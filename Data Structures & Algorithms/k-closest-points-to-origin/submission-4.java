class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> 
                            Integer.compare(b[0] * b[0] + b[1] * b[1],
                                            a[0] * a[0] + a[1] * a[1])
        );

        for (int[] point : points) {
            minHeap.offer(point);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[][] res = new int[k][2];
        int index = 0;
        while (!minHeap.isEmpty()) {
            res[index++] = minHeap.poll();
        }
        return res;
    }
}
