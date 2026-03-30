class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);

        dfs(0, 0, new ArrayList<>(), candidates , target);
        return res;
    }

    private void dfs(int i, int total, List<Integer> cur, int[] candidates, int target) {
        if (total == target) {
            res.add(new ArrayList<>(cur));
            return;
        }

        if (i == candidates.length || total > target) {
            return;
        }

        cur.add(candidates[i]);
        dfs(i + 1, total + candidates[i], cur, candidates, target);
        cur.remove(cur.size() - 1);

        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }

        dfs(i + 1, total, cur, candidates, target);
     }
}
