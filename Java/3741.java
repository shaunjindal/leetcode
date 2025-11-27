import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, int[]> mp = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for (int i=0;i<nums.length;i++) {
            if (!mp.containsKey(nums[i])) {
                mp.put(nums[i], new int[]{-1,-1,-1});
            }
            int[] a = mp.get(nums[i]);
            if (a[0] == -1) {
                a[0] = i;
            } else if (a[1] == -1) {
                a[1] = i;
            } else if (a[2] == -1) {
                a[2] = i;
                ans = Math.min(ans, a[2] -a[0] + a[2] - a[0]);
                a[0] = a[1];
                a[1] = a[2];
                a[2] = -1;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
