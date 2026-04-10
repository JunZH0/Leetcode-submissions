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

    private int res;

    public int maxPathSum(TreeNode root) {
        res = root.val;
        dfs(root);
        return res;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }


        int lMax = Math.max(dfs(node.left), 0);
        int rMax = Math.max(dfs(node.right), 0);
        res = Math.max(res, node.val + lMax + rMax);

        return Math.max(lMax, rMax) + node.val;
    }
}
