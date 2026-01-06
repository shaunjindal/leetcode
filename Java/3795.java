class Solution {
    public int minLength(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int i = 0, j = 0, ans = Integer.MAX_VALUE, curr = 0;
        while (i < nums.length) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
            if (mp.get(nums[i]) == 1) {
                curr+=nums[i];
            }
            while (curr >= k && j<=i) {
                if (mp.get(nums[j]) == 1) {
                    curr-=nums[j];
                }
                mp.put(nums[j], mp.getOrDefault(nums[j], 1) - 1);
                ans = Math.min(ans, i-j+1);
                j++;
            }
            i++;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
