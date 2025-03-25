class Solution {
    private void swap(int[][] matrix, int i, int j) {
        int n = matrix.length;
        int newI = i;
        int newJ = j;
        for (int k=0;k<4;k++) {
            int currI = newI;
            newI = newJ;
            newJ = n-currI-1;
            int temp = matrix[i][j];
            matrix[i][j] = matrix[newI][newJ];
            matrix[newI][newJ] = temp;
        }
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
        // swap(matrix,1,1);
        // swap(matrix,1,2);
        // swap(matrix,1,3);
        // // swap(matrix,1,4);
        // // swap(matrix,2,2);
        // swap(matrix,2,3);
        // swap(matrix,2,2);
    }
    // public void rotate(int[][] matrix) {
    //     // 0,0 0,2
    //     // 0,1 1,2
    //     // 0,2 2,2
    //     // 1,0 0,1
    //     // 1,1 1,1
    //     // 1,2 2,1
    //     // 2,0 0,0
    //     // 2,1 1,0
    //     // 2,2 2,0

    //     // 0,0 0,2
    //     // 0,2 2,2
    //     // 2,2 2,0
    //     // 2,0 0,0

    //     // 0,1 1,2
    //     // 1,2 2,1
    //     // 2,1 1,0
    //     // 1,0 0,1

    // 0,0 0,4


    // 0,0 0,3
    // 0,1 1,3
    // 0,2 2,3
    // 0,3 3,3

    // 1,0 0,2
    // 1,1 1,2
    // 1,2 2,2
    // // 1,3 3,2

    // // 2,0 0,1
    // 2,1 1,1
    // 2,2 2,1
    // // 2,3 3,1

    // // 3,0 0,0
    // // 3,1 1,0
    // // 3,2 2,0
    // // 3,3 3,0

    // 0,0 0,3
    // 0,3 3,3
    // 3,3 3,0
    // 3,0 0,0

    // 0,1 1,3
    // 1,3 3,2
    // 3,2 2,0
    // 2,0 0,1

    // 0,2 2,3
    // 2,3 3,1
    // 3,1 1,0
    // 1,0 0,2




    // }
}