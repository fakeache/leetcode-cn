package Simple;

public class Solution268 {
    public static int missingNumber(int[] nums) {
        int len = nums.length;
        int origin = len * (len + 1) / 2;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        return origin - sum;
    }

    public static void main(String[] args){
        int[] nums = new int[]{3,0,6,5,1,2};
        System.out.println(missingNumber(nums));
    }
}