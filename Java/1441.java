class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> st = new ArrayList<>();
        int curr = 0;
        int i=0;
        for (i=0;i<target.length;i++) {
            int x = target[i]-curr-1;
            if (x>0) {
                for(int k=0;k<x;k++) {
                    st.add("Push");
                    st.add("Pop");
                }
            }
            curr = target[i];
            st.add("Push");
        }
        return st;
    }
}