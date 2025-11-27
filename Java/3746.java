class Solution {
    public int minLengthAfterRemovals(String s) {
        int[] a = new int[2];
        for (char c: s.toCharArray()) {
            a[c-'a']++;
        }
        return Math.abs(a[0]-a[1]);
    }
}