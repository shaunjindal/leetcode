class Solution {

    public int monkeyMove(int n) {
        return (int) ((fastPow(2, n) - 2 + mod)%mod);
    }

    long mod = 1000000007;
    private long fastPow(long base, long pow) {
        long res  = 1;
        while (pow > 0) {
            if (pow % 2 == 1) {
                res = ( (res) * (base) ) % mod;
            }
            base = ( (base) * (base) ) % mod;
            pow = pow/2;
        }
        return res;
    }
}
