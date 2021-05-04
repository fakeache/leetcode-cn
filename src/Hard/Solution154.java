package Hard;

public class Solution154 {
    public int findMin(int[] nums) {
        int len = nums.length;
        int low = 0, high = len - 1;
        while (low < high) {
            while (low < high && nums[low] == nums[low + 1]) {
                low++;
            }
            while (low < high && nums[high] == nums[high - 1]) {
                high--;
            }
            int mid = (low + high) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}
