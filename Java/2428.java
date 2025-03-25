class Solution {
    public int maxSum(int[][] grid) {
        int n=grid.length;
        int m = grid[0].length;
        int ans = -1;
        int[][] cors = {{2,2},{2,1},{2,0},{0,2},{0,0},{0,1},{1,1}};
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                boolean val = true;
                int curr = 0;
                for(int[] k: cors) {
                    int nextx = i+k[0];
                    int nexty = j+k[1];
                    if (nexty < m && nextx<n) {
                        curr+=grid[nextx][nexty];
                    } else {
                        val = false;
                        break;
                    }
                }
                if (val) {
                    ans = Math.max(ans, curr);
                }
            }
        }
        return ans;
    }
}