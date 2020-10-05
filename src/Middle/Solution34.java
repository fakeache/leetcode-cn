package Middle;

class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int[] rs = new int[2];
        rs[0] = binarySearchBound(nums, target, true);
        rs[1] = binarySearchBound(nums, target, false);
        return rs;
    }

    public int binarySearchBound(int[] nums, int target, boolean isLeft) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                if (isLeft) {
                    if (mid == 0 || nums[mid] != nums[mid - 1]) {
                        return mid;
                    } else {
                        high = mid - 1;
                    }
                } else {
                    if (mid == nums.length - 1 || nums[mid] != nums[mid + 1]) {
                        return mid;
                    } else {
                        low = mid + 1;
                    }
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}