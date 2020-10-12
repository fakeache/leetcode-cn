package Simple;

class Solution530 {
    int min = Integer.MAX_VALUE;
    int pre = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        midTravese(root);
        return min;
    }

    public void midTravese(TreeNode node) {
        if (node == null) {
            return;
        }
        midTravese(node.left);
        int comp = Math.abs(node.val - pre);
        min = comp < min ? comp : min;
        pre = node.val;
        midTravese(node.right);
    }
}