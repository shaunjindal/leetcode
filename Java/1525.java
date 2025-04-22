class Solution {
    public int numSplits(String s) {
        int[] c = new int[26];
        Set<Character> st = new HashSet<>();
        for (int i=0;i<s.length();i++) {
            c[s.charAt(i)-'a']++;
            st.add(s.charAt(i));
        }
        Set<Character> st2 = new HashSet<>();
        int ans = 0;
        for (int i=0;i<s.length();i++) {
            st2.add(s.charAt(i));
            c[s.charAt(i)-'a']--;
            if (c[s.charAt(i)-'a'] == 0) {
                st.remove(s.charAt(i));
            }
            if (st.size() == st2.size()) ans++;
        }
        return ans;
    }
}
