class Solution {

    private List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        boolean[] pick = new boolean[nums.length];

        backtrack(new ArrayList<>(), pick ,nums);

        return res;
    }

    private void backtrack(List<Integer> cur, boolean[] pick ,int[] nums) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            if (!pick[j]) {
                pick[j] = true;
                cur.add(nums[j]);
                backtrack(cur, pick, nums);
                cur.remove(cur.size() - 1);
                pick[j] = false;
            }
        }
    }
}
