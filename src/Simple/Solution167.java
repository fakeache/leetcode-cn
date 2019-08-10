package Simple;

import java.util.Arrays;

public class Solution167 {
    public static int[] twoSum(int[] numbers, int target) {
        if(numbers==null || numbers.length==0){
            return null;
        }
        int index1=0;
        int index2=numbers.length-1;
        while(index1<index2){
            if(numbers[index1]+numbers[index2] == target){
                return new int[]{index1+1, index2+1};
            }
            else if(numbers[index1]+numbers[index2] < target){
                index1++;
            }
            else{
                index2--;
            }
        }
        return null;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,3,5,6,7,10};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }
}
