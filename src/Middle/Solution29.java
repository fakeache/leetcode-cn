package Middle;

class Solution29 {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        int cha = 0;
        if (dividend > 0) {
            cha++;
            dividend = -dividend;
        }
        if (divisor > 0) {
            cha--;
            divisor = -divisor;
        }
        int s = cha == 0 ? 1 : -1;
        int rs = 0;
        while (dividend <= divisor) {
            int t = 1;
            int div = divisor;
            while (dividend - div <= div) {
                div = div << 1;
                t = t << 1;
            }
            dividend -= div;
            rs += t;
        }
        return s * rs;
    }
}