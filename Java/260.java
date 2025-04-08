class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int n: nums) {
            xor^=n;
        }
        int[] ans = new int[2];
        for (int n:nums) {
            if ((n & (xor & (-xor))) == 0) {
                ans[0]^=n;
            } else  {
                ans[1]^=n;
            }
        }
        return ans;
    }
}
