package Simple;

class Solution977 {
    public int[] sortedSquares(int[] A) {
        int len = A.length;
        int[] rs = new int[len];
        int i = 0;
        for (; i < len; i++) {
            if (A[i] >= 0) {
                break;
            }
        }
        int x = i - 1;
        int y = i;
        int index = 0;
        while (true) {
            if (x < 0 && y >= len) {
                break;
            }
            int xx = -1;
            int yy = -1;
            if (x >= 0) {
                xx = A[x] * A[x];
            }
            if (y < len) {
                yy = A[y] * A[y];
            }
            if (x < 0) {
                rs[index++] = yy;
                y++;
                continue;
            }
            if (y > len - 1) {
                rs[index++] = xx;
                x--;
                continue;
            }
            if (xx > yy) {
                rs[index++] = yy;
                y++;
            } else {
                rs[index++] = xx;
                x--;
            }
        }
        return rs;
    }
}