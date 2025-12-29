class Solution {
    public long minMoves(int[] balance) {
        long ans = 0;
        int i = 0;
        for (;i<balance.length;i++) {
            if (balance[i] < 0) {
                break;
            }
        }
        if (i == balance.length) return 0;
        int tot;
        for (int j=1;j<=balance.length/2;j++) {
            tot = (i+j) % (balance.length) != (i-j + balance.length) % (balance.length) ? balance[(i+j) % (balance.length)] + balance[(i-j + balance.length) % (balance.length)] : balance[(i+j) % (balance.length)];
            ans += (((long)j)*Math.min((long)tot, Math.abs((long)balance[i])));
            balance[i] += tot;
            if (balance[i] >= 0) break;
            balance[(i+j) % (balance.length)] = 0;
            balance[(i-j + balance.length) % (balance.length)] = 0;
        }
        return balance[i] < 0 ? -1 : ans;
    }
}
