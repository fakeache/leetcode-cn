package Middle;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution113 {
    List<List<Integer>> rsList = new LinkedList<>();
    Deque<Integer> list = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return rsList;
    }

    public void dfs(TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        sum = sum - node.val;
        if (node.left == null && node.right == null && 0 == sum) {
            rsList.add(new LinkedList<>(list));
        }
        dfs(node.left, sum);
        dfs(node.right, sum);
        list.removeLast();

    }

    public static void main(String[] args) {
        Solution113 solution = new Solution113();
        TreeNode tn = TreeNode.getTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1});
        System.out.println(solution.pathSum(tn, 22));
    }
}