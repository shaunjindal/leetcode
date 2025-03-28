class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = 0;
        for (int i=0;i<n;i++) {
            for(int j=m-1;j>=0;j--) {
                if (matrix[i][j] == 1) {
                    if (j+1<m)
                        matrix[i][j] = matrix[i][j+1] + matrix[i][j];
                    ans++;
                }
            }
        }
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (matrix[i][j]>1) {
                    for (int k = matrix[i][j];k>1;k--) {
                        boolean b = true;
                        if (i+k-1<n) {
                            for (int l = i+1; l<Math.min(i+k,n);l++) {
                                if (matrix[l][j] < k) {
                                    b=false;
                                    break;
                                }
                            }
                            if (b) {
                                ans++;
                            }
                        }
                    }
//                    int max = matrix[i][j];
//                    for (int k=i+1; k<Math.min(n,i+matrix[i][j]);k++) {
//                        max = Math.min(matrix[k][j], max);
//                    }
//                    if (max>0) {
//                        if (i+max>n) {
//                            int t = n-i-1;
//                            if (t>0) {
//                                ans = ans + (t * (t + 1)) / 2;
//                                j = j + t - 1;
//                            }
//                        } else {
//                            max = max - 1;
//                            if (max > 0)
//                                ans = ans + (max*(max+1))/2;
//                            j = j+max;
//                        }
//                    }

                }
            }
        }
        return ans;
    }
}