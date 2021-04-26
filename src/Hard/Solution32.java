package Hard;

public class Solution32 {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0, right = 0, count = 0;
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (c == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                count = Math.max(count, left * 2);
            }
            if (left < right) {
                left = 0;
                right = 0;
            }
        }
        left = 0;
        right = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == ')') {
                right++;
            } else {
                left++;
            }
            if (left == right) {
                count = Math.max(count, right * 2);
            }
            if (left > right) {
                left = 0;
                right = 0;
            }
        }
        return count;
    }
}
