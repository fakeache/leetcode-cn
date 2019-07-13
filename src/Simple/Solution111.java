package Simple;

public class Solution111 {
    public int minDep(TreeNode root) {
        if(root==null){
            return Integer.MAX_VALUE;
        }
        if(root.left==null && root.right==null){
            return 1;
        }
        int left = minDep(root.left);
        int right = minDep(root.right);
        return left>right?right+1:left+1;
    }
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return minDep(root);
    }
}