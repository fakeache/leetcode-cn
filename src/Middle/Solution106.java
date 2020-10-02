package Middle;

class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        int len = postorder.length;
        int value = postorder[len - 1];
        TreeNode node = new TreeNode(value);
        int i = 0;
        for (; i < len; i++) {
            if (inorder[i] == value) {
                break;
            }
        }
        if (i == 0) {
            node.left = null;
        } else {
            int[] linorder = new int[i];
            int[] lpostorder = new int[i];
            for (int k = 0; k < i; k++) {
                linorder[k] = inorder[k];
                lpostorder[k] = postorder[k];
            }
            node.left = buildTree(linorder, lpostorder);
        }
        int j = len - i - 1;
        if (j == 0) {
            node.right = null;
        } else {
            int[] rinorder = new int[j];
            int[] rpostorder = new int[j];
            for (int k = 0; k < j; k++) {
                rinorder[k] = inorder[k + i + 1];
                rpostorder[k] = postorder[k + i];
            }
            node.right = buildTree(rinorder, rpostorder);
        }
        return node;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Solution106 solution106 = new Solution106();
        solution106.buildTree(new int[]{3, 10}, new int[]{10, 3});
    }
}