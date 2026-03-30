/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res, k);

        return res.get(k - 1);
    }

    private void dfs(TreeNode root, List<Integer> res, int k) {
        if (root == null) {
            return;
        }

        dfs(root.left, res, k);
        res.add(root.val);
        dfs(root.right, res , k);

    }
    
}
