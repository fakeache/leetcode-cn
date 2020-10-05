package Middle;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> rslist = new LinkedList<>();
        if (candidates == null) {
            return rslist;
        }
        Arrays.sort(candidates);
        dfsSearch(rslist, new LinkedList<Integer>(), candidates, target, 0);
        return rslist;
    }

    public void dfsSearch(List<List<Integer>> rslist, Deque<Integer> stk, int[] candidates, int target, int i) {
        if (target == 0) {
            rslist.add(new LinkedList<Integer>(stk));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            if (j > i && candidates[j] == candidates[j - 1]) {
                continue;
            }
            stk.push(candidates[j]);
            dfsSearch(rslist, stk, candidates, target - candidates[j], j + 1);
            stk.pop();
        }
    }
}
