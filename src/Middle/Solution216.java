package Middle;

import java.util.ArrayList;
import java.util.List;

class Solution216 {

    List<List<Integer>> rs = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(new ArrayList<>(), n, k, 1);
        return rs;
    }

    public void dfs(List<Integer> list, int rest, int k, int idx) {
        if (list.size() == k || rest == 0) {
            if (list.size() == k && rest == 0) {
                rs.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = idx; i <= 9; i++) {
            if (rest < i) {
                continue;
            }
            list.add(i);
            dfs(list, rest - i, k, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
