package Simple;

import java.util.Arrays;

public class Solution27 {
    public static int removeElement(int[] nums, int val) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int i=0,j=0;
        while(i<nums.length){
            if(nums[i]!=val){
                nums[j++]=nums[i];
            }
            i++;
        }
        return j;
    }
    public static void main(String[] args){
        int[] nums = new int[]{1,1,2,2,2,4,4,5};
        System.out.println(Arrays.toString(Arrays.copyOf(nums, removeElement(nums, 2))));
    }
}
