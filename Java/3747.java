class Solution {
    public long countDistinct(long n) {
        List<Long> ls = new ArrayList<>();
        long nc = n;
        while(nc>0) {
            ls.add(nc%10);
            nc/=10;
        }
        long ans = 0;
        long[] pow = new long[16];
        pow[0] = 1L;
        for (int j = 1;j<=15;j++) {
            pow[j]= pow[j-1] * 9;
        }
        for (int i = 1; i<=ls.size()-1;i++) {
            ans = ans + pow[i];
        }
        int i =  ls.size()-1;
        for (;i>=0;i--) {
            if (ls.get(i) != 0) {
                ans = ans + (ls.get(i)-1) * pow[i];
            } else {
                break;
            }
        }
        return i == -1 ? ans + 1 : ans;
    }
}
