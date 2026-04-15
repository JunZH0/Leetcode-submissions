class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];

        for (char task : tasks) {
            count[task - 'A']++;
        }

        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int val : count) {
            if (val > 0) {
                maxHeap.offer(val);
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        int time = 0;

        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;
            if (maxHeap.isEmpty()) {
                time = q.peek()[1];
            } else {
                int cnt = maxHeap.poll();

                if (cnt > 1) {
                    q.offer(new int[]{cnt - 1, time + n});
                }
            }

            if (!q.isEmpty() && q.peek()[1] == time) {
                maxHeap.offer(q.poll()[0]);
            }
        }

        return time;
    }
}
