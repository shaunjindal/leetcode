class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > 9*num) return "";
        StringBuilder ans = new StringBuilder();
        int n = sum / 9;
        int m = sum - n*9;
        while (n>0) {
            n--;
            ans.append("9");
        }
        if (m > 0) {
            n++;
            ans.append(m);
        }
        n = n + (sum/9);
        while (n<num) {
            n++;
            ans.append("0");
        }
        return ans.toString();
    }
}
