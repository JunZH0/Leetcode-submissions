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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            List<Integer> cur = new ArrayList<>();
            int size = q.size();
            for (int i = size; i > 0; i--) {
                TreeNode node = q.poll();

                if (node != null) {
                    cur.add(node.val);
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }

            if (cur.size() > 0) {
                res.add(cur);
            }
        }
        return res;
    }
}
