class Solution {
    public long maximumImportance(int n, int[][] roads) {
        Integer[] inDeg = new Integer[n];
        Arrays.fill(inDeg, 0);
        for (int[] i: roads) {
            inDeg[i[0]]++;
            inDeg[i[1]]++;
        }
        Arrays.sort(inDeg, Comparator.reverseOrder());
        long ans = 0;
        for (int i: inDeg) {
            ans = ans + (long)i*n;
            n--;
        }
        return ans;
    }
}
