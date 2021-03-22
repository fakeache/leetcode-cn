package Middle;

class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0, len = nums.length, sum = 0, minLen = Integer.MAX_VALUE;
        while (end < len) {
            while (end < len && sum < target) {
                sum += nums[end];
                end++;
            }
            while (start <= end && sum >= target) {
                int l = end - start;
                minLen = minLen > l ? l : minLen;
                sum -= nums[start];
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
