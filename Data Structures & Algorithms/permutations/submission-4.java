class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] state = new boolean[nums.length];

        dfs(new ArrayList<>(), state, nums, res);

        return res;    
    }

    private void dfs(List<Integer> curr, boolean[] state, int[] nums, List<List<Integer>> res) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (state[i]) continue;
            state[i] = true;
            curr.add(nums[i]);
            dfs(curr, state, nums, res);
            curr.remove(curr.size() - 1);
            state[i] = false;
        }
    }
}
