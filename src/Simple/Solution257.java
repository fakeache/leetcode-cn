package Simple;

import java.util.LinkedList;
import java.util.List;

public class Solution257 {
    List<String> list = new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        TreePaths(root, "");
        return list;
    }

    public void TreePaths(TreeNode root, String path) {
        if (root == null) {
            return;
        }
        if (path == null || path == "") {
            path = "" + root.val;
        } else {
            path = path + "->" + root.val;
        }
        if (root.left == null && root.right == null) {
            list.add(path);
            return;
        }
        if (root.left != null) {
            TreePaths(root.left, path);
        }
        if (root.right != null) {
            TreePaths(root.right, path);
        }
    }
}
