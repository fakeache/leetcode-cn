package Middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution15 {
    //排序去重
    //双指针将三重循环变二重循环
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rslist = new LinkedList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //防止重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int sum = -nums[i];
            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                if (nums[j] + nums[k] == sum) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    rslist.add(list);
                    k--;
                    j++;
                } else if (nums[j] + nums[k] > sum) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return rslist;
    }

    public static void main(String[] args) {
        Solution15 solution = new Solution15();
        System.out.println(solution.threeSum(new int[]{34,55,79,28,46,33,2,48,31,-3,84,71,52,-3,93,15,21,-43,57,-6,86,56,94,74,83,-14,28,-66,46,-49,62,-11,43,65,77,12,47,61,26,1,13,29,55,-82,76,26,15,-29,36,-29,10,-70,69,17,49}));
    }
}
