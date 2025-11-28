class Solution {
    public long maxAlternatingSum(int[] nums) {
        long ans = 0;
        for (int i=0; i<nums.length;i++) {
            if (nums[i] < 0 ) {
                nums[i] = -1*nums[i];
            }
        }
        Arrays.sort(nums);
        for (int i=0; i<(nums.length/2);i++) {
            ans = ans - ((nums[i] * 1L) * (nums[i] * 1l));
        }
        for (int i=(nums.length/2); i< nums.length;i++) {
            ans = ans + ((nums[i] * 1L) * (nums[i] * 1l));
        }
        return ans;
    }
}
