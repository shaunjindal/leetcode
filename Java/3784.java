class Solution {
    public long minCost(String s, int[] cost) {
        long[] freq = new long[26];
        long ans = 0;
        long tot = 0;
        int id = 0;
        for (int i=0;i<s.length();i++) {
            id = s.charAt(i)-'a';
            freq[id] += cost[i];
            tot+=cost[i];
            ans = Math.max(ans, freq[id]);
        }
        return tot - ans;
    }
}
