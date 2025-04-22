class Solution {
    private void dfs(int[][] isConnected, int r) {
        for (int i=0;i<isConnected[r].length; i++) {
            if (isConnected[r][i] == 1) {
                isConnected[r][i] = 0;
                isConnected[i][r] = 0;
                dfs(isConnected, i);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        for (int i=0;i<isConnected.length;i++) {
            for (int j=0;j<isConnected.length;j++) {
                if (isConnected[i][j] == 1) {
                    isConnected[i][j] = 0;
                    isConnected[j][i] = 0;
                    dfs(isConnected, i);
                    ans++;
                }
            }
        }
        return ans;
    }
}
