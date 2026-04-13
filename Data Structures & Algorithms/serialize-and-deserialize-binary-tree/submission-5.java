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

    private int index;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();

        dfsSerialize(root, res);

        return String.join(",", res);
    }

    private void dfsSerialize(TreeNode node, List<String> res) {
        if (node == null) {
            res.add("N");
            return;
        }

        res.add(Integer.toString(node.val));
        dfsSerialize(node.left, res);
        dfsSerialize(node.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        } 

        String[] list = data.split(",");
        return dfsDeserialize(list);

    }

    private TreeNode dfsDeserialize(String[] list) {
        if (list[index].equals("N")) {
            index++;
            return null;
        }

        int val = Integer.parseInt(list[index]);
        TreeNode node = new TreeNode(val);
        index++;
        node.left = dfsDeserialize(list);
        node.right = dfsDeserialize(list);

        return node;
    }
}
