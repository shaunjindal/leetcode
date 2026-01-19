class Solution {
    public int centeredSubarrays(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> st = new HashSet<>();
            int sum = 0;
            for (int j=i; j<n;j++) {
                st.add(nums[j]);
                sum+=nums[j];
                if (st.contains(sum)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
