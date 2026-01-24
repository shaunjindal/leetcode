class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int sum = 0;
        int sumP = 0;
        int i = 0;
        int k = -1;
        while (i < satisfaction.length) {
            if (satisfaction[i]>=0 && k == -1) {
                k = i;
            }
            if (satisfaction[i]>=0) {
                sum=sum + satisfaction[i]*(i-k+1);
                sumP = sumP + satisfaction[i];
            }
            i++;
        }
        if (sum == 0 || k==-1) return 0;
        if (k == 0) return sum;
        k--;
        int sumN;
        int ans = sum;
        int newSum;
        int times = 0;
        int t = k;
        while (k >=0) {
            sumN = 0;
            for (int j = k;j<=t;j++) {
                sumN = sumN + (j-k+1)*satisfaction[j];
            }
            newSum = sum + sumP*(times+1) + sumN;
            ans = Math.max(ans, newSum);
            times++;
            k--;
        }
        return ans;
    }
}
