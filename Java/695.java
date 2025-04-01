class Solution {
    int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    int ans = 0;
    int curr = 0;
    int n,m;
    private void dfs(int[][] grid, int i, int j) {
        grid[i][j] = 0;
        curr++;
        int nextX, nextY;
        for (int[] d:dir) {
            nextX = i + d[0];
            nextY = j + d[1];
            if (nextX>=0 && nextY>=0 && nextY<m && nextX<n &&grid[nextX][nextY] == 1) {
                dfs(grid, nextX, nextY);
            }
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        for (int i=0; i<n; i++) {
            for (int j=0;j<m;j++) {
                curr = 0;
                if (grid[i][j]==1) {
                    dfs(grid, i, j);
                }
                ans = Math.max(curr, ans);
            }
        }
        return ans;
    }
}