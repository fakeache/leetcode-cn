package Middle;

class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    boolean isValid(TreeNode node, Integer low, Integer high) {
        if (node == null) {
            return true;
        }
        if (low != null && node.val <= low) {
            return false;
        }
        if (high != null && node.val >= high) {
            return false;
        }

        if (node.left != null && !isValid(node.left, low, node.val)) {
            return false;
        }
        if (node.right != null && !isValid(node.right, node.val, high)) {
            return false;
        }
        return true;
    }
}
