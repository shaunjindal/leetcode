class Solution {
    public int findMaxVal(int n, int[][] restrictions, int[] diff) {
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[0] = 0;

        for (int[] restriction : restrictions) {
            ans[restriction[0]] = restriction[1];
        }
        ans[0] = 0;
        for (int i = 1; i < n; i++) {
            ans[i] = Math.min(ans[i], ans[i-1] + diff[i-1]);
        }
        int val = Integer.MIN_VALUE;
        for (int i = n-2; i>=0; i--){
            ans[i] = Math.min(ans[i], ans[i+1] + diff[i]);
            val = Math.max(val, ans[i]);
        }
        return Math.max(val, ans[n-1]);
    }
}
