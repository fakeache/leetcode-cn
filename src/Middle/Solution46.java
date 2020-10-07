package Middle;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution46 {
    List<List<Integer>> rslist = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return rslist;
        }
        dfsSeq(nums, new HashSet<>(), new LinkedList<>());
        return rslist;
    }

    public void dfsSeq(int[] nums, Set<Integer> set, List<Integer> list) {
        if (set.size() == nums.length) {
            rslist.add(list);
            return;
        }
        for (int i : nums) {
            if (set.contains(i)) {
                continue;
            }
            set.add(i);
            List<Integer> nlist = new LinkedList<>(list);
            nlist.add(i);
            dfsSeq(nums, set, nlist);
            set.remove(i);
        }
    }
}