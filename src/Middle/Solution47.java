package Middle;

import java.util.*;

class Solution47 {
    List<List<Integer>> rslist = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return rslist;
        }
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        dfsSeq(nums, map, new LinkedList<>());
        return rslist;
    }

    public void dfsSeq(int[] nums, Map<Integer, Integer> map, List<Integer> list) {
        if (list.size() == nums.length) {
            rslist.add(list);
            return;
        }
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (map.get(nums[i]) < 1) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            map.put(nums[i], map.get(nums[i]) - 1);
            List<Integer> nlist = new LinkedList<>(list);
            nlist.add(nums[i]);
            dfsSeq(nums, map, nlist);
            map.put(nums[i], map.get(nums[i]) + 1);

        }
    }

    public static void main(String[] args) {
        Solution47 solution = new Solution47();
        System.out.println(solution.permuteUnique(new int[]{1, 1, 2}));
    }
}