package Middle;

class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    TreeNode build(int[] preorder, int[] inorder, int pleft, int pright, int ileft, int iright) {
        if (pleft > pright || ileft > iright) {
            return null;
        }
        int f = preorder[pleft];
        TreeNode head = new TreeNode(f);
        int i = ileft;
        for (; i <= iright; i++) {
            if (inorder[i] == f) {
                break;
            }
        }
        head.left = build(preorder, inorder, pleft + 1, i - ileft + pleft, ileft, i - 1);
        head.right = build(preorder, inorder, i - ileft + pleft + 1, pright, i + 1, iright);
        return head;
    }
}
