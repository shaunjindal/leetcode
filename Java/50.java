class Solution {
    public double myPow(double x, int n) {
        double res = 1;
        boolean neg = n < 0;
        long pown = Math.abs((long) n);
        while (pown>0) {
            if (pown % 2 == 1) {
                res*=x;
            }
            x*=x;
            pown/=2;
        }
        return neg ? 1.0/res : res;
    }
}
