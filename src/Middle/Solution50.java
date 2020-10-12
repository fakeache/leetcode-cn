package Middle;

class Solution50 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double mul = 1;
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                n++;
                mul *= 1/x;
            }
            n = -n;
            x = 1/x;
        }
        while (n > 0) {
            int t = 1;
            double incr = x;
            while (n - t >= 0) {
                mul *= incr;
                n = n - t;
                t = t << 1;
                incr = incr * incr;
            }
        }
        return mul;
    }
}