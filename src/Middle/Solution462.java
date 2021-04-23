package Middle;

public class Solution462 {
    public int minMoves2(int[] nums) {
        int mid = select(nums, (nums.length - 1) / 2);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += Math.abs(nums[i] - mid);
        }
        return sum;
    }

    public int select(int[] nums, int k) {
        int len = nums.length;
        int low = 0, high = len - 1;
        while (low < high) {
            int idx = partition(nums, low, high);
            if (idx == k) {
                return nums[idx];
            } else if (idx < k) {
                low = idx + 1;
            } else {
                high = idx - 1;
            }
        }
        return nums[low];
    }

    public int partition(int[] nums, int i, int j) {
        int pivot = nums[i];
        while (i < j) {
            while (i < j && nums[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(nums, i, j);
            }
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        nums[i] = pivot;
        return i;
    }
    public void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    public static void main(String[] args) {
        new Solution462().minMoves2(new int[]{1, 2, 3});
    }
}
