package Middle;

class Solution31 {
    public void nextPermutation(int[] nums) {
        if (nums == null && nums.length <= 1) {
            return;
        }
        int nlen = nums.length;
        int i = nlen - 2;
        for (; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }
        i++;
        int j = nlen - 1;
        int l = i;
        while (l < j) {
            int temp = nums[j];
            nums[j] = nums[l];
            nums[l] = temp;
            l++;
            j--;
        }
        if (i > 0) {
            int t = nums[i - 1];
            for (int k = i; k < nlen; k++) {
                if (nums[k] > t) {
                    nums[i - 1] = nums[k];
                    nums[k] = t;
                    break;
                }
            }
        }
    }
}