package Middle;

class Solution73 {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] arr1 = new boolean[m];
        boolean[] arr2 = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    arr1[i] = true;
                    arr2[j] = true;
                }
            }
        }
        for(int i = 0; i < m; i++) {
            if (arr1[i]) {
                for(int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for(int i = 0; i < n; i++) {
            if (arr2[i]) {
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
}