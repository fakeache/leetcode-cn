package Middle;

public class Solution443 {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        int len = chars.length;
        int pre = 0;
        int count = 0;
        for (int i = 0; i < len; i++) {
            ++count;
            if (i == len - 1 || chars[i] != chars[i + 1]) {
                chars[pre++] = chars[i];
                if (count > 1) {
                    String countStr = String.valueOf(count);
                    for (int j = 0; j < countStr.length(); j++) {
                        chars[pre++] = countStr.charAt(j);
                    }
                }
                count = 0;
            }
        }
        return pre;
    }

    public static void main(String[] args) {
        new Solution443().compress(new char[]{'a','a','b', 'b','c','c','c'});
    }
}
