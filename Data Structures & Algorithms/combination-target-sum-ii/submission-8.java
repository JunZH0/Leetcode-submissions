class Solution {

    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, 0, new ArrayList<>(), candidates, target);

        return res;
    }

    private void dfs(int i, int total, List<Integer> cur, int[] cand, int target) {
        if (total == target) {
            res.add(new ArrayList<>(cur));
            return;
        }

        if (i >= cand.length || total > target) {
            return;
        }

        cur.add(cand[i]);
        dfs(i + 1, total + cand[i], cur, cand, target);
        cur.remove(cur.size() - 1);

        while (i + 1 < cand.length && cand[i] == cand[i + 1]) {
            i++;
        }

        dfs(i + 1, total, cur, cand, target);
    }
}
