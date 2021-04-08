package Middle;

public class Solution372 {

    int CC = 1337;

    public int superPow(int a, int[] b) {
        return pows(a, b, b.length - 1);
    }

    public int pows(int a, int[] b, int idx) {
        if (idx < 0) {
            return 1;
        }
        int left = mod(a, b[idx]);
        int right = pows(a, b, idx - 1);
        right = mod(right, 10);
        return (left * right) % CC;
    }

    public int mod(int x, int y) {
        int rs = 1;
        int c = x % CC;
        for (int i = 0; i < y; i++) {
            rs *= c;
            rs %= CC;
        }
        return rs;
    }
}
