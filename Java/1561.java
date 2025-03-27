class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int ans = 0;
        int c=0;
        int n = piles.length/3;
        for (int i=piles.length-2;i>=0 && c<n;i=i-2) {
            c++;
            ans=ans+piles[i];
        }
        return ans;
    }
}
