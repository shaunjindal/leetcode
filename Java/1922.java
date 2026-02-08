class Solution {
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

    public int countGoodNumbers(long n) {
        return (int) (((fastPow(4L, n/2) ) * (fastPow(5L, (n+1)/2) )) % mod);
    }
}
