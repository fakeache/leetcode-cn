package Simple;

public class Solution344 {
    public void reverseString(char[] s) {
        if (s == null) {
            return;
        }
        int len = s.length;
        for (int i = 0, j = len - 1; i < j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}