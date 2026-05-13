class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        int[] rank = new int[edges.length + 1];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int[] edge : edges) {
            if (!union(edge[0], edge[1], parent, rank)) {
                return new int[]{edge[0], edge[1]};
            }
        }
        return new int[0];
    }

    private boolean union(int n1, int n2, int[] parent, int[] rank) {
        int p1 = find(n1, parent);
        int p2 = find(n2, parent);

        if (p1 == p2) {
            return false;
        }

        if (rank[p1] > rank[2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }

    private int find(int node, int[] parent) {
        int res = node;

        while (res != parent[res]) {
            parent[res] = parent[parent[res]];
            res = parent[res];
        }
        return res;
    }
}
