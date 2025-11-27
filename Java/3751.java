class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans = 0;
        for (int i=num1;i<=num2;i++) {
            ans+=find(i);
        }
        return ans;
    }
    private int find(int num) {
        if (num/100==0) return 0;
        int a = 0;
        while (num/100!=0) {
            if (num%10 > (num/10)%10 && (num/10)%10 < (num/100)%10) {
                a++;
            } else if (num%10 < (num/10)%10 && (num/10)%10 > (num/100)%10) {
                a++;
            }
            num/=10;
        }
        return a;
    }
}