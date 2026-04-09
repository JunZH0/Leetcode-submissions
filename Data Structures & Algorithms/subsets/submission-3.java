class Solution {

    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();

        dfs(0, new ArrayList<>(), nums);

        return res;
    }

    private void dfs(int i, List<Integer> cur, int[] nums) {
        if (i == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[i]);
        dfs(i + 1, cur, nums);
        cur.remove(cur.size() - 1);
        dfs(i + 1, cur, nums);
    }
}
