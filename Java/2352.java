class Solution {
    public String genKey(int... arg) {
        StringBuilder s = new StringBuilder();
        for (int i:arg) {
            s.append(i).append(".");
        }
        return s.toString();
    }
    public int equalPairs(int[][] grid) {
        Map<String, Integer> mp = new HashMap<>();
        String c;
        for(int i=0;i<grid.length;i++) {
            c = genKey(grid[i]);
            if (!mp.containsKey(c)) mp.put(c, 0);
            mp.put(c, mp.get(c)+1);
        }
        StringBuilder s;
        String s1;
        int ans = 0;
        for (int i=0;i<grid.length;i++) {
            s = new StringBuilder();
            for (int j=0;j<grid.length;j++) {
                s.append(grid[j][i]).append(".");
            }
            s1 = s.toString();
            if (mp.containsKey(s1)) {
                ans = ans + mp.get(s1);
            }
        }
        return ans;
    }
}
