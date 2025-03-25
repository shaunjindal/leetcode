class Solution {
    public int[][] generateMatrix(int n) {
        int maxR = n-1;
        int maxC = n-1;
        int curr=1;
        int currI = 0;
        int currJ = 0;
        int[][] ans = new int[n][n];
        while (curr<=n*n) {
            for(int i=currJ;i<=maxC;i++) {
                ans[currI][i] = curr++;
            }
            for (int i=currI+1;i<=maxR;i++) {
                ans[i][maxC] = curr++;
            }
            for (int i=maxC-1;i>=currJ;i--) {
                ans[maxR][i] = curr++;
            }
            for (int i=maxR-1;i>currI;i--) {
                ans[i][currJ] = curr++;
            }

            maxR--;
            maxC--;
            currI++;
            currJ++;
        }
        return ans;
    }
}