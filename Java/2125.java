class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        int ans = 0 ;
        int m = bank[0].length();
        int curr = 0;
        int prev = 0;
        for (int i=0;i<n;i++) {
            curr = 0;
            for (int j=0;j<m;j++) {
                if (bank[i].charAt(j) == '1') {
                    curr++;
                }
            }
            ans = ans + (curr*prev);
            prev = curr == 0 ? prev : curr;
        }
        return ans;
    }
}