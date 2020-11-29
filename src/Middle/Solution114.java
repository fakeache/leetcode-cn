package Middle;

class Solution114 {
    public void flatten(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            if (node.left == null) {
                node = node.right;
                continue;
            }
            if (node.right != null) {
                TreeNode tmp = node.left;
                while (tmp.right != null) {
                    tmp = tmp.right;
                }
                tmp.right = node.right;
            }
            node.right = node.left;
            node.left = null;
            node = node.right;
        }
    }
}