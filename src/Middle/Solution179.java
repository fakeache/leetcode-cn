package Middle;

import java.util.Arrays;
import java.util.Comparator;

public class Solution179 {
    public String largestNumber(int[] nums) {
        String[] numStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numStr, new newComparator());
        if (Integer.valueOf(numStr[0]) == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numStr.length; i++) {
            sb.append(numStr[i]);
        }
        return sb.toString();
    }

    static class newComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            String s1 = o1 + o2;
            String s2 = o2 + o1;
            return s2.compareTo(s1);
        }
    }
}
