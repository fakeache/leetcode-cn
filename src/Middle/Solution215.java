package Middle;

class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        for (int i = n/2 - 1; i >= 0; i--) {
            sink(nums, i, n);
        }
        for (int i = 0; i < k - 1; i++) {
            exch(nums, 0, n - 1);
            n--;
            sink(nums, 0, n);
        }
        return nums[0];
    }

    public void sink(int[] nums, int m, int n) {
        while (2 * m + 1 < n) {
            int j = 2 * m + 1;
            if (j + 1 < n) {
                j = nums[j] >= nums[j + 1] ? j : j + 1;
            }
            if (nums[m] > nums[j]) {
                break;
            }
            exch(nums, m, j);
            m = j;
        }
    }

    public void exch(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}
