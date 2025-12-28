class Solution {
    public long maximumScore(int[] nums) {
        long sum = 0;
        for(int i: nums) {
            sum+=i;
        }
        long ans = Integer.MIN_VALUE;
        long curr = nums[nums.length - 1];
        long currMin = nums[nums.length - 1];
        for (int i = nums.length - 2; i>=0; i--) {
            ans = Math.max(ans, sum - curr - Math.min(currMin, nums[i+1]));
            curr += nums[i];
            currMin = Math.min(currMin, nums[i]);
        }
        return ans;
    }
}
