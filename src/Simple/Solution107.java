package Simple;

import java.util.List;
import java.util.LinkedList;

public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<TreeNode> list = new LinkedList<>();
        List<Integer> valList = new LinkedList<>();
        LinkedList<List<Integer>> resultList = new LinkedList<>();
        list.add(root);
        int index = 0;
        int len = 1;
        if(root==null){
            return resultList;
        }
        for(int i=index;i<len;i++){
            TreeNode node = list.get(i);
            valList.add(node.val);
            if(node.left!=null){
                list.add(node.left);
            }
            if(node.right!=null){
                list.add(node.right);
            }
            if(i==len-1){
                resultList.add(0, valList);
                valList = new LinkedList<>();
                len = list.size();
            }
        }
        return resultList;
    }
}