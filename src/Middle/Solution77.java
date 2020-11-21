package Middle;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution77 {
    List<List<Integer>> rsList = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        Deque<Integer> list = new LinkedList<>();
        dfs(list, 0, k, n);
        return rsList;
    }

    void dfs(Deque<Integer> list, int x, int k, int n) {
        if (list.size() == k) {
            List<Integer> nlist = new LinkedList<>(list);
            rsList.add(nlist);
            return;
        }
        for (int i = x + 1; i <= n - k + list.size() + 1; i++) {
            list.add(i);
            dfs(list, i, k, n);
            list.removeLast();
        }
    }
}
