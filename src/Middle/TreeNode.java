package Middle;

import java.util.Deque;
import java.util.LinkedList;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode getTree(Integer[] arr) {
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode t = queue.poll();
            if (arr[i] == null) {
                t.left = null;
            } else {
                t.left = new TreeNode(arr[i]);
                queue.add(t.left);
            }
            i++;
            if (i == arr.length) {
                break;
            }
            if (arr[i] == null) {
                t.right = null;
            } else {
                t.right = new TreeNode(arr[i]);
                queue.add(t.right);
            }
            i++;
        }
        return root;
    }
}
