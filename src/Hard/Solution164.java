package Hard;

public class Solution164 {
    public int maximumGap(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int len = nums.length;
        if (len < 2) {
            return 0;
        }
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        int[][] tmp = new int[10][len];
        int[] order = new int[10];
        long d = 1;
        while (d <= max) {
            for (int i = 0; i < len; i++) {
                int cur = (nums[i] / (int) d) % 10;
                tmp[cur][order[cur]] = nums[i];
                order[cur]++;
            }
            int count = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < order[i]; j++) {
                    nums[count++] = tmp[i][j];
                }
                order[i] = 0;
            }
            d *= 10;
        }
        int maxGap = 0;
        for (int i = 1; i < len; i++) {
            maxGap = Math.max(maxGap, nums[i] - nums[i - 1]);
        }
        return maxGap;
    }
}
