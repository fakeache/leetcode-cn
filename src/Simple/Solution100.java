package Simple;

import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null || q==null){
            if(p==null && q==null){
                return true;
            }
            else{
                return false;
            }
        }
        if(isSameTree(p.left, q.left) && isSameTree(p.right, q.right) && p.val == q.val){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        list.add(root);
        while(!list.isEmpty()){
            TreeNode t1 = list.poll();
            TreeNode t2 = list.poll();
            if(t1==null && t2==null){
                continue;
            }
            if(t1==null || t2==null || t1.val!=t2.val){
                return false;
            }
            list.add(t1.left);
            list.add(t2.right);
            list.add(t1.right);
            list.add(t2.left);
        }
        return true;
    }

    public static void main(String[] args){
        LinkedList<TreeNode> l = new LinkedList<>();
        l.add(null);
        System.out.println(l.size());
    }
}
