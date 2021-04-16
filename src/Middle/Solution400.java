package Middle;

public class Solution400 {
    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        long nl = n;
        long t = 9;
        int idx = 1;
        int b = 1;
        while (nl - t > 0) {
            nl = nl - t;
            t = t * 10 * (idx + 1) / idx;
            ++idx;
            b *= 10;
        }
        int num = ((int) nl - 1) / idx + b;
        int flag = ((int) nl - 1) % idx;
        String str = String.valueOf(num);
        return str.charAt(flag) - '0';
    }
}
