package Middle;

class Solution45 {
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int times = 0;
        int position = 0;
        while (position < nums.length - 1) {
            if (position + nums[position] >= nums.length - 1) {
                position = nums.length - 1;
            } else {
                int flag = 0;
                int max = 0;
                for (int i = 1; i <= nums[position]; i++) {
                    if (i + nums[position + i] > max) {
                        flag = i;
                        max = i + nums[position + i];
                    }
                }
                position += flag;
            }
            times++;
        }
        return times;
    }
}
