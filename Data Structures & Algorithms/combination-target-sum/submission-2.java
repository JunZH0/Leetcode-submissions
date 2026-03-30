class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, 0, new ArrayList<>(), nums, target);
        return res;
    }

    private void dfs(int i, int total, List<Integer> combs, int[] nums, int target) {
        if (total == target) {
            res.add(new ArrayList<>(combs));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            if (total + nums[j] > target) {
                return;
            }

            combs.add(nums[j]);
            dfs(j, nums[j] + total, combs, nums, target);
            combs.remove(combs.size() - 1);
        }
    }
}
