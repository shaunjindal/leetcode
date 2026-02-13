class Solution {
    public int maximumLength(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i: nums) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        int ans = mp.getOrDefault(1, 0);
        ans = ans == 0 ? 0 : (ans % 2 == 0 ? ans - 1 : ans);
        for (Map.Entry<Integer, Integer> i: mp.entrySet()) {
            int c = i.getKey();
            int curr = 0;
            while (c != 1 && mp.containsKey(c) && mp.get(c) > 0) {
                if (mp.get(c) == 1) {
                    ans = Math.max(ans, curr + 1);
                    break;
                } else {
                    ans = Math.max(ans, curr + 1);
                }
                curr = curr + 2;
                c = c*c;
            }
        }
        return ans;
    }
}
