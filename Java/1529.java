class Solution {
    public int minFlips(String target) {
        int i=0;
        int ans = 0;
        int n = target.length();
        while(i<n && target.charAt(i) == '0') {
            i++;
        }
        if (i<n) ans++;
        while (i<n) {
            while(i<n && target.charAt(i) == '1') {
                i++;
            }
            if (i<n) ans++;
            while(i<n && target.charAt(i) == '0') {
                i++;
            }
            if (i<n) ans++;
        }
        return ans;
    }
}