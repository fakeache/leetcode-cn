package Middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution18 {
    List<List<Integer>> rslist = new LinkedList<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return rslist;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < len; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int l = len - 1;
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>(4);
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        rslist.add(temp);
                        k++;
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                    while (k < l && k > j + 1 && nums[k] == nums[k - 1]) {
                        k++;
                    }
                    while (k < l && l < len - 1 && nums[l] == nums[l + 1]) {
                        l--;
                    }

                }
            }
        }
        return rslist;
    }

    public static void main(String[] args) {
        Solution18 solution = new Solution18();
        System.out.println(solution.fourSum(new int[]{-1,0,-5,-2,-2,-4,0,1,-2}, -9));
    }
}