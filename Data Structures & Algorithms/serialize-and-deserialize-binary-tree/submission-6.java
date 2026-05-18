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
        List<String> res = new ArrayList<>();

        dfsSerialize(res, root);

        return String.join(",", res);
    }

    private void dfsSerialize(List<String> res, TreeNode node) {
        if (node == null) {
            res.add("N");
            return;
        }

        res.add(String.valueOf(node.val));
        dfsSerialize(res, node.left);
        dfsSerialize(res, node.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;

        idx = 0;
        String[] res = data.split(",");
        return dfsDeserialize(res);
    }

    private TreeNode dfsDeserialize(String[] res) {
        if (res[idx].equals("N")) {
            idx++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(res[idx++]));
        root.left = dfsDeserialize(res);
        root.right = dfsDeserialize(res);

        return root;
    }
}
