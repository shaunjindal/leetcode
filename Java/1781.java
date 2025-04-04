class Solution {
    private int calcBeauty(int[] freq) {
        int min = 501, max = 0;
        for (int i: freq) {
            if (i!=0) {
                max = Math.max(i, max);
                min = Math.min(i, min);
            }
        }
        if (min == 501 || max ==0) {
            return 0;
        }
        return max-min;
    }
    public int beautySum(String s) {

        int ans = 0;
        for (int i=0;i<s.length();i++) {
            int[] freq = new int[26];
            for (int j=i;j<s.length();j++) {
                freq[s.charAt(j)-'a']+=1;
                ans+=calcBeauty(freq);
            }
        }
        return ans;
    }
}