class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        int ans=0;
        int i=0;
        for (i=0;i<n-2;i++) {
            if (nums[i] == 0) {
                nums[i] = 1;
                nums[i+1] ^= 1;
                nums[i+2]^=1;
                ans++;
            }
        }
        if (nums[n-1]==0) {
            return -1;
        }
        if (nums[n-2] == 0) {
            return -1;
        }
        return ans;
        // 111010111
        // 111101111
        // 111110011
        // 111111101

    }
}