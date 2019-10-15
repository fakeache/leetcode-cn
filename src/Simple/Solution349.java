package Simple;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Solution349 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        HashSet setLong;
        HashSet setShort;
        if (set1.size() > set2.size()) {
            setLong = set1;
            setShort = set2;
        } else {
            setLong = set2;
            setShort = set1;
        }
        Iterator it = setShort.iterator();
        int[] rs = new int[setShort.size()];
        int i = 0;
        while (it.hasNext()) {
            Integer t = (Integer)it.next();
            if (setLong.contains(t)) {
                rs[i++] = t;
            }
        }
        return Arrays.copyOf(rs, i);
    }
    public static void main(String[] args){
        int[] nums1 = new int[]{3,0,6,0,5,1,2};
        int[] nums2 = new int[]{8,0,7,0,5,3};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

}
