class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();

        dfs(0, new ArrayList<>(), nums);

        return res;
    }

    private void dfs(int i, List<Integer> subset, int[] nums) {
        if (i == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        dfs(i + 1, subset, nums);
        subset.remove(subset.size() - 1);
        dfs(i + 1, subset, nums);
    }
}
