class Solution {
    public int partitionString(String s) {
        int part1 = 0;
        int ans=0;
        for (int i=0;i<s.length();i++) {
            if ((part1 & (1<<(s.charAt(i) - 'a'))) != 0) {
                part1 = 1<<(s.charAt(i) - 'a');
                ans++;
            }
            else {
                part1 = part1 | (1<<(s.charAt(i) - 'a'));
            }
        }
        return ans+1;
    }
}