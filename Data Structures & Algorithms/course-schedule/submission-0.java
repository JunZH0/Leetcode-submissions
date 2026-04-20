class Solution {


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(); 

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            adj.get(prereq).add(course);
            inDegree[course]++;
        }   

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        int completedCourses = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            completedCourses++;

            for (int dependent : adj.get(curr)) {
                inDegree[dependent]--;

                if (inDegree[dependent] == 0) {
                    q.offer(dependent);
                }
            }
        }

        return completedCourses == numCourses;
    }
}
