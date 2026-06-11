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
        Map<Integer, Integer> inMap = new HashMap<>();
        preIdx = 0;
        
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return dfs(preorder, inMap, 0, preorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, Map<Integer, Integer> inMap, int left, int right) {
        if (left > right) {
            return null;
        }

        int val = preorder[preIdx++];
        TreeNode node = new TreeNode(val);
        int mid = inMap.get(val);

        node.left = dfs(preorder, inMap, left, mid - 1);
        node.right = dfs(preorder, inMap, mid + 1, right);

        return node;
    }
}
