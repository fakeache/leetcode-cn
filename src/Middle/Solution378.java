package Middle;

public class Solution378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(matrix, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[][] matrix, int k, int ele) {
        int num = 0;
        int n = matrix.length;
        int i = n - 1, j = 0;
        while (j < n && i >=0) {
            if (matrix[i][j] <= ele) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }
}
