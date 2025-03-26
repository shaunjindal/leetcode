class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int l=0;
        for (int i=0;i<nums.length;i++) {
            if (nums[i]==x) {
                nums[l] = i;
                l++;
            }
        }
        for (int i=0;i<queries.length;i++) {
            queries[i] = queries[i] > l ? -1 : nums[queries[i]-1];
        }
        return queries;
    }
}