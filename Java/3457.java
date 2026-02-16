class Solution {
    public long maxWeight(int[] pizzas) {
        int n = pizzas.length;
        int days = n/4;
        long ans = 0;

        int numOdd = (days+1)/2;
        int x = n-1;
        int numEven = days - numOdd;
        Arrays.sort(pizzas);
        for (int i=0;i<numOdd;i++) {
                ans = ans + pizzas[x];
                x--;
        }
        x--;
        for(int i=0;i<numEven;i++) {
            ans = ans +pizzas[x];
            x=x-2;
        }
        return ans;
    }
}
