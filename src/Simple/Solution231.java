package Simple;

public class Solution231 {
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        int m = n;
        while (true) {
            if (m % 2 == 1) {
                if (m == 1) {
                    return true;
                } else {
                    return false;
                }
            } else {
                m = m / 2;
            }
        }
    }

    public static boolean isPowerOfTwo1(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args){
        int n = 16;
        System.out.println(isPowerOfTwo(n));
        System.out.println(isPowerOfTwo1(n));
    }
}
