package Simple;

import java.util.Arrays;

public class Solution26 {
    public static int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int i=0,j=0;
        int temp=nums[0];
        while(i<nums.length-1){
            if(nums[++i]!=temp){
                nums[++j]=nums[i];
                temp=nums[i];
            }
        }
        return j+1;
    }
    public static void main(String[] args){
        int[] nums = new int[]{1,1,2,2,2,4,4,5};
        System.out.println(Arrays.toString(Arrays.copyOf(nums, removeDuplicates(nums))));
    }
}

