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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        serializeDfs(root, res);
        return String.join(",", res); 
    }

    private void serializeDfs(TreeNode root, List<String> res) {
        if (root == null) {
            res.add("N");
            return;
        }

        res.add(String.valueOf(root.val));
        serializeDfs(root.left, res);
        serializeDfs(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        int[] index = {0};
        return deserializeDfs(index, vals);
    }

    private TreeNode deserializeDfs(int[] index, String[] vals) {
        if (vals[index[0]].equals("N")) {
            index[0]++;
            return null;
        } 
        TreeNode node = new TreeNode(Integer.parseInt(vals[index[0]]));
        index[0]++;
        node.left = deserializeDfs(index, vals);
        node.right = deserializeDfs(index, vals);

        return node;
    }
}
