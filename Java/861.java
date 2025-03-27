class Solution {
    public int matrixScore(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        for (int i=0;i<n;i++) {
            if (grid[i][0]==0) {
                flip(grid[i]);
            }
        }
        for (int i=0;i<m;i++) {
            int c=0;
            for(int j=0;j<n;j++) {
                c+=grid[j][i];
            }
            if (c < (n-c)) {
                for(int j=0;j<n;j++) {
                    grid[j][i]^=1;
                }
            }
        }
        int ans=0;
        for (int i=0;i<n;i++) {
            ans+=sum(grid[i]);
        }
        return ans;
    }
    public int sum(int[] grid) {
        int ans=0;
        for (int i=0;i<grid.length;i++) {
            if (grid[i]==1) {
                ans=ans+ (1<<(grid.length-i-1));
            }
        }
        return ans;
    }
    public void flip(int[] grid) {
        for (int i=0;i<grid.length;i++) {
            grid[i]^=1;
        }
    }
}