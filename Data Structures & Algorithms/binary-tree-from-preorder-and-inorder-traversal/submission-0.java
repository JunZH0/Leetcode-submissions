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
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, map, 0, preorder.length - 1);
    }

    private TreeNode build(int[] preorder, Map<Integer,Integer> map, int left, int right) {
        if (left > right) {
            return null;
        }

        int rootValue = preorder[preIdx++];
        TreeNode root = new TreeNode(rootValue);

        int inIdx = map.get(rootValue);

        root.left = build(preorder, map, left, inIdx - 1);

        root.right = build(preorder, map, inIdx + 1, right);
        
        return root;
    }
}
