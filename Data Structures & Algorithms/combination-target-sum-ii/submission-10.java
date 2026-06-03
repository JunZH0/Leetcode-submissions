class Solution {

    List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();

        Arrays.sort(candidates);
        dfs(0, new ArrayList<>(), candidates, 0, target);

        return res;
    }

    private void dfs(int i, List<Integer> cur, int[] cand, int total, int target) {
        if (total == target) {
            res.add(new ArrayList<>(cur));
            return;
        }

        if (i >= cand.length || total > target) {
            return;
        }

        cur.add(cand[i]);
        dfs(i + 1, cur, cand, cand[i] + total, target);
        cur.remove(cur.size() - 1);

        while (i + 1 < cand.length && cand[i] == cand[i + 1]) {
            i++;
        }
        dfs(i + 1, cur, cand, total, target);
    }
}
