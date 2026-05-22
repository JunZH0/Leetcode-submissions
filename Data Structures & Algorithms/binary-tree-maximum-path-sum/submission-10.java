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

    public int maxPathSum(TreeNode root) {
        maxDia = root.val;

        maxPath(root);

        return maxDia;
    }

    private int maxPath(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int lMax = Math.max(maxPath(node.left), 0);
        int rMax = Math.max(maxPath(node.right), 0);

        maxDia = Math.max(maxDia, node.val + lMax + rMax);

        return Math.max(lMax, rMax) + node.val;
    }
}
