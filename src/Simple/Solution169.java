package Simple;

public class Solution169 {
    //投票者算法
    public static int majorityElement(int[] nums) {
        int count=0;
        int l = 0;
        for(int i=0;i<nums.length;i++){
            if(count==0){
                l=nums[i];
            }
            if(nums[i]==l){
                count++;
            }
            else{
                count--;
            }
        }
        return l;
    }

    public static void main(String[] args){
        int[] nums = new int[]{3,3,5,6,3,10,3};
        System.out.println(majorityElement(nums));
    }
}