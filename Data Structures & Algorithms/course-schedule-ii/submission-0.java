class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int preReq = pre[1];
            int course = pre[0];

            adj.get(course).add(preReq);
            inDegree[preReq]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        int completed = 0;
        int[] output = new int[numCourses];
        while (!q.isEmpty()) {
            int curr = q.poll();

            output[numCourses - completed - 1] = curr;
            completed++;
            for (int nei : adj.get(curr)) {
                inDegree[nei]--;
                if (inDegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        return completed != numCourses ? new int[0] : output;


    }
}
