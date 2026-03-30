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
    private int maxDia;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDia = 0;
        dfs(root);
        return maxDia;
    }

    private int dfs(TreeNode node)  {
        if (node == null) {
            return 0;
        }

        int lMax = dfs(node.left);
        int rMax = dfs(node.right);

        maxDia = Math.max(maxDia, (lMax + rMax));

        return Math.max(lMax, rMax) + 1;

    }
}
