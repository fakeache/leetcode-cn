package Simple;

class Solution35 {
    public static int searchInsert(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int low=0, high=nums.length-1, mid=0;
        while(low<=high){
            mid=(low+high)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        if(nums[mid]<target){
            return mid+1;
        }
        else{
            return mid;
        }
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,2,4,5};
        System.out.println(searchInsert(nums,3));
    }
}