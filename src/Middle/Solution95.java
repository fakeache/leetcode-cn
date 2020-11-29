package Middle;

import java.util.ArrayList;
import java.util.List;

class Solution95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generate(1, n);
    }

    List<TreeNode> generate(int begin, int end) {
        if (begin > end) {
            List<TreeNode> r = new ArrayList<TreeNode>();
            r.add(null);
            return r;
        }
        List<TreeNode> rs = new ArrayList<>();
        for (int i = begin; i <= end; i++) {
            List<TreeNode> left = generate(begin, i - 1);
            List<TreeNode> right = generate(i + 1, end);
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode tmp = new TreeNode(i);
                    tmp.left = leftNode;
                    tmp.right = rightNode;
                    rs.add(tmp);
                }
            }
        }
        return rs;
    }
}