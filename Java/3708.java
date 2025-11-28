class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        if (n<=2) return n;
        int ans = 2;
        for (int i=2;i<n;i++) {
            int c = 0;
            while (i<n && nums[i] == nums[i-1] + nums[i-2]) {
                c++;
                i++;
            }
            ans = Math.max(ans, c+2);
        }
        return ans;
    }
}
