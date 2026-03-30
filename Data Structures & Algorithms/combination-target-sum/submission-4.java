class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, 0, new ArrayList<>(), nums, target);
        return res;
    }

    private void dfs(int i, int total, List<Integer> cur, int[] nums, int target) {
        if (total == target) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            int curVal = nums[j];
            if (total + curVal > target) {
                return;
            }

            cur.add(curVal);
            dfs(j, total + curVal, cur, nums, target);
            cur.remove(cur.size() - 1);
        }
    }
}
