class Solution {
    public double averageWaitingTime(int[][] customers) {
        int curr = customers[0][0];
        double ans = 0;

        for (int[] c: customers) {
            if (curr < c[0]) {
                curr = c[0];
            }
            ans = ans + curr-c[0] + c[1];
            curr = curr + c[1];
        }
        return ans/customers.length;
    }
}