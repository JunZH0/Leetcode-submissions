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
        dfs(res, root);
        return res.get(k - 1);
    }

    private void dfs(List<Integer> res, TreeNode node) {
        if (node == null) {
            return;
        }

        dfs(res, node.left);
        res.add(node.val);
        dfs(res, node.right);
    }
}
