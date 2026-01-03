class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int[] score = {0,1,2};
        int[] cost = {0,1,1};
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][k+1];
        for (int[][] row: dp) {
            for(int[] col: row) {
                Arrays.fill(col, -1);
            }
        }
        dp[0][0][0] = 0;
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                for (int c=0;c<=k;c++) {
                    if (dp[i][j][c] == -1) continue;
                    int currScore = dp[i][j][c];
                    if (i+1<n) {
                        if (c + cost[grid[i+1][j]] <= k) {
                            dp[i+1][j][c + cost[grid[i+1][j]]] = Math.max(dp[i+1][j][c + cost[grid[i+1][j]]], dp[i][j][c] + score[grid[i+1][j]]);
                        }
                    }
                    if (j+1<m) {
                        if (c + cost[grid[i][j+1]] <= k) {
                            dp[i][j+1][c + cost[grid[i][j+1]]] = Math.max(dp[i][j+1][c + cost[grid[i][j+1]]], dp[i][j][c] + score[grid[i][j+1]]);
                        }
                    }
                }
            }
        }
        int maxScore = -1;
        for (int cst = 0; cst <= k; cst++) {
            maxScore = Math.max(maxScore, dp[n - 1][m - 1][cst]);
        }

        return maxScore;
    }
}
