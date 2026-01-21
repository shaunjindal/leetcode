class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        int n;
        for (int i=0;i<nums.size();i++) {
            n = nums.get(i);
            if (n == 2) {
                ans[i] = -1;
            } else if ((n&3)==3) {
                if (((n)&(n+1)) == 0) {
                    ans[i] = n>>1;
                } else {
                    int c = n;
                    int cc = 0;
                    while (c%2!=0) {
                        cc++;
                        c = c>>1;
                    }
                    cc--;
                    ans[i] = n&(~(1<<cc));
                }
                
            } else {
                ans[i] = n - 1;
            }
        }
        return ans;
    }
}
