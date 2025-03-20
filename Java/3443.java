class Solution {
    public int maxDistance(String s, int k) {
        int currX = 0;
        int currY=0;
        int ans = 0;
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if (ch == 'N') {
                currX++;
            }
            if (ch=='S') {
                currX--;
            }
            if (ch=='E'){
                currY++;
            }
            if(ch=='W'){
                currY--;
            }
            int x = Math.abs(currX)+Math.abs(currY);
            ans = Math.max(x + Math.min(2*k,i+1-x), ans);
        }
        return ans;


    }
}