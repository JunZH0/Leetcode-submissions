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

        return dfs(0, preorder.length - 1, preorder, inMap);
    }

    private TreeNode dfs(int left, int right, int[] preorder, Map<Integer, Integer> inMap) {
        if (left > right) {
            return null;
        }

        int rootVal = preorder[preIdx++];
        TreeNode root = new TreeNode(rootVal);
        int mid = inMap.get(rootVal);
        root.left = dfs(left, mid - 1, preorder, inMap);
        root.right = dfs(mid + 1, right, preorder, inMap);
        return root;
    }
}
