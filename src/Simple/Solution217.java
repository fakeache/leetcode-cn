package Simple;

import java.util.HashSet;

public class Solution217 {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>(nums.length);
        for (int num : nums) {
            if (hashSet.contains(num)) {
                return true;
            } else {
                hashSet.add(num);
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] nums = new int[]{3,5,6,10,3};
        System.out.println(containsDuplicate(nums));
    }
}