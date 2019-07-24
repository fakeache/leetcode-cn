package Simple;

public class Solution136 {
    public static int singleNumber(int[] nums) {
        int rs = 0;
        for(int i=0;i<nums.length;i++){
            rs = rs ^ nums[i];
        }
        return rs;
    }

    public static void main(String[] args){
        int[] nums = new int[]{7,1,13,7,4,1,4};
        System.out.println(singleNumber(nums));
    }
}
