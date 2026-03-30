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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            Integer rightVal = null;

            for (int i = q.size(); i > 0; i--) {
                TreeNode node = q.poll();

                if (node != null) {
                    rightVal = node.val;
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }

            if (rightVal != null) {
                res.add(rightVal);
            }
        }
        return res;
    }
}
