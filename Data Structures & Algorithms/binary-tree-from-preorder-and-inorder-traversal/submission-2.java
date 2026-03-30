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

        int val = preorder[preIdx++];
        TreeNode root = new TreeNode(val);
        int preIdx = map.get(val);

        root.left = build(preorder, map, left, preIdx - 1);
        root.right = build(preorder, map, preIdx + 1, right);

        return root;
    }
}
