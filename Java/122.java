class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int holdPrice = 0;
        for (int i=1;i<prices.length;i++) {
            if (prices[i] < prices[i-1]) {
                ans = ans + prices[i-1]-prices[holdPrice];
                holdPrice = i;
            }
        }
        return prices[prices.length-1]-prices[holdPrice] + ans;

    }
}
