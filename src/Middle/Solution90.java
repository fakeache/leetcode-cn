package Middle;

import java.util.*;

class Solution90 {
    List<List<Integer>> rsList = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(new LinkedList<>(), -1, nums);
        rsList.add(new LinkedList<>());
        return rsList;
    }

    public void dfs(Deque<Integer> list, int k, int[] nums) {
        for (int i = k + 1; i < nums.length; i++) {
            if (i > k + 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            rsList.add(new ArrayList<>(list));
            dfs(list, i, nums);
            list.removeLast();
        }
    }
}