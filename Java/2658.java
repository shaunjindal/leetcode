class Solution {
    int curr = 0;
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    int nextX, nextY;
    private void dfs(int[][] grid, int i, int j) {
        curr+=grid[i][j];
        grid[i][j] = 0;
        
        for (int[] d: dir) {
            nextX = i + d[0];
            nextY = j + d[1];
            if (nextX>=0 && nextY>=0 && nextY<grid[0].length && nextX<grid.length && grid[nextX][nextY]>0) {
                dfs(grid, nextX, nextY);
            }
        }
    }
    public int findMaxFish(int[][] grid) {
        int ans = 0;
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                if (grid[i][j] > 0) {
                    curr = 0;
                    dfs(grid, i, j);
                    ans = Math.max(ans, curr);
                }
            }
        }
        return ans;
    }
}
