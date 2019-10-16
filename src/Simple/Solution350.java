package Simple;

import java.util.Arrays;
import java.util.HashMap;

public class Solution350 {
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            int x= nums1[i];
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
        }
        int[] arr = new int[nums2.length];
        int k = 0;
        for (int j = 0; j < nums2.length; j++) {
            int y = nums2[j];
            if (map.containsKey(y)) {
                arr[k++] = y;
                if (map.get(y) == 1) {
                    map.remove(y);
                } else {
                    map.put(y, map.get(y) - 1);
                }
            }
        }
        return Arrays.copyOf(arr, k);
    }
    public static void main(String[] args){
        int[] nums1 = new int[]{3,0,6,0,5,1,2};
        int[] nums2 = new int[]{8,0,7,0,5,3};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }
}