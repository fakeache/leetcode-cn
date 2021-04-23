package Middle;

public class Solution457 {
    public boolean circularArrayLoop(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int lastJ, lastK;
            int j = i, k = i;
            while (true) {
                lastJ = j;
                j = nextIndex(nums, j);
                if (j == lastJ || nums[j] * nums[lastJ] < 0 || nums[j] == 0) {
                    setZero(nums, i);
                    break;
                }
                lastK = k;
                k = nextIndex(nums, k);
                if (k == lastK || nums[k] * nums[lastK] < 0 || nums[k] == 0) {
                    setZero(nums, i);
                    break;
                }
                lastK = k;
                k = nextIndex(nums, k);
                if (k == lastK || nums[k] * nums[lastK] < 0 || nums[k] == 0) {
                    setZero(nums, i);
                    break;
                }
                if (j == k) {
                    return true;
                }
            }
        }
        return false;
    }

    public int nextIndex(int[] nums, int i) {
        int next = (nums[i] + i) % nums.length;
        return next < 0 ? next + nums.length : next;
    }

    public void setZero(int[] nums, int i) {
        int next;
        while (true) {
            next = nextIndex(nums, i);
            nums[i] = 0;
            if (nums[i] == 0 || nums[i] * nums[next] < 0) {
                break;
            }
            i = next;
        }
    }
}
