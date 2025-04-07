class Solution {
    public int[] findBall(int[][] grid) {
        int n =grid.length;
        int m = grid[0].length;
        int[] ans = new int[m];
        for (int i=0;i<m;i++) {
            if (i==0 && grid[0][0]==-1) {
                ans[i]=-1;
            } else if (i==m-1 && grid[0][i]==1) {
                ans[i]=-1;
            } else {
                int nextX = 0, nextY=i;
                boolean b = false;
                while (nextX<n && nextY<m && nextX>=0 && nextY>=0) {
                    if (grid[nextX][nextY] == 1) {
                        if (nextY+1<m && grid[nextX][nextY+1]==-1)  {
                            ans[i]=-1;
                            b=!b;
                            break;
        
                        } else {
                            nextX = nextX+1;
                            nextY = nextY+1;
                        }
                    } else {
                        if ((nextY-1>=0 && grid[nextX][nextY-1]==1)) {
                            ans[i]=-1;
                            b=!b;
                            break;
                        } else {
                            nextX = nextX + 1;
                            nextY = nextY - 1;
                        }
                    }
                }
                if (nextX==n) {
                    ans[i] = nextY==m && grid[nextX-1][nextY-1] == 1 ? -1 : nextY;
                } else {
                    ans[i]=-1;
                }
            }
        }
        return ans;
    }
}
