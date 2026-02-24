class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        long p0 = 0, p1 = 0, p01 = 0;
        char[] chars = text.toCharArray();
        for (char c: chars) {
            if (c == pattern.charAt(0)) {
                p0++;
            }
            if (c == pattern.charAt(1)) {
                p01 += p0;
                p1++;
            }
        }
        if (pattern.charAt(0) == pattern.charAt(1)) {
            p0++;
            p0 = p0 * (p0 - 1);
            return p0/2;
        }
        return p01 + Math.max(p0, p1);
    }
}
