package Simple;

import java.util.Arrays;

//代码被优化过
class Solution66 {
    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        for(int z=length-1;z>=0;z--){
            if(digits[z]!=9){
                digits[z]++;
                return digits;
            }
            else{
                digits[z]=0;
            }
        }
        int[] x = new int[length+1];
        x[0]=1;
        for(int j=1;j<length+1;j++){
            x[j]=0;
        }
        return x;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,3,4,9,9,9,9,9};
        System.out.println(Arrays.toString(plusOne(nums)));
    }
}