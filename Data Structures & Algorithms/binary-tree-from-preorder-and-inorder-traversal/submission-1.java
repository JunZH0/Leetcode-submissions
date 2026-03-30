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
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, map, 0, preorder.length - 1);
    }

    private TreeNode build(int[] preorder, Map<Integer, Integer> map, int left, int right) {
        if (left > right) {
            return null;
        }

        int rootVal = preorder[preIdx++];
        TreeNode node = new TreeNode(rootVal);

        int inIdx = map.get(rootVal);

        node.left = build(preorder, map, left, inIdx - 1);
        node.right = build(preorder, map, inIdx + 1, right);

        return node;

    }
}
