package Middle;

class Solution80 {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }
        int pre = 1, back = 0;
        int dup = 0;
        while (pre < nums.length) {
            if (nums[pre] == nums[back]) {
                dup++;
                if (dup == 1) {
                    nums[++back] = nums[pre++];
                } else if (dup > 1) {
                    pre++;
                }
            } else {
                dup = 0;
                nums[++back] = nums[pre++];
            }
        }
        return back + 1;
    }
}
