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

public class Codec {

    private int idx;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        serializeDfs(root, sb);

        return sb.toString();
    }

    private void serializeDfs(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("N,");
            return;
        }

        sb.append(node.val).append(',');
        serializeDfs(node.left, sb);
        serializeDfs(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        idx = 0;

        String[] strs = data.split(",");

        return deserializeDfs(strs);
    }

    private TreeNode deserializeDfs(String[] data) {
        if (data[idx].equals("N")) {
            idx++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(data[idx]));
        idx++;
        node.left = deserializeDfs(data);
        node.right = deserializeDfs(data);

        return node;
    }
}
