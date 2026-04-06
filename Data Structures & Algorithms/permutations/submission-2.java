class Solution {

    private List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();

        backtrack(new boolean[nums.length] ,new ArrayList<>(), nums);

        return res;
    }

    private void backtrack(boolean[] pick, List<Integer> cur, int[] nums) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            if (!pick[j]) {
                cur.add(nums[j]);
                pick[j] = true;
                backtrack(pick, cur, nums);
                cur.remove(cur.size() - 1);
                pick[j] = false;
            }
        }
    }
}
