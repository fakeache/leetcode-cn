package Simple;

import java.util.LinkedList;
import java.util.Queue;

class Pair{
    TreeNode t;
    int depth;

    Pair(TreeNode t, int d){
        this.t = t;
        depth = d;
    }
}
public class Solution104 {
    //解法1，递归，DFS
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int x = maxDepth(root.left);
        int y = maxDepth(root.right);
        return x>y?x+1:y+1;
    }
    //解法2，非递归，BFS，使用队列
    public int maxDepth1(TreeNode root) {
        Queue<Pair> qu = new LinkedList<>();
        int deep=0;
        qu.add(new Pair(root,1));
        while(!qu.isEmpty()){
            Pair p = qu.poll();
            root = p.t;
            if(root !=null){
                deep = deep>p.depth?deep:p.depth;
                qu.add(new Pair(root.left, p.depth+1));
                qu.add(new Pair(root.right, p.depth+1));
            }
        }
        return deep;
    }
}
