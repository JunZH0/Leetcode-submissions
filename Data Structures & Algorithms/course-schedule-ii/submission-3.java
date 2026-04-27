class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int preReq = pre[1];

            adj.get(preReq).add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        
        int[] res = new int[numCourses];
        int completed = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            res[completed++] = curr;

            for (int dependent : adj.get(curr)) {
                indegree[dependent]--;

                if (indegree[dependent] == 0) {
                    q.offer(dependent);
                }
            }
        }
        return completed == numCourses ? res : new int[0];
    }
}
