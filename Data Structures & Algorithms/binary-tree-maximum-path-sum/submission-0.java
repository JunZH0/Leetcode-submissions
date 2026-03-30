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
    private int max;
    public int maxPathSum(TreeNode root) {
        max = root.val;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lMax = Math.max(dfs(root.left), 0);
        int rMax = Math.max(dfs(root.right), 0);

        max = Math.max(max, root.val + lMax + rMax);
        return root.val + Math.max(lMax, rMax);
    }
}
