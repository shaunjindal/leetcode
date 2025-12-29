class Solution {
    public int largestPrime(int n) {
        boolean[] arr = new boolean[n+1];
        for (int i=2;i*i<=n;i++) {
            if (!arr[i])
                for (int j = i*i; j<=n;j+=i) {
                    arr[j] = true;
                }
        }
        int curr = 0;
        int ans = 0;
        for (int i = 2;i<=n;i++) {
            curr = curr + (!arr[i] ? i : 0);
            if (curr>n) break;
            if (curr<=n && !arr[curr]) {
                ans = Math.max(ans, curr);
            }
        }
        return ans;
    }
}
