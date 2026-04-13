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

    private int preIdx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIdx = 0;
        Map<Integer, Integer> inMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        TreeNode root = new TreeNode(preorder[0]);
        return dfs(0, preorder.length - 1, inMap, preorder);
    }

    private TreeNode dfs(int left, int right, Map<Integer, Integer> inMap, int[] preorder) {
        if (left > right) {
            return null;
        }

        int val = preorder[preIdx++];
        TreeNode node = new TreeNode(val);
        int mid = inMap.get(val);

        node.left = dfs(left, mid - 1, inMap, preorder);
        node.right = dfs(mid + 1, right, inMap, preorder);

        return node;
    }
}
