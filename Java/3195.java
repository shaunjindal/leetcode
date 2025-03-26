class Solution {
    public int minimumArea(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int minR=-1,maxR=-1,maxC=-1,minC=Integer.MAX_VALUE;
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (grid[i][j]==1) {
                    if (minR == -1) {
                        minR = i;
                    }
                    maxR = i;
                    minC = Math.min(j,minC);
                    maxC=Math.max(j, maxC);
                }
            }
        }
        return (maxR-minR+1)*(maxC-minC+1);
    }
}