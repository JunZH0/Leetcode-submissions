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

    private int preIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return dfs(0, preorder.length - 1, preorder, inMap);
    }

    private TreeNode dfs(int left, int right, int[] preorder, Map<Integer, Integer> inMap) {
        if (left > right) {
            return null;
        }

        int val = preorder[preIdx++];
        TreeNode node = new TreeNode(val);
        int mid = inMap.get(val);

        node.left = dfs(left, mid - 1, preorder, inMap);
        node.right = dfs(mid + 1, right, preorder, inMap);

        return node;
    }

}
