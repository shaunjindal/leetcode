class Solution {
    int n;
    int m;
    List<List<Integer>> grid;
    boolean[][] vis;
    int[][] dir = {{0,1}, {0,-1}, {1, 0}, {-1, 0}};
    int[][][] ans;

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        n = grid.size();
        m = grid.get(0).size();
        this.grid = grid;
        vis = new boolean[n][m];
        ans = new int[n][m][health+1];
        return helper(0, 0, health - grid.get(0).get(0));
    }
    private boolean helper(int start, int end, int health) {
        if (health < 1) {
            ans[start][end][health] = -1;
            return false;
        }
        if (start == n-1 && end == m-1) {
            ans[start][end][health] = 1;
            return true;
        }
        if (ans[start][end][health] != 0) {
            return ans[start][end][health] == 1;
        }
        vis[start][end] = true;
        boolean curr = false;
        for (int[] d: dir) {
            int newX = start + d[0];
            int newY = end + d[1];
            if (newX>=0 && newX<n && newY>=0 && newY<m && !vis[newX][newY]) {
                curr = curr || helper(newX, newY, health - grid.get(newX).get(newY));
            }
        }
        if (curr) {
            ans[start][end][health] = 1;
        } else {
            ans[start][end][health] = -1;
        }
        vis[start][end] = false;
        return curr;
    }
}
