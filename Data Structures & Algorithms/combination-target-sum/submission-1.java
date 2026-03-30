class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, new ArrayList<>(), nums, 0, target);
        return res;
    }

    private void dfs(int i, List<Integer> cur ,int[] nums, int total, int target) {
        if (total == target) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            if (total + nums[j] > target) {
                return;
            }

            cur.add(nums[j]);
            dfs(j, cur, nums, total + nums[j], target);
            cur.remove(cur.size() - 1);
        }
    }
}
