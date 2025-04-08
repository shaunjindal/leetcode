class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> st = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            for (int j=i+1;j<nums.length;j++) {
                int prod = nums[i]*nums[j];
                st.putIfAbsent(prod, 0);
                st.put(prod,st.get(prod)+1);
            }
        }
        int ans = 0;
        for (int val: st.values()) {
            if (val>=2) {
                ans = ans + (4*(val)*(val-1));
            }
        }
        return ans;
    }
}
