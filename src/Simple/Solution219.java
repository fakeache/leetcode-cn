package Simple;

import java.util.HashSet;

public class Solution219 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(nums[i])) {
                return true;
            }
            hashSet.add(nums[i]);
            if (hashSet.size() > k) {
                hashSet.remove(nums[i-k]);
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] nums = new int[]{3,5,6,10,3,6};
        System.out.println(containsNearbyDuplicate(nums, 5));
    }
}
