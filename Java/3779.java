class Solution {
    public int minOperations(int[] nums) {
        Set<Integer> s = new HashSet<>();
        int i = nums.length-1;
        while (i>=0 && !s.contains(nums[i])) {
            s.add(nums[i]);
            i--;
        }
        return i>=0 ? i/3 + 1 : 0;
    }
}
