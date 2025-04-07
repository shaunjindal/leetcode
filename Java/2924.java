class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] indeg = new int[n];
        for (int[] i: edges) {
            indeg[i[1]]+=1;
        }
        int ans = -1;
        for (int i=0;i<n;i++) {
            if (indeg[i]==0) {
                if (ans == -1) {
                    ans = i;
                } else {
                    return -1;
                }
            }
        }
        return ans;
    }
}