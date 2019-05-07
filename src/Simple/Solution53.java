package Simple;

public class Solution53 {
    public static int maxSubArray(int[] nums) {
        int Max = nums[0];
        int sum = 0;
        int MaxBegin=0, MaxEnd=0;
        int SumBegin=0, SumEnd=0;
        for(int i=0;i<nums.length;i++){
            if(sum>0){
                sum = sum + nums[i];
                SumEnd += 1;
                if(sum > Max){
                    Max = sum;
                    MaxBegin = SumBegin;
                    MaxEnd = SumEnd;
                }
            }
            else {
                sum = nums[i];
                SumBegin = i;
                SumEnd = i;
                if(sum > Max){
                    Max = sum;
                    MaxBegin = SumBegin;
                    MaxEnd = SumEnd;
                }
            }
        }
        System.out.print("[");
        for (int j=MaxBegin;j<MaxEnd;j++){
            System.out.print(nums[j] + ", ");
        }
        System.out.println(nums[MaxEnd] +"]");
        return Max;
    }

    public static void main(String[] args){
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
