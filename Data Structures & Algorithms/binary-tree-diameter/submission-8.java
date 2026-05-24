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

    private int dia;

    public int diameterOfBinaryTree(TreeNode root) {
        dia = 0;

        dfs(root);

        return dia;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int lMax = dfs(node.left);
        int rMax = dfs(node.right);

        dia = Math.max(dia, lMax + rMax);

        return Math.max(lMax, rMax) + 1;
    }
}
