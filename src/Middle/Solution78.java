package Middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution78 {
    List<List<Integer>> rsList = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return rsList;
        }
        Arrays.sort(nums);
        rsList.add(new ArrayList<>());
        dfs(new ArrayList<>(), nums, -1);
        return rsList;
    }

    void dfs(List<Integer> list, int[] nums, int x) {
        for (int i = x + 1; i < nums.length; i++) {
            List<Integer> nlist = new ArrayList<>(list);
            nlist.add(nums[i]);
            rsList.add(nlist);
            dfs(nlist, nums, i);
        }
    }
}