class Solution {

    private List<List<Integer>> res;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, new ArrayList<>(), nums);

        return res;
    }

    private void dfs(int i, List<Integer> cur, int[] nums) {
        if (i == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        int curVal = nums[i];
        cur.add(curVal);
        dfs(i + 1, cur, nums);
        cur.remove(cur.size() - 1);

        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }

        dfs(i + 1, cur, nums);
    }
}
