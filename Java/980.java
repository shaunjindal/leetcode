class Solution {
    int[][] dir = new int[][] {{1,0}, {0,1}, {-1,0}, {0,-1}};
    boolean[][] vis;
    int ans = 0;
    int[] src;
    int[][] grid;
    int n;
    int m;
    int co = 0;
    int path = 0;

    public int uniquePathsIII(int[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;
        this.grid = grid;
        this.vis = new boolean[n][m];
        this.co = 0;
        this.ans = 0;
        for (int i = 0; i<n; i++) {
            for (int j=0;j<m;j++) {
                if (grid[i][j] == 0) {
                    co++;
                }
                if (grid[i][j]==1) {
                    src = new int[]{i,j};
                }
            }
        }
        dfs(src);
        return ans;
    }

    private void dfs(int[] s) {
        vis[s[0]][s[1]] = true;
        for (int[] i: dir) {
            int nextX = s[0] + i[0];
            int nextY = s[1] + i[1];
            if (nextX < n && nextX >=0 && nextY < m && nextY >=0 && !vis[nextX][nextY]) {
                if (grid[nextX][nextY] == 0) {
                    path++;
                    dfs(new int[] {nextX, nextY});
                }
                else if (grid[nextX][nextY] == 2) {
                    if (path == co) ans++;
                }
            }
        }
        vis[s[0]][s[1]] = false;
        path--;
    }
}
