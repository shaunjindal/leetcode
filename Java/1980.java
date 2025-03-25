class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums[0].length();
        List<Integer> st = new ArrayList<>();
        for (int i=0;i<nums.length;i++) {
            st.add(getNum(nums[i]));
        }
        st.sort(Comparator.naturalOrder());
        if (st.get(0) > 1) {
            return convertToString(1, n);
        }
        int ans = 0;
        for(int i=1;i<st.size();i++) {
            if (st.get(i) != st.get(i-1)+1) {
                ans = st.get(i-1)+1;
                break;
            }
        }
        if (ans==0 && st.contains(0)) {
            ans = st.get(st.size()-1) +1;
        }
        return convertToString(ans, n);
    }
    private int getNum(String i){
        int n=i.length()-1;
        int ans = 0;
        for (int j=0;j<i.length();j++) {
            if (i.charAt(j) == '1') {
                ans = ans + (1<<n);
            }
            n--;
        }
        return ans;
    }

    private String convertToString(int ans, int n) {
        StringBuilder a = new StringBuilder();
        while(ans!=0) {
            int c = ans%2;
            ans/=2;
            if(c==0) {
                a.insert(0, '0');
            } else {
                a.insert(0, '1');
            }
        }
        int x = a.length();
        for (int i=0;i<n-x;i++) {
            a.insert(0, '0');
        }
        return a.toString();
    }
}