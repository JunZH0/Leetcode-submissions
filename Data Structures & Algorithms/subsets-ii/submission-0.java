class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(0, new ArrayList<>(), nums);

        return res;
    }

    private void backtracking(int i, List<Integer> subset, int[] nums) {
        if (i == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }      

        subset.add(nums[i]);
        backtracking(i + 1, subset, nums);
        subset.remove(subset.size() - 1);
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        backtracking(i + 1, subset, nums);
    }
}
