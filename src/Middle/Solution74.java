package Middle;

class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int low = 0;
        int high = row * column - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int m = mid / column;
            int n = mid % column;
            if (matrix[m][n] == target) {
                return true;
            } else if (matrix[m][n] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}