package Middle;

import java.util.ArrayList;
import java.util.List;

public class Solution437 {
    int count = 0;
    int targetSum;
    public int pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        dfs(root);
        return count;
    }

    public List<Integer> dfs(TreeNode node) {
        if (node == null) {
            return new ArrayList<>();
        }
        List<Integer> left = dfs(node.left);
        List<Integer> right = dfs(node.right);
        left.addAll(right);
        for (int i = 0; i < left.size(); i++) {
            int x = left.get(i) + node.val;
            if (x == targetSum) {
                count++;
            }
            left.set(i, x);
        }
        left.add(node.val);
        if (node.val == targetSum) {
            count++;
        }
        return left;
    }
}
