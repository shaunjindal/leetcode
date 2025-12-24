class Solution {
    public int countElements(int[] nums, int k) {
        if (nums.length == 1) return 1;
        if (k==0) return nums.length;
        Arrays.sort(nums);
        int curr = 0;
        int ans = 0;
        for (int i = nums.length - 2; i>=0; i--) {
            if (nums[i+1] != nums[i]) {
                curr = nums.length - i - 1;
            } 
            if (curr >= k) {
                ans++;
            }
        }
        return ans;
    }
}
